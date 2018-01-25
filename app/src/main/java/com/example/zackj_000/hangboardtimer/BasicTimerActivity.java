package com.example.zackj_000.hangboardtimer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class BasicTimerActivity extends Activity implements View.OnClickListener
{

    private Button buttonStart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_timer);

        buttonStart = findViewById(R.id.basicTimerButtonStart);
        //buttonStart.setOnClickListener(this);

        buttonStart.setOnClickListener(this);

    }


    @Override
    public void onClick(View v)
    {

        switch(v.getId())
        {
            case R.id.basicTimerButtonStart:
                startTimer();
                //buttonStart.setBackgroundColor(Color.BLUE);
                //Intent to go back
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


    }

    private void stopTimer()
    {


    }


}
