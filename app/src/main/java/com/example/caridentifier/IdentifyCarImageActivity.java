package com.example.caridentifier;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class IdentifyCarImageActivity extends AppCompatActivity {

    ImageView imageView_1,imageView_2,imageView_3;
    TextView carName,timerView3;

    public int images[] = {R.drawable.bmw_1,R.drawable.bmw_2,R.drawable.bmw_3,R.drawable.bmw_4,R.drawable.bmw_5,
            R.drawable.bmw_6,R.drawable.bmw_7,R.drawable.bmw_8,R.drawable.bmw_9,R.drawable.bmw_10,R.drawable.fer_1,
            R.drawable.fer_2,R.drawable.fer_3,R.drawable.fer_4,R.drawable.fer_5,R.drawable.fer_6,R.drawable.lam_1,
            R.drawable.lam_2,R.drawable.lam_3,R.drawable.lam_4,R.drawable.lam_5,R.drawable.lam_6,R.drawable.jar_2,
            R.drawable.jar_3,R.drawable.jar_4,R.drawable.jar_5,R.drawable.tes_1,R.drawable.tes_2,R.drawable.tes_3};

    int num1,num2,num3,num4,num5;

    public String manuFact[] = {"BMW","Ferrari","Lamborghini","Jaguar","Tesla"};

    int imgNum;

    Button next_button;

    Boolean timerSet3;
    CountDownTimer mCountdoun;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_car_image);

        imageView_1 = findViewById(R.id.image_1);
        imageView_2 = findViewById(R.id.image_2);
        imageView_3 = findViewById(R.id.image_3);
        carName = findViewById(R.id.carName);
        timerView3 =findViewById(R.id.timerText3);
        next_button =findViewById(R.id.btn_next);

        Intent firstIntent = getIntent();
        timerSet3 = firstIntent.getBooleanExtra("EXTRA_MESSAGE",false);


        imgNum = (int) (Math.random()*((manuFact.length-1)+1)+0);

        carName.setText(manuFact[imgNum]);


        setTimer();


        //generate random numbers
        num1 = (int) (Math.random()*((10-1)+1)+1);
        num2 = (int) (Math.random()*((15-11)+1)+11);
        num3 = (int) (Math.random()*((21-16)+1)+16);
        num4 = (int) (Math.random()*((25-22)+1)+22);
        num5 = (int) (Math.random()*((28-26)+1)+26);


        //set images to image Views
        if(carName.getText().toString().equals("BMW")){
            imageView_1.setImageResource(images[num1]);
            imageView_2.setImageResource(images[num2]);
            imageView_3.setImageResource(images[num3]);

        }else if (carName.getText().toString().equals("Ferrari")){
            imageView_1.setImageResource(images[num2]);
            imageView_2.setImageResource(images[num4]);
            imageView_3.setImageResource(images[num3]);
        }else if(carName.getText().toString().equals("Lamborghini")){
            imageView_1.setImageResource(images[num2]);
            imageView_2.setImageResource(images[num5]);
            imageView_3.setImageResource(images[num3]);

        }else if (carName.getText().toString().equals("Jaguar")){
            imageView_1.setImageResource(images[num1]);
            imageView_2.setImageResource(images[num4]);
            imageView_3.setImageResource(images[num3]);

        }else if (carName.getText().toString().equals("Tesla")){
            imageView_1.setImageResource(images[num2]);
            imageView_2.setImageResource(images[num5]);
            imageView_3.setImageResource(images[num3]);

        }


        //first Image View
        imageView_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(carName.getText().toString().equals("BMW") || carName.getText().toString().equals("Ferrari")){
                    correctEndMessage();
                }
                else {
                    negativeEndMessage();

                }
            }
        });

        //second image View
        imageView_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(carName.getText().toString().equals("Jaguar") || carName.getText().toString().equals("Tesla") ){
                    correctEndMessage();
                }
                else {
                    negativeEndMessage();
                }
            }
        });

        //third Image View
        imageView_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(carName.getText().toString().equals("Lamborghini")){
                    correctEndMessage();
                }
                else {
                    negativeEndMessage();
                    
                }
            }
        });


    }


    //next button
    public void randomNext(View view) {



        imgNum = (int) (Math.random()*((manuFact.length-1)+1)+0);

        carName.setText(manuFact[imgNum]);

        num1 = (int) (Math.random()*((9-1)+1)+1);
        num2 = (int) (Math.random()*((15-10)+1)+10);
        num3 = (int) (Math.random()*((21-16)+1)+16);
        num4 = (int) (Math.random()*((25-22)+1)+22);
        num5 = (int) (Math.random()*((28-26)+1)+26);

        if(carName.getText().toString().equals("BMW")){
            imageView_1.setImageResource(images[num1]);
            imageView_2.setImageResource(images[num2]);
            imageView_3.setImageResource(images[num3]);

        }else if (carName.getText().toString().equals("Ferrari")){
            imageView_1.setImageResource(images[num2]);
            imageView_2.setImageResource(images[num4]);
            imageView_3.setImageResource(images[num3]);
        }else if(carName.getText().toString().equals("Lamborghini")){
            imageView_1.setImageResource(images[num2]);
            imageView_2.setImageResource(images[num5]);
            imageView_3.setImageResource(images[num3]);

        }else if (carName.getText().toString().equals("Jaguar")){
            imageView_1.setImageResource(images[num1]);
            imageView_2.setImageResource(images[num4]);
            imageView_3.setImageResource(images[num3]);

        }else if (carName.getText().toString().equals("Tesla")){
            imageView_1.setImageResource(images[num2]);
            imageView_2.setImageResource(images[num5]);
            imageView_3.setImageResource(images[num3]);

        }

        setTimer();


    }

    //correct message
    public void correctEndMessage(){
        AlertDialog.Builder builder_alertBox = new AlertDialog.Builder(this);
        builder_alertBox.setTitle(Html.fromHtml("<font color='#1da310'><b>Answer!!!</b> </font>"));
        builder_alertBox.setMessage(Html.fromHtml("<font color='#1da310'><b>CORRECT!</b> </font>"));

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

    //wrong message alert
    public void negativeEndMessage(){
        AlertDialog.Builder builder_alertBox = new AlertDialog.Builder(this);
        builder_alertBox.setTitle(Html.fromHtml("<font color='red'><b>Answer!!!</b> </font>"));
        builder_alertBox.setMessage(Html.fromHtml("<font color='red'><b>WRONG!</b> </font> "));

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

    //count down timer
    public  void setTimer(){
        if (timerSet3){
            mCountdoun = new CountDownTimer(30000, 1000) {
                long min;
                long sec;

                public void onTick(long millisUntilFinished) {
                    // Used for formatting digit to be in 2 digits only
                    NumberFormat f = new DecimalFormat("00");
                    //long hour = (millisUntilFinished / 3600000) % 24;
                    min = (millisUntilFinished / 60000) % 60;
                    sec = (millisUntilFinished / 1000) % 60;
                    timerView3.setText( f.format(min) + ":" + f.format(sec));

                }
                // When the task is over it will print 00:00:00 there
                public void onFinish() {
                    negativeEndMessage();

                    timerView3.setText("00:00");
                }
            }.start();
        }else {

            timerView3.setVisibility(View.INVISIBLE);
        }
    }


}