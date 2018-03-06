package com.example.zackj_000.hangboardtimer;

import android.content.Intent;
import android.app.ActionBar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Typeface;
import android.graphics.Color;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonUpperLeft;
    private Button buttonUpperRight;
    private Button buttonBottomLeft;
    private Button buttonBottomRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonUpperLeft = findViewById(R.id.button1);
        buttonUpperRight = findViewById(R.id.button2);
        buttonBottomLeft = findViewById(R.id.button3);
        buttonBottomRight = findViewById(R.id.button4);

        //View constraintLayout = findViewById(R.id.Layout_Constraint);
        //constraintLayout.setBackgroundColor(Color.parseColor("#000000"));

        buttonUpperLeft.setOnClickListener(this);
        buttonUpperRight.setOnClickListener(this);
        buttonBottomLeft.setOnClickListener(this);
        buttonBottomRight.setOnClickListener(this);



        TextView tv = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(lp);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        tv.setText("Hangboard Tracker");
        tv.setTextColor(Color.parseColor("#FFFFFF"));
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/VollkornItalic.ttf");
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
                /*
                Intent IntervalTraining = new Intent(MainActivity.this, IntervalTraining.class);
                startActivity(IntervalTraining);
                */
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
}
