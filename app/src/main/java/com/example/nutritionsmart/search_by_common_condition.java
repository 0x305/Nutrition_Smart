package com.example.nutritionsmart;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class search_by_common_condition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_common_condition);
        CheckBox checkbox1 = (CheckBox) findViewById(R.id.checkBox);
        if ((checkbox1).isChecked())
            startActivity(new Intent(search_by_common_condition.this, recommendations_for_medical_condition.class));

    }

    public void homeClicked(View view ){

        startActivity(new Intent(search_by_common_condition.this, MainActivity.class));
    }

    public void submitClicked(View view ){

       // CheckBox checkbox1 = (CheckBox) findViewById(R.id.checkBox);
    //    if ((checkbox1).isChecked())
            startActivity(new Intent(search_by_common_condition.this, recommendations_for_medical_condition.class));
     //   if ((checkbox1).isChecked())
      //      startActivity(new Intent(search_by_common_condition.this, recommendations_for_medical_condition.class));

    }

}
