package com.example.nutritionsmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class search_by_common_condition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_common_condition);
    }

    public void homeClicked(View view ){

        startActivity(new Intent(search_by_common_condition.this, MainActivity.class));
    }

    public void submitClicked(View view ){

        startActivity(new Intent(search_by_common_condition.this, recommendations_for_medical_condition.class));
    }

}
