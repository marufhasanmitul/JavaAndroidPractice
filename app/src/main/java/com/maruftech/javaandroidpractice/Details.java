package com.maruftech.javaandroidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    ImageView detailsCover;
    TextView detailsTitle,detailsDescription;

    public static String TITLE="";
    public static String DESCRIPTION="";
    public static Bitmap MY_BITMAP=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        detailsCover=findViewById(R.id.detailsCover);
        detailsTitle=findViewById(R.id.detailsTitle);
        detailsDescription=findViewById(R.id.detailsDescription);


        detailsTitle.setText(TITLE);
        detailsTitle.setText(DESCRIPTION);


        if(MY_BITMAP!=null ){
            detailsCover.setImageBitmap(MY_BITMAP);
        }


    }
}