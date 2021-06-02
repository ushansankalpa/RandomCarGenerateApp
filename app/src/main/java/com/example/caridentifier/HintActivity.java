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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class HintActivity extends AppCompatActivity {

    ImageView random_images;

    EditText inputCarName;

    TextView outputCarName, timerView2;

    Button btn_submit;

    String carId1 = "";


    public int images[] = {R.drawable.bmw_1,R.drawable.bmw_2,R.drawable.bmw_3,R.drawable.bmw_4,R.drawable.bmw_5,
            R.drawable.bmw_6,R.drawable.bmw_7,R.drawable.bmw_8,R.drawable.bmw_9,R.drawable.bmw_10,R.drawable.fer_1,
            R.drawable.fer_2,R.drawable.fer_3,R.drawable.fer_4,R.drawable.fer_5,R.drawable.fer_6,R.drawable.lam_1,
            R.drawable.lam_2,R.drawable.lam_3,R.drawable.lam_4,R.drawable.lam_5,R.drawable.lam_6,R.drawable.jar_2,
            R.drawable.jar_3,R.drawable.jar_4,R.drawable.jar_5,R.drawable.tes_1,R.drawable.tes_2,R.drawable.tes_3};

    ArrayList<String> car_name_char = new ArrayList<>();
    ArrayList<String> undersco_array = new ArrayList<>();

    int count =0;

    Boolean timerSet2;

    CountDownTimer mCountdoun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);



        random_images = findViewById(R.id.ran_images_h);
        btn_submit = findViewById(R.id.btn_submit);
        inputCarName = findViewById(R.id.input_carName);
        outputCarName = findViewById(R.id.output_carName);
        timerView2 = findViewById(R.id.timerText2);

        Intent firstIntent = getIntent();
        timerSet2 = firstIntent.getBooleanExtra("EXTRA_MESSAGE",false);


        if (btn_submit.getText().toString().toLowerCase().equals("submit")){

            setFills();
            setTimer();

        }else {
            //setFills();
            btn_submit.setText("SUBMIT");
        }

    }



    //correct alert message
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
        btn_submit.setText("Next");

    }

    //wrong alert message
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



    //submit button
    public void submitName(View view) {
        count =count+1;
        if (btn_submit.getText().toString().toLowerCase().equals("submit")){


            if (carId1.equals(inputCarName.getText().toString().toLowerCase())){
                correctEndMessage();
                outputCarName.setText("");
                inputCarName.setText("");
            }else if (outputCarName.getText().toString().toLowerCase().equals(carId1)){
                correctEndMessage();
                outputCarName.setText("");
                inputCarName.setText("");
            }
            else if (count==3){
                negativeEndMessage();
                outputCarName.setText("");
                inputCarName.setText("");
                btn_submit.setText("NEXT");
                count=0;
            }


            fillCarName();




        }else {
            count--;
            setTimer();
            setFills();
            btn_submit.setText("SUBMIT");
        }


    }


    //fill correct name
    public void fillCarName(){
        outputCarName.setText("");
        String holdChar = inputCarName.getText().toString().toLowerCase();

        for (int j=0; j<car_name_char.size(); j++){
            if (holdChar.equals(car_name_char.get(j))){
                undersco_array.set(j,holdChar);
            }
        }

        for (int k=0; k<undersco_array.size(); k++){
            outputCarName.setText(outputCarName.getText()+undersco_array.get(k));
        }

    }

    //save letters and undersco to arrayList
    public void setFills(){
        undersco_array.removeAll(undersco_array);
        car_name_char.removeAll(car_name_char);
        outputCarName.setText("");
        inputCarName.setText("");
        int randomNumberOf_car = (int) (Math.random()*((images.length-1)+1)+1);
        random_images.setImageResource(images[randomNumberOf_car]);

        if (randomNumberOf_car<9){
            carId1 = "bmw";

            car_name_char.add("b");
            car_name_char.add("m");
            car_name_char.add("w");

            for(int i=0; i<3; i++){
                undersco_array.add("-");
            }


        }else if (randomNumberOf_car<= 15 && randomNumberOf_car>=10){
            carId1 = "ferrari";

            car_name_char.add("f");
            car_name_char.add("e");
            car_name_char.add("r");
            car_name_char.add("r");
            car_name_char.add("a");
            car_name_char.add("r");
            car_name_char.add("i");

            for(int i=0; i<7; i++){
                undersco_array.add("-");
            }
        }else if (16<=randomNumberOf_car && randomNumberOf_car<=21){
            carId1 = "lamborghini";

            car_name_char.add("l");
            car_name_char.add("a");
            car_name_char.add("m");
            car_name_char.add("b");
            car_name_char.add("o");
            car_name_char.add("r");
            car_name_char.add("g");
            car_name_char.add("h");
            car_name_char.add("i");
            car_name_char.add("n");
            car_name_char.add("i");


            for(int i=0; i<11; i++){
                undersco_array.add("-");
            }
        }else if (22<= randomNumberOf_car && 25>=randomNumberOf_car){
            carId1 = "jaguar";

            car_name_char.add("j");
            car_name_char.add("a");
            car_name_char.add("g");
            car_name_char.add("u");
            car_name_char.add("a");
            car_name_char.add("r");



            for(int i=0; i<6; i++){
                undersco_array.add("-");
            }
        }else if (26<=randomNumberOf_car && 30>=randomNumberOf_car){
            carId1 = "tesla";
            car_name_char.add("t");
            car_name_char.add("e");
            car_name_char.add("s");
            car_name_char.add("l");
            car_name_char.add("a");



            for(int i=0; i<5; i++){
                undersco_array.add("-");
            }
        }

    }

    //count down timer
    public  void setTimer(){
        if (timerSet2){
            mCountdoun = new CountDownTimer(30000, 1000) {
                long min;
                long sec;

                public void onTick(long millisUntilFinished) {
                    // Used for formatting digit to be in 2 digits only
                    NumberFormat f = new DecimalFormat("00");
                    //long hour = (millisUntilFinished / 3600000) % 24;
                    min = (millisUntilFinished / 60000) % 60;
                    sec = (millisUntilFinished / 1000) % 60;
                    timerView2.setText( f.format(min) + ":" + f.format(sec));
                    if (btn_submit.getText().toString().toLowerCase().equals("next")){
                        timerView2.setText( "00:00");
                        mCountdoun.cancel();
                    }
                }
                // When the task is over it will print 00:00:00 there
                public void onFinish() {
                    negativeEndMessage();

                    btn_submit.setText("NEXT");
                    timerView2.setText("00:00");
                }
            }.start();
        }else {

            timerView2.setVisibility(View.INVISIBLE);
        }
    }

}