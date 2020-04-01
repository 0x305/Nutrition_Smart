package com.example.nutritionsmart;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList extends AppCompatActivity {

    final List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        Intent intent = getIntent();

        final ListView list_view = findViewById(R.id.list_view);

        final TextAdapter adapter = new TextAdapter();

        readInfo();

        adapter.setData(list);
        list_view.setAdapter(adapter);


        //removing items
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id){
                AlertDialog dialog = new AlertDialog.Builder(ShoppingList.this)
                        .setTitle("Remove Item?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                list.remove(position);
                                adapter.setData(list);
                            }
                        })
                        .setNegativeButton("No", null)
                        .create();
                dialog.show();
            }
        });

        final Button newItemButton = findViewById(R.id.newItemButton);

        newItemButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v ){
                final EditText taskInput = new EditText(ShoppingList.this);
                taskInput.setSingleLine();
                AlertDialog dialog = new AlertDialog.Builder(ShoppingList.this)
                        .setTitle("Add a new Item")
                        .setMessage("What is your new Item?")
                        .setView(taskInput)
                        .setPositiveButton("Add new Item", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list.add(taskInput.getText().toString());
                                adapter.setData(list);
                            }
                        })
                        .setNegativeButton("Delete", null)
                        .create();
                dialog.show();
            }
        });

    }

    public void homeClicked(View view ){

        startActivity(new Intent(ShoppingList.this, MainActivity.class));
    }

    @Override
    protected void onPause(){
        super.onPause();
        saveInfo();
    }

    private void saveInfo(){
        try{

            File file = new File(this.getFilesDir(), "save");

            FileOutputStream fOut = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fOut));

            for(int i = 0; i < list.size(); i++){
                bw.write(list.get(i));
                bw.newLine();
            }

            bw.close();
            fOut.close();

        }catch(Exception e ){
            e.printStackTrace();
        }
    }

    private void readInfo(){
        File file = new File(this.getFilesDir(), "save");
        if(!file.exists()){
            return;
        }

        try{

            FileInputStream is = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = reader.readLine();
            while(line != null){
                list.add(line);
                line = reader.readLine();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    class TextAdapter  extends BaseAdapter {


        List<String> list = new ArrayList<>();

        void setData(List<String> mList){
            list.clear();
            list.addAll(mList);
            notifyDataSetChanged();
        }

        @Override
        public int getCount(){
            return list.size();
        }

        @Override
        public Object getItem(int position){
            return null;
        }

        @Override
        public long getItemId(int position){
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater)
                    ShoppingList.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            View rowView = inflater.inflate(R.layout.item, parent, false);
            TextView textView = rowView.findViewById(R.id.task);
            textView.setText(list.get(position));

            return rowView;

        }
    }

}

