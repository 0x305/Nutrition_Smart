package com.example.nutritionsmart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhandler extends SQLiteOpenHelper  {

    public static final String DB_NAME = "Nutrition";

    public static final String TABLE_NAME = "Food_Items";
    public static final String COLUMN_ID = "Item_Number";
    public static final String COLUMN_NAME = "Item_Name";
    public static final String COLUMN_CALORIES = "Item_Calories";
    public static final String COLUMN_ISVEGAN = "Is_Vegan";
    public static final String COLUMN_ISVEGETARIAN = "Is_Vegetarian";
    public static final String COLUMN_PRICE = "Item_Price";

    public static final String TABLE_NAME2 = "Stored_Items";
    public static final String COLUMN_ID2 = "Stored_Number";
    public static final String COLUMN_SECONDARY = "Info_Number"; //this will be the key from item table so easy to pull all the attributes

    public static final String TABLE_NAME3 = "Cart_Items";
    public static final String COLUMN_ID3 = "Cart_Number";
    public static final String COLUMN_SECONDARY2 = "Info_Number";

    public static final int DB_VERSION = 1;

    public DBhandler(Context context){
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ COLUMN_NAME + " VARCHAR, " + COLUMN_CALORIES
                + " VARCHAR, " + COLUMN_ISVEGAN + " VARCHAR, " + COLUMN_ISVEGETARIAN + " VARCHAR, " + COLUMN_PRICE + " VARCHAR)";

        String sql2 = "CREATE TABLE " + TABLE_NAME2 + " (" + COLUMN_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_SECONDARY + " VARCHAR)";

        String sql3 = "CREATE TABLE " + TABLE_NAME3 + " (" + COLUMN_ID3 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_SECONDARY2 + " VARCHAR)";

        db.execSQL(sql);
        db.execSQL(sql2);
        db.execSQL(sql3);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS  " + TABLE_NAME;
        String sql2 = "DROP TABLE IF EXISTS " + TABLE_NAME2;
        String sql3 = "DROP TABLE IF EXISTS " + TABLE_NAME3;

        db.execSQL(sql);
        db.execSQL(sql2);
        db.execSQL(sql3);

        onCreate(db);

    }
}
