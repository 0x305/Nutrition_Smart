package com.example.nutritionsmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
}
