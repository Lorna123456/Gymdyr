package com.example.edwinharen.gymdyr;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
/**
 * Created by EdwinHaren on 29/04/2016.
 */
public class Timer extends Activity {

        private Button startButton;
        private Button pauseButton;
        private Button resetButton;

        private TextView timerValue;

        private long startTime = 0L;

        private Handler customHandler = new Handler();

        long timeInMilliseconds = 0L;
        long timeSwapBuff = 0L;
        long updatedTime = 0L;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.timer_layout);

            timerValue = (TextView) findViewById(R.id.timerValue);

            startButton = (Button) findViewById(R.id.startButton);

            startButton.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {
                    startTime = SystemClock.uptimeMillis();
                    customHandler.postDelayed(updateTimerThread, 0);

                }
            });

            pauseButton = (Button) findViewById(R.id.pauseButton);

            pauseButton.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {

                    timeSwapBuff += timeInMilliseconds;
                    customHandler.removeCallbacks(updateTimerThread);

                }
            });
            resetButton = (Button) findViewById(R.id.resetButton);

            resetButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    log("Entered resetButton.OnClickListener.onClick()");

                    resetToDefault();

                }

                private void log(String s) {
                }
            });


        }

        private void resetToDefault() {int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;int milliseconds = (int) (updatedTime % 1000);
            timerValue.setText("00:00:00");
        }

        private Runnable updateTimerThread = new Runnable() {

            public void run() {

                timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

                updatedTime = timeSwapBuff + timeInMilliseconds;

                int secs = (int) (updatedTime / 1000);
                int mins = secs / 60;
                secs = secs % 60;
                int milliseconds = (int) (updatedTime % 1000);
                timerValue.setText("" + mins + ":"
                        + String.format("%02d", secs) + ":"
                        + String.format("%03d", milliseconds));
                customHandler.postDelayed(this, 0);
            }

        };

    }





