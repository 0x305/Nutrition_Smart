package com.example.nutritionsmart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class reminders extends AppCompatActivity {

    Button btnTimePicker1;
    Button btnTimePicker2;
    Button btnTimePicker3;
    Button btnTimePicker4;
    EditText txtTime1, txtTime2, txtTime3, txtTime4;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);

        btnTimePicker1=(Button)findViewById(R.id.spinner1);
        btnTimePicker2=(Button)findViewById(R.id.spinner2);
        btnTimePicker3=(Button)findViewById(R.id.spinner3);
        btnTimePicker4=(Button)findViewById(R.id.spinner4);

        txtTime1=(EditText)findViewById(R.id.editText3);
        txtTime2=(EditText)findViewById(R.id.editText8);
        txtTime3=(EditText)findViewById(R.id.editText9);
        txtTime4=(EditText)findViewById(R.id.editText10);


        //btnTimePicker1.setOnClickListener((View.OnClickListener) this);
        //btnTimePicker2.setOnClickListener((View.OnClickListener) this);
        //btnTimePicker3.setOnClickListener((View.OnClickListener) this);
        //btnTimePicker4.setOnClickListener((View.OnClickListener) this);
    }

    public void homeClicked(View view){
        startActivity(new Intent(reminders.this, MainActivity.class));
    }

    public void searchClicked(View view){
        startActivity(new Intent(reminders.this, GeneralSearch.class));
    }

    public void listClicked(View view){
        startActivity(new Intent(reminders.this, ShoppingList.class));
    }

    public void submitClicked(View view){
        messageDisplay("", "You will be reminded to eat your food items at the times you listed :)");
    }

    public void timeClicked1(View view){
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        txtTime1.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    public void timeClicked2(View view){
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        txtTime2.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    public void timeClicked3(View view){
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        txtTime3.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    public void timeClicked4(View view){
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        txtTime4.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    public void messageDisplay(String title, String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);

        builder.setTitle(title);
        builder.setMessage(message);

        builder.show();


    }

}
