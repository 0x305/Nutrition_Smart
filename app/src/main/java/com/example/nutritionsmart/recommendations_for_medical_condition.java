package com.example.nutritionsmart;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class recommendations_for_medical_condition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations_for_medical_condition);
    }

    public void backClicked(View view){
        finish();
    }

    public void searchClicked(View view){
        startActivity(new Intent(recommendations_for_medical_condition.this, condition_search_results.class));
    }

    public void homeClicked(View view){
        startActivity(new Intent(recommendations_for_medical_condition.this, MainActivity.class));
    }
}
