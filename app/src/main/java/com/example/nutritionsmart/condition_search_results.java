package com.example.nutritionsmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.AlertDialog;

public class condition_search_results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition_search_results);
    }

    public void backClicked(View view){
        finish();
    }

    public void homeClicked(View view){
        startActivity(new Intent(condition_search_results.this, MainActivity.class));
    }


    public void listClicked(View view){
        startActivity(new Intent(condition_search_results.this, ShoppingList.class));
    }

    public void add(View view){
        messageDisplay("", "Item was added to created shopping list");
    }

    public void view(View view){
        messageDisplay("", "This will lead to the screen displaying the nutrition facts of the item");
    }

    public void messageDisplay(String title, String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);

        builder.setTitle(title);
        builder.setMessage(message);

        builder.show();


    }
}
