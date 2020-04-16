package com.example.nutritionsmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;

public class condition12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition12);
    }

    public void backClicked(View view){
        finish();
    }

    public void searchClicked(View view){
        startActivity(new Intent(condition12.this, condition_search_results.class));
    }

    public void homeClicked(View view){
        startActivity(new Intent(condition12.this, MainActivity.class));
    }

    public void whichChoice(View view){

        CheckBox hbp = (CheckBox) findViewById(R.id.checkBox7);
        CheckBox d = (CheckBox) findViewById(R.id.checkBox9);
        CheckBox chf = (CheckBox) findViewById(R.id.checkBox10);
        if ((hbp).isChecked()&& (d).isChecked() && (chf).isChecked())
            startActivity(new Intent(condition12.this, condition123.class));
        else if ((hbp).isChecked()&& (chf).isChecked())
            startActivity(new Intent(condition12.this, condition13.class));
        else if ((hbp).isChecked()&& (d).isChecked())
            startActivity(new Intent(condition12.this, condition12.class));
        else if ((hbp).isChecked())
            startActivity(new Intent(condition12.this, condition1.class));
        else if ((d).isChecked()&& (chf).isChecked())
            startActivity(new Intent(condition12.this, condition23.class));
        else if ((d).isChecked())
            startActivity(new Intent(condition12.this, condition2.class));
        else if ((chf).isChecked())
            startActivity(new Intent(condition12.this, condition3.class));
        else
            startActivity(new Intent(condition12.this, condition0.class));
    }
}
