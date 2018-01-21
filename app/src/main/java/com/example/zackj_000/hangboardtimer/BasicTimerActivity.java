package com.example.zackj_000.hangboardtimer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class BasicTimerActivity extends Activity
{

    private Button buttonStart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_timer);

        Log.d("DEBUG", "HOW ABOUT NOW?");

        buttonStart = findViewById(R.id.buttonStart);
        //buttonStart.setOnClickListener(this);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStart.setBackgroundColor(Color.BLUE);
            }
        });
    }

    /*
    @Override
    public void onClick(View v)
    {

        switch(v.getId())
        {
            case R.id.buttonStart:
                buttonStart.setBackgroundColor(Color.BLUE);
                Log.d("DEBUG","The button was clicked");
                break;

            default:
                break;
        }

    }
    */

}
