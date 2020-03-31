package com.example.nutritionsmart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static android.app.PendingIntent.getActivity;

public class GeneralSearch extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_search);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(GeneralSearch.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.filters));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void homeClicked(View view ){

        startActivity(new Intent(GeneralSearch.this, MainActivity.class));
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        messageDisplay("", "Items will be ordered by selected filter");
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


    public void itemSearched(View view){
        messageDisplay("", "Items that are similar to the input will be displayed");
    }

    public void messageDisplay(String title, String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);

        builder.setTitle(title);
        builder.setMessage(message);

        builder.show();


    }


}
