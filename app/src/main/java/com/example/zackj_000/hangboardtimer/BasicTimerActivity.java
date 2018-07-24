package com.example.zackj_000.hangboardtimer;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

//AppCompatActivity
public class BasicTimerActivity extends AppCompatActivity implements View.OnClickListener
{

    private Button buttonStart;
    private Button buttonStop;
    private ImageButton buttonHome;
    private TextView clockTimeText;
    Handler customHandler = new Handler();


    int extraMinutesTest = 0;
    long startTime = 0L;
    long timeInMilli = 0L;
    long timeSwapBuff = 0L;
    long updateTime = 0L;
    boolean timerRunning = false;

    Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            timeInMilli = SystemClock.uptimeMillis()-startTime;
            updateTime = timeSwapBuff+timeInMilli;
            int secs = (int)updateTime/1000;
            int mins=(secs/60)+extraMinutesTest;
            secs%=60;
            int milliseconds = (int)(updateTime%1000);


            clockTimeText.setText(""+mins+":"+String.format("%02d",secs)+"."+String.format("%03d",milliseconds));
            customHandler.postDelayed(this,0);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_timer);

        buttonStart = findViewById(R.id.basicTimerButtonStart);
        buttonStop = findViewById(R.id.basicTimerButtonStop);
        buttonHome = findViewById(R.id.buttonHome);
        clockTimeText = findViewById(R.id.basicTimerCountTextView);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonHome.setOnClickListener(this);

        TextView tv = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(lp);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        tv.setText("Stop Watch");
        tv.setTextColor(Color.parseColor("#FFFFFF"));
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/VollkornRegular.ttf");
        tv.setTypeface(typeface);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(tv);

    }


    @Override
    public void onClick(View v)
    {

        switch(v.getId())
        {

            case R.id.buttonHome:
                Intent BasicTimerTrainer = new Intent(BasicTimerActivity.this, MainActivity.class);
                startActivity(BasicTimerTrainer);
                break;

            case R.id.basicTimerButtonStart:
                if(!timerRunning) {
                    timerRunning = !timerRunning;
                    buttonStop.setText("PAUSE");
                    startTimer();
                }else
                {
                    clearTimer();
                    startTimer();
                }
                //Intent MainActivity = new Intent(BasicTimerActivity.this, MainActivity.class);
                //startActivity(MainActivity);
                break;

            case R.id.basicTimerButtonStop:
                if(timerRunning) {
                    timerRunning = !timerRunning;
                    buttonStop.setText("RESET");
                    stopTimer();
                }else
                {
                    clearTimer();
                    clockTimeText.setText("0:00.000");
                }
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

    private void clearTimer()
    {

        startTime = 0L;
        timeInMilli = 0L;
        timeSwapBuff = 0L;
        updateTime = 0L;

    }


}
