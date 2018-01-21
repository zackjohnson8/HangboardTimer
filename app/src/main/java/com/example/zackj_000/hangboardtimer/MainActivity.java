package com.example.zackj_000.hangboardtimer;

import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewTreeObserver;
import android.widget.Button;

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

    }

    @Override
    public void onClick(View v)
    {

        switch(v.getId())
        {
            case R.id.button1:
                buttonUpperLeft.setBackgroundColor(Color.BLUE);
                setContentView(R.layout.activity_interval_training);
                break;
            case R.id.button2:
                buttonUpperRight.setBackgroundColor(Color.BLUE);
                break;
            case R.id.button3:
                buttonBottomLeft.setBackgroundColor(Color.BLUE);
                break;
            case R.id.button4:
                buttonBottomRight.setBackgroundColor(Color.BLUE);
                break;
            default:
                break;

        }

    }
}
