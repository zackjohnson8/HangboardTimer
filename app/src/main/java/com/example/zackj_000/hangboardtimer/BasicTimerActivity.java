package com.example.zackj_000.hangboardtimer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.TextView;

public class BasicTimerActivity extends Activity implements View.OnClickListener
{

    private Button buttonStart;
    private TextView clockTimeText;
    Handler customHandler = new Handler();

    long startTime = 0L;
    long timeInMilli = 0L;
    long timeSwapBuff = 0L;
    long updateTime = 0L;

    Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            timeInMilli = SystemClock.uptimeMillis()-startTime;
            updateTime = timeSwapBuff+timeInMilli;
            int secs = (int)updateTime/1000;
            int mins=secs/60;
            secs%=60;
            int milliseconds = (int)(updateTime%1000);


            clockTimeText.setText(""+mins+":"+String.format("%02d",secs)+":"+String.format("%03d",milliseconds));
            customHandler.postDelayed(this,0);
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_timer);

        buttonStart = findViewById(R.id.basicTimerButtonStart);
        clockTimeText = findViewById(R.id.basicTimerCountTextView);

        buttonStart.setOnClickListener(this);

    }


    @Override
    public void onClick(View v)
    {

        switch(v.getId())
        {
            case R.id.basicTimerButtonStart:
                startTimer();
                //Intent MainActivity = new Intent(BasicTimerActivity.this, MainActivity.class);
                //startActivity(MainActivity);
                break;

            case R.id.basicTimerButtonStop:
                stopTimer();
                break;
            default:
                break;
        }

    }

    private void startTimer()
    {

        startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimerThread,0);

    }

    private void stopTimer()
    {

        timeSwapBuff+=timeInMilli;
        customHandler.removeCallbacks(updateTimerThread);

    }


}
