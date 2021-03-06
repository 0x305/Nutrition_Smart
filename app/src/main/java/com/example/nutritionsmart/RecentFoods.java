package com.example.nutritionsmart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RecentFoods extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Wendy's Single Dave","McDonald's Hamburger","Burger King's Hamburger"};
    String mDescription[] ={"3/29/2020","3/31/2020","4/1/2020"};
    int images[] = {R.drawable.wendys,R.drawable.mcds,R.drawable.bkings};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_foods);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter( this, mTitle,mDescription, images);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                if(position ==0){
                    //Toast.makeText(RecentFoods.this,"A hamburger",Toast.LENGTH_SHORT).show();
                    startActivity( new Intent(RecentFoods.this, Hamburger1.class ));
                }
                if(position ==1){
                    Toast.makeText(RecentFoods.this,"Also a hamburger",Toast.LENGTH_SHORT).show();
                }
                if(position ==2){
                    Toast.makeText(RecentFoods.this,"Yet another hamburger",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void homeClicked(View view){
       startActivity(new Intent(RecentFoods.this, MainActivity.class));
    }
   // public void hammyClicked(View view){
     //   startActivity( new Intent(RecentFoods.this, Hamburger1.class ));
    //}

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String[] rTitle;
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]){
            super(c,R.layout.row,R.id.textView1,title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
}
