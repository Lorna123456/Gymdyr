package com.example.edwinharen.gymdyr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton advanceToBMI = (ImageButton) findViewById(R.id.imageButton2);
        advanceToBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startNewActivity = new Intent(MainActivity.this, BMI.class);
                startActivity(startNewActivity);


            }
        });

            ImageButton advanceToTIMER = (ImageButton) findViewById(R.id.imageButton4);
            advanceToTIMER.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View view){
                Intent startNewActivity = new Intent(MainActivity.this, Timer.class);
                startActivity(startNewActivity);
            }
            }

        );

        ImageButton advanceToAndroidMediaPlayer = (ImageButton) findViewById(R.id.imageButton4);
        advanceToAndroidMediaPlayer.setOnClickListener(new View.OnClickListener()

                                                       {
                                                           @Override
                                                           public void onClick(View view) {
                                                               Intent startNewActivity = new Intent(MainActivity.this, MediaPlayer.class);
                                                               startActivity(startNewActivity);
                                                           }
                                                       }

        );

        ImageButton advanceToGallaryActivity = (ImageButton) findViewById(R.id.imageButton4);
        advanceToGallaryActivity.setOnClickListener(new View.OnClickListener()

                                          {
                                              @Override
                                              public void onClick(View view) {
                                                  Intent startNewActivity = new Intent(MainActivity.this, GallaryActivity.class);
                                                  startActivity(startNewActivity);
                                              }
                                          }

        );

    }
}