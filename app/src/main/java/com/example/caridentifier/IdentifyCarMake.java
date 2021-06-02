package com.example.caridentifier;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class IdentifyCarMake extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView timerView;
    ImageView random_images;
    Button btnIdentify;
    Spinner spinner_array;
    public int images[] = {R.drawable.bmw_1,R.drawable.bmw_2,R.drawable.bmw_3,R.drawable.bmw_4,R.drawable.bmw_5,
            R.drawable.bmw_6,R.drawable.bmw_7,R.drawable.bmw_8,R.drawable.bmw_9,R.drawable.bmw_10,R.drawable.fer_1,
            R.drawable.fer_2,R.drawable.fer_3,R.drawable.fer_4,R.drawable.fer_5,R.drawable.fer_6,R.drawable.lam_1,
            R.drawable.lam_2,R.drawable.lam_3,R.drawable.lam_4,R.drawable.lam_5,R.drawable.lam_6,R.drawable.jar_2,
            R.drawable.jar_3,R.drawable.jar_4,R.drawable.jar_5,R.drawable.tes_1,R.drawable.tes_2,R.drawable.tes_3};

    public int rand_num;

    String carId1 = "";
    String carId2 = "";
    String carId3 = "";
    String carId4 = "";
    String carId5 = "";

    String select_item;

    Boolean timerSet1;
    CountDownTimer mCountdoun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_car_make);

        //image View(set the random image on this view)
        random_images = findViewById(R.id.ran_images);

        //drop down list
        spinner_array = findViewById(R.id.labels_spinner);

        //identify and next button
        btnIdentify = findViewById(R.id.btn_identify);

        //display timer
        timerView = findViewById(R.id.timerText);

        //generate random number using image list length
        rand_num = (int) (Math.random()*((images.length-1)+1)+0);

        //set the image into the Image View
        random_images.setImageResource(images[rand_num]);

        //get boolean value
        Intent firstIntent = getIntent();
        timerSet1 = firstIntent.getBooleanExtra("EXTRA_MESSAGE",false);

        //countDown timer
        setTimer();


        final Spinner spinner = findViewById(R.id.labels_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }




    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //initialize string what i choose
        select_item = parent.getItemAtPosition(position).toString();

    }

    //After click on the identify button
    public void identifyTheCar(View view) {

        if (btnIdentify.getText().toString().toLowerCase().equals("identify")){

            if (rand_num <9){
                carId1 = "BMW";
            }else if (rand_num <= 15 && rand_num >=10){
                carId2 = "Ferrari";
            }else if (16<= rand_num && rand_num <=21){
                carId3 = "Lamborghini";
            }else if (22<= rand_num && 25>= rand_num){
                carId4 = "Jaguar";
            }else if (26<= rand_num && 29>= rand_num){
                carId5 = "Tesla";
            }



            if (select_item.equals(carId1)){
                correctEndMessage();
            }else if (select_item.equals(carId2)){
                correctEndMessage();
            }
            else if (select_item.equals(carId3)){
                correctEndMessage();
            }else if (select_item.equals(carId4)){
                correctEndMessage();
            }else if (select_item.equals(carId5)){
                correctEndMessage();
            }
            else {
                negativeEndMessage();
            }

            btnIdentify.setText("Next");

        }else{
            //timerView.setText("00:00");
            setTimer();
            rand_num = (int) (Math.random()*((images.length-1)+1)+0);
            random_images.setImageResource(images[rand_num]);

            btnIdentify.setText("IDENTIFY");
        }


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }



    //if answer is correct sent the correct message alert
    public void correctEndMessage(){
        AlertDialog.Builder builder_alertBox = new AlertDialog.Builder(this);
        builder_alertBox.setTitle(Html.fromHtml("<font color='#1da310'><b>Answer!!!</b> </font>"));
        builder_alertBox.setMessage(Html.fromHtml("<font color='#1da310'><b>CORRECT!</b> </font>"));
        carId1 = "";
        carId2 = "";
        carId3 = "";
        carId4 = "";
        carId5 = "";
        builder_alertBox.setCancelable(true);

        builder_alertBox.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertBox = builder_alertBox.create();

        alertBox.show();
    }

    //if answer is wrong , sent the inCorrect message alert
    public void negativeEndMessage(){
        AlertDialog.Builder builder_alertBox = new AlertDialog.Builder(this);
        builder_alertBox.setTitle(Html.fromHtml("<font color='red'><b>Answer!!!</b> </font>"));
        builder_alertBox.setMessage(Html.fromHtml("<font color='red'><b>WRONG!</b> </font> <font color='#fcba03'> <b><br> Correct name is " +(carId1+carId2+carId3+carId4+carId5)+"<b></font>"));
        carId1 = "";
        carId2 = "";
        carId3 = "";
        carId4 = "";
        carId5 = "";
        builder_alertBox.setCancelable(true);

        builder_alertBox.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertBox = builder_alertBox.create();

        alertBox.show();
    }

    //Count down timer method
    public  void setTimer(){
        if (timerSet1){
            mCountdoun = new CountDownTimer(30000, 1000) {
                long min;
                long sec;

                public void onTick(long millisUntilFinished) {
                    NumberFormat f = new DecimalFormat("00");
                    min = (millisUntilFinished / 60000) % 60;
                    sec = (millisUntilFinished / 1000) % 60;
                    timerView.setText( f.format(min) + ":" + f.format(sec));
                    if (btnIdentify.getText().toString().toLowerCase().equals("next")){
                        timerView.setText( "00:00");
                        mCountdoun.cancel();
                    }
                }
                // When the task is over it will print 00:00:00 there
                public void onFinish() {
                    negativeEndMessage();

                    btnIdentify.setText("NEXT");
                    timerView.setText("00:00");
                }
            }.start();
        }else {

            timerView.setVisibility(View.INVISIBLE);
        }
    }





}