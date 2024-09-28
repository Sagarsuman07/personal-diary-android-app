package com.mitwpu.posdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class dashboard extends AppCompatActivity
{
    ImageView calender;
    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);

        calender=findViewById(R.id.imageView4);
        profile=findViewById(R.id.imageView6);

        calender.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent =new  Intent(dashboard.this,calenderr.class);
                startActivity(intent);

            }
        });

        profile.setOnClickListener(new View.OnClickListener()
        {
           @Override
           public void onClick(View view)
           {
               Intent intent=new Intent(dashboard.this,profile.class);
               startActivity(intent);
           }
        });




        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );

    }
}