package com.example.newyorkapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detail_Activity extends AppCompatActivity {

    private ImageView imageView3;
    private TextView title;
    private TextView by;
    private TextView headLine;
    private TextView date;
    private TextView summary;
    String title2,byLine,headLine2,publicationDate,desc,image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView3 = findViewById(R.id.imageView3);
        title = findViewById(R.id.title2);
        by = findViewById(R.id.by);
        headLine = findViewById(R.id.headLine2);
        date = findViewById(R.id.date2);
        summary = findViewById(R.id.summary);
    }
    private void getData(){

        if (getIntent().hasExtra("title") &&
                getIntent().hasExtra("byline")){
            title2= getIntent().getStringExtra("title");
            title2= getIntent().getStringExtra("title");
            title2= getIntent().getStringExtra("title");
            title2= getIntent().getStringExtra("title");
            title2= getIntent().getStringExtra("title");
            title2= getIntent().getStringExtra("title");
        }
        else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }
}