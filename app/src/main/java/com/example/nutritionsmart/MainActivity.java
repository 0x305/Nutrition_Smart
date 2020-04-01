package com.example.nutritionsmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.List);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                openList();
            }
        });

    }

    public void openList(){
        Intent intent = new Intent(this, ShoppingList.class);
        startActivity(intent);
    }

    public void searchByMedicalClicked(View view){
        startActivity(new Intent(MainActivity.this, search_by_common_condition.class));
    }

    public void searchClicked(View view ){

        startActivity(new Intent(MainActivity.this, GeneralSearch.class));
    }




}
