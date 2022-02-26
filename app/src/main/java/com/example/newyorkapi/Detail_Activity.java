package com.example.newyorkapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

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
        getData();
        setData();
    }
    private void getData(){

        if (getIntent().hasExtra("title") &&
                getIntent().hasExtra("byLine")){
            title2= getIntent().getStringExtra("title");
            byLine= getIntent().getStringExtra("byLine");
            headLine2= getIntent().getStringExtra("headLine");
            publicationDate= getIntent().getStringExtra("publicationDate");
            desc= getIntent().getStringExtra("desc");
            if (!getIntent().hasExtra("url")){
                image = "default";
            }
            else{
                image= getIntent().getStringExtra("url");
            }
        }
        else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData() {
        title.setText(title2);
        by.setText(byLine);
        headLine.setText(headLine2);
        date.setText(publicationDate);
        summary.setText(desc);
        if (image.equals("default")){
            imageView3.setImageResource(R.drawable.nytlogo1);
        }
        else{
            Picasso.get().load(image)
                    .fit()
                    .centerCrop()
                    .into(imageView3);
        }

    }
}