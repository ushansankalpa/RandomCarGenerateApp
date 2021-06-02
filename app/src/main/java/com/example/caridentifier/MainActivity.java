package com.example.caridentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    String EXTRA_MESSAGE = "";
    Button identifyCarMake,hint,identifyCarImage,advancedLevel;

    Switch timerMode;

    Boolean switchStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //identify car make button
        identifyCarMake = findViewById(R.id.button_identify_carMake);
        //hint button
        hint = findViewById(R.id.button_hint);
        //identify came image button
        identifyCarImage = findViewById(R.id.button_identify_carImage);
        //advance level button
        advancedLevel = findViewById(R.id.button_advance_level);
        //switcher
        timerMode = findViewById(R.id.timer);



        //Switch button, if switch is on , then check ,is it on and pass value as true
        timerMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerMode.isChecked()){
                    switchStat =true;
                }else {
                    switchStat = false;

                }

            }
        });

    }

    //move to identify car make activity, using explicit intent
    public void identifyCarMake(View view) {
        Intent first_intent = new Intent(MainActivity.this,IdentifyCarMake.class);
        //passing boolean value another activity
        first_intent.putExtra("EXTRA_MESSAGE",switchStat);
        startActivity(first_intent);

    }

    //move to hint activity, using explicit intent
    public void getHint(View view) {
        Intent second_intent = new Intent(MainActivity.this,HintActivity.class);
        //passing boolean value another activity
        second_intent.putExtra("EXTRA_MESSAGE",switchStat);
        startActivity(second_intent);
    }

    //move to identify car image activity, using explicit intent
    public void identifyCarImage(View view) {
        Intent third_intent = new Intent(MainActivity.this,IdentifyCarImageActivity.class);
        //passing boolean value another activity
        third_intent.putExtra("EXTRA_MESSAGE",switchStat);
        startActivity(third_intent);
    }

    //move to advance level activity,  using explicit intent
    public void advanceLevel(View view) {
        Intent fourth_intent = new Intent(MainActivity.this,AdvanceLevelActivity.class);
        //passing boolean value another activity
        fourth_intent.putExtra("EXTRA_MESSAGE",switchStat);
        startActivity(fourth_intent);
    }
}