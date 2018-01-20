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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonUpperLeft = findViewById(R.id.button1);
        Button buttonUpperRight = findViewById(R.id.button2);
        Button buttonBottomLeft = findViewById(R.id.button3);
        Button buttonBottomRight = findViewById(R.id.button4);
        View constraintLayout = findViewById(R.id.Layout_Constraint);

        buttonUpperLeft.setBackgroundColor(Color.BLUE);
        buttonUpperRight.setBackgroundColor(Color.BLUE);
        buttonBottomLeft.setBackgroundColor(Color.BLUE);
        buttonBottomRight.setBackgroundColor(Color.BLUE);



        // Get Screen size
        Display displaySize = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        displaySize.getSize(size);

        int maxX = size.x;
        int maxY = size.y;

        Log.d("DEBUG Width", String.valueOf(buttonUpperLeft.getWidth()));
        Log.d("DEBUG Height", String.valueOf(buttonUpperLeft.getHeight()));

        buttonUpperLeft.setX((maxX / 2));
        buttonUpperLeft.setY((maxY / 2));

        // Button color change for testing
        //button1.setBackgroundColor(Color.BLUE);


    }


}
