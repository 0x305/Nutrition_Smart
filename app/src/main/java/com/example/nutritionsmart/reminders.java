package com.example.nutritionsmart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class reminders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);
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

    public void messageDisplay(String title, String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);

        builder.setTitle(title);
        builder.setMessage(message);

        builder.show();


    }
}
