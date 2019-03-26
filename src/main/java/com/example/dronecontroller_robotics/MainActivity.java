package com.example.dronecontroller_robotics;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.user.wluroboticsdronecontroller_2.R;

import io.github.controlwear.virtual.joystick.android.JoystickView;

public class MainActivity extends AppCompatActivity {


    private TextView mTextViewAngleLeft;
    private TextView mTextViewStrengthLeft;

    private TextView mTextViewAngleRight;
    private TextView mTextViewStrengthRight;
    private TextView mTextViewCoordinateRight;

    private String direction;
    private float strength_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button takeoff_button = (Button) findViewById(R.id.takeoff_button);
        takeoff_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // signal
            }
        });

        Button landing_button = (Button) findViewById(R.id.landing_button);
        landing_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // signal
            }
        });

        Button hover_button = (Button) findViewById(R.id.hover_button);
        hover_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // signal
            }
        });



        mTextViewAngleLeft = (TextView) findViewById(R.id.textView_angle_left);
        mTextViewStrengthLeft = (TextView) findViewById(R.id.textView_strength_left);

        JoystickView joystickLeft = (JoystickView) findViewById(R.id.joystickView_left);
        joystickLeft.setOnMoveListener(new JoystickView.OnMoveListener() {
            @Override
            public void onMove(int angle, int strength) {
                mTextViewAngleLeft.setText(angle + "°");
                mTextViewStrengthLeft.setText(strength + "%");
            if (angle < 180 && angle > 0)
                {
                    //send the signal to the drone to go UP
                    direction = "up";
                    strength_1 = strength;

                }

            else {
                direction = "down";
                strength_1 = strength;




        }}});


        mTextViewAngleRight = (TextView) findViewById(R.id.textView_angle_right);
        mTextViewStrengthRight = (TextView) findViewById(R.id.textView_strength_right);
        mTextViewCoordinateRight = findViewById(R.id.textView_coordinate_right);

        final JoystickView joystickRight = (JoystickView) findViewById(R.id.joystickView_right);
        joystickRight.setOnMoveListener(new JoystickView.OnMoveListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onMove(int angle, int strength) {
                mTextViewAngleRight.setText(angle + "°");
                mTextViewStrengthRight.setText(strength + "%");
                if (angle < 45 && angle > 315) {
                    direction = "right";
                    strength_1 = strength;


                }

                else if (angle > 45 && angle < 135) {
                    direction = "forward";
                    strength_1 = strength;
                }

                else if (angle > 135 && angle < 225) {
                    direction = "left";
                    strength_1 = strength;
                }

                else {
                    direction = "backward";
                    strength_1 = strength;
                }


                mTextViewCoordinateRight.setText(
                        String.format("x%03d:y%03d",
                                joystickRight.getNormalizedX(),
                                joystickRight.getNormalizedY())
                );
            }


        });
    }



}

