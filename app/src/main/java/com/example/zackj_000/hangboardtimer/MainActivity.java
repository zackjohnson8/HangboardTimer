package com.example.zackj_000.hangboardtimer;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static int config_waitTime;

    private Button buttonUpperLeft;
    private Button buttonUpperRight;
    private Button buttonBottomLeft;
    private Button buttonBottomRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        config_waitTime = 5; // TODO: hardcoded wait time; change to JSON file http://tonylukasavage.com/blog/2011/06/03/handling-global-configuration-in-android/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonUpperLeft = findViewById(R.id.button1);
        buttonUpperRight = findViewById(R.id.button2);
        buttonBottomLeft = findViewById(R.id.button3);
        buttonBottomRight = findViewById(R.id.button4);

        buttonUpperLeft.setOnClickListener(this);
        buttonUpperRight.setOnClickListener(this);
        buttonBottomLeft.setOnClickListener(this);
        buttonBottomRight.setOnClickListener(this);

        // Modify button font family
        Button txt = findViewById(R.id.button1);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/VollkornRegular.ttf");
        txt.setTypeface(font);

        txt = findViewById(R.id.button2);
        font = Typeface.createFromAsset(getAssets(), "fonts/VollkornRegular.ttf");
        txt.setTypeface(font);

        txt = findViewById(R.id.button3);
        font = Typeface.createFromAsset(getAssets(), "fonts/VollkornRegular.ttf");
        txt.setTypeface(font);

        txt = findViewById(R.id.button4);
        font = Typeface.createFromAsset(getAssets(), "fonts/VollkornRegular.ttf");
        txt.setTypeface(font);

        // Font family and options for upper title bar
        TextView tv = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(lp);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        tv.setText("Hangboard Tracker");
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
            case R.id.button1:

                Intent IntervalTraining = new Intent(MainActivity.this, IntervalTraining.class);
                startActivity(IntervalTraining);

                break;
            case R.id.button2:
                /*
                Intent WeightTrainingActivity = new Intent(MainActivity.this, WeightTraining.class);
                startActivity(WeightTrainingActivity);
                */
                break;
            case R.id.button3:
                /*
                Intent WeightedHangTrainingActivity = new Intent(MainActivity.this, WeightedHangTraining.class);
                startActivity(WeightedHangTrainingActivity);
                */
                break;
            case R.id.button4:
                Intent BasicTimerTrainer = new Intent(MainActivity.this, BasicTimerActivity.class);
                startActivity(BasicTimerTrainer);
                break;
            default:
                break;

        }

    }

    public static void setConfigWaitTime (int value)
    {
        if(value >= 0)
        {
            config_waitTime = value;
        }
    }

    public static int getConfigWaitTime ()
    {
        return config_waitTime;
    }

}
