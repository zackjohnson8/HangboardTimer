package com.example.zackj_000.hangboardtimer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//TODO(ZACK): Build out the directory buttons into a bottom layout.
//AppCompatActivity
public class BasicTimerActivity extends Activity implements View.OnClickListener
{

    private Button buttonStart;
    private Button buttonStop;
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
        clockTimeText = findViewById(R.id.basicTimerCountTextView);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);

    }


    @Override
    public void onClick(View v)
    {

        switch(v.getId())
        {
            case R.id.basicTimerButtonStart:
                if(!timerRunning) {
                    timerRunning = !timerRunning;
                    buttonStop.setText("STOP");
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
