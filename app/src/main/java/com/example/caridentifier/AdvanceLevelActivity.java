package com.example.caridentifier;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class AdvanceLevelActivity extends AppCompatActivity {

    ImageView imageRand_1, imageRand_2 , imageRand_3;

    Button btn_submit;

    EditText edtxt_1, edtxt_2, edtxt_3;

    TextView point_text, timerView4 ;


    public int images[] = {R.drawable.bmw_1,R.drawable.bmw_2,R.drawable.bmw_3,R.drawable.bmw_4,R.drawable.bmw_5,
            R.drawable.bmw_6,R.drawable.bmw_7,R.drawable.bmw_8,R.drawable.bmw_9,R.drawable.bmw_10,R.drawable.fer_1,
            R.drawable.fer_2,R.drawable.fer_3,R.drawable.fer_4,R.drawable.fer_5,R.drawable.fer_6,R.drawable.lam_1,
            R.drawable.lam_2,R.drawable.lam_3,R.drawable.lam_4,R.drawable.lam_5,R.drawable.lam_6,R.drawable.jar_2,
            R.drawable.jar_3,R.drawable.jar_4,R.drawable.jar_5,R.drawable.tes_1,R.drawable.tes_2,R.drawable.tes_3};

    String carId1 = "";
    String carId2 = "";
    String carId3 = "";


    ArrayList<String> carNamesArray = new ArrayList<>();
    ArrayList<Integer> numberArray = new ArrayList<>();

    int cont =0;
    int num1=0;
    int num2= 0;
    int num3=0;

    Boolean timerSet4;

    CountDownTimer mCountdoun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_level);

        imageRand_1 = findViewById(R.id.imageRand_1);
        imageRand_2 = findViewById(R.id.imageRand_2);
        imageRand_3 = findViewById(R.id.imageRand_3);

        btn_submit = findViewById(R.id.btn_submit);
        edtxt_1 = findViewById(R.id.edtxt_1);
        edtxt_2 = findViewById(R.id.edtxt_2);
        edtxt_3 = findViewById(R.id.edtxt_3);
        point_text = findViewById(R.id.pointText);
        timerView4 =findViewById(R.id.timerText4);

        Intent firstIntent = getIntent();
        timerSet4 = firstIntent.getBooleanExtra("EXTRA_MESSAGE",false);

        pickRandomImage();

        setTimer();

    }

    //generate random number and set to the image view
    public void pickRandomImage(){
        carNamesArray.removeAll(carNamesArray);
        num1 = (int) (Math.random()*((images.length-1)+1)+0);
        num2 = (int) (Math.random()*((images.length-1)+1)+0);
        num3 = (int) (Math.random()*((images.length-1)+1)+0);


        imageRand_1.setImageResource(images[num1]);
        imageRand_2.setImageResource(images[num2]);
        imageRand_3.setImageResource(images[num3]);

        try {


            if (num1 <= 9) {
                carId1 = "bmw";
                carNamesArray.add(carId1);
            } else if ((num1 <= 15 && num1 >= 10)) {
                carId1 = "ferrari";
                carNamesArray.add(carId1);
            } else if ((16 <= num1 && num1 <= 21)) {
                carId1 = "lamborghini";
                carNamesArray.add(carId1);
            } else if ((22 <= num1 && 25 >= num1)) {
                carId1 = "jaguar";
                carNamesArray.add(carId1);
            } else if ((26 <= num1 && 29 >= num1)) {
                carId1 = "tesla";
                carNamesArray.add(carId1);
            }


            if (num2 <= 9) {
                carId2 = "bmw";
                carNamesArray.add(carId2);
            } else if ((num2 <= 15 && num2 >= 10)) {
                carId2 = "ferrari";
                carNamesArray.add(carId2);
            } else if ((16 <= num2 && num2 <= 21)) {
                carId2 = "lamborghini";
                carNamesArray.add(carId2);
            } else if ((22 <= num2 && 25 >= num2)) {
                carId2 = "jaguar";
                carNamesArray.add(carId2);
            } else if ((26 <= num2 && 29 >= num2)) {
                carId2 = "tesla";
                carNamesArray.add(carId2);
            }

            if (num3 <= 9) {
                carId3 = "bmw";
                carNamesArray.add(carId3);
            } else if ((num3 <= 15 && num3 >= 10)) {
                carId3 = "ferrari";
                carNamesArray.add(carId3);
            } else if ((16 <= num3 && num3 <= 21)) {
                carId3 = "lamborghini";
                carNamesArray.add(carId3);
            } else if ((22 <= num3 && 25 >= num3)) {
                carId3 = "jaguar";
                carNamesArray.add(carId3);
            } else if ((26 <= num3 && 29 >= num3)) {
                carId3 = "tesla";
                carNamesArray.add(carId3);
            }
            System.out.println(carNamesArray.toString());
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    //find correct answer , check three inputs
    public void findAnswer(){

        int point =0;

        String inputCar1 = edtxt_1.getText().toString().toLowerCase();
        String inputCar2 = edtxt_2.getText().toString().toLowerCase();
        String inputCar3 = edtxt_3.getText().toString().toLowerCase();

        if (inputCar1.equals(carNamesArray.get(0)) && inputCar2.equals(carNamesArray.get(1))  && inputCar3.equals(carNamesArray.get(2)) ){
            edtxt_1.setBackgroundColor(Color.GREEN);
            edtxt_2.setBackgroundColor(Color.GREEN);
            edtxt_3.setBackgroundColor(Color.GREEN);
            point = point+3;
            //point_text.setText(point_text.getText().toString()+""+point);

            correctEndMessage();

        }else if ( inputCar1.equals(carNamesArray.get(0))  && inputCar2.equals(carNamesArray.get(1))){
            edtxt_1.setBackgroundColor(Color.GREEN);
            edtxt_2.setBackgroundColor(Color.GREEN);
            edtxt_3.setBackgroundColor(Color.RED);
            edtxt_1.setEnabled(false);
            edtxt_2.setEnabled(false);
            point = point+ 2;
            //point_text.setText(point_text.getText().toString()+""+point);

        }else if (  inputCar2.equals(carNamesArray.get(1)) && inputCar3.equals(carNamesArray.get(2))){
            edtxt_1.setBackgroundColor(Color.RED);
            edtxt_2.setBackgroundColor(Color.GREEN);
            edtxt_3.setBackgroundColor(Color.GREEN);
            edtxt_2.setEnabled(false);
            edtxt_3.setEnabled(false);
            point = point+2;
            //point_text.setText(point_text.getText().toString()+""+point);
        }else  if (inputCar1.equals(carNamesArray.get(0)) && inputCar3.equals(carNamesArray.get(2)) ){
            edtxt_1.setBackgroundColor(Color.GREEN);
            edtxt_2.setBackgroundColor(Color.RED);
            edtxt_3.setBackgroundColor(Color.GREEN);
            edtxt_1.setEnabled(false);
            edtxt_3.setEnabled(false);
            point =point+ 2;
            //point_text.setText(point_text.getText().toString()+""+point);

        }else if (inputCar1.equals(carNamesArray.get(0))){
            edtxt_1.setBackgroundColor(Color.GREEN);
            edtxt_2.setBackgroundColor(Color.RED);
            edtxt_3.setBackgroundColor(Color.RED);
            edtxt_1.setEnabled(false);
            point =point+ 1;
            //point_text.setText(point_text.getText().toString()+""+point);
        }else if ( inputCar2.equals(carNamesArray.get(1)) ){
            edtxt_1.setBackgroundColor(Color.RED);
            edtxt_2.setBackgroundColor(Color.GREEN);
            edtxt_3.setBackgroundColor(Color.RED);
            edtxt_2.setEnabled(false);
            point =point+ 1;
            //point_text.setText(point_text.getText().toString()+""+point);

        }else if (inputCar3.equals(carNamesArray.get(2))){
            edtxt_1.setBackgroundColor(Color.RED);
            edtxt_2.setBackgroundColor(Color.RED);
            edtxt_3.setBackgroundColor(Color.GREEN);
            edtxt_3.setEnabled(false);
            point =point+ 1;
            //point_text.setText(point_text.getText().toString()+""+point);

        }else {
            edtxt_1.setBackgroundColor(Color.RED);
            edtxt_2.setBackgroundColor(Color.RED);
            edtxt_3.setBackgroundColor(Color.RED);
            point =  0;
            //point_text.setText(point_text.getText().toString()+""+point);

        }

        point_text.setText(point_text.getText().toString()+""+point);

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
        builder_alertBox.setMessage(Html.fromHtml("<font color='red'><b>WRONG!</b> </font> <font color='#fcba03'> <b><br> Correct answers are " +(carId1+","+carId2+","+carId3)+"<b></font>"));

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
    public void submitAnswers(View view) {
        cont = cont +1;
        if (btn_submit.getText().toString().toLowerCase().equals("submit")){
            findAnswer();
            if (cont == 4){
                negativeEndMessage();
                btn_submit.setText("NEXT");

                cont=0;
            }


        }else {
            cont--;
            setTimer();
            point_text.setText("POINT -");
            edtxt_1.setBackgroundColor(Color.TRANSPARENT);
            edtxt_2.setBackgroundColor(Color.TRANSPARENT);
            edtxt_3.setBackgroundColor(Color.TRANSPARENT);
            edtxt_1.setEnabled(true);
            edtxt_2.setEnabled(true);
            edtxt_3.setEnabled(true);
            edtxt_1.setText("");
            edtxt_2.setText("");
            edtxt_3.setText("");
            pickRandomImage();
            btn_submit.setText("SUBMIT");
        }

    }

    //contdown timer
    public  void setTimer(){
        if (timerSet4){
            mCountdoun = new CountDownTimer(30000, 1000) {
                long min;
                long sec;

                public void onTick(long millisUntilFinished) {
                    // Used for formatting digit to be in 2 digits only
                    NumberFormat f = new DecimalFormat("00");
                    //long hour = (millisUntilFinished / 3600000) % 24;
                    min = (millisUntilFinished / 60000) % 60;
                    sec = (millisUntilFinished / 1000) % 60;
                    timerView4.setText( f.format(min) + ":" + f.format(sec));
                    if (btn_submit.getText().toString().toLowerCase().equals("next")){
                        timerView4.setText( "00:00");
                        mCountdoun.cancel();
                    }
                }
                // When the task is over it will print 00:00:00 there
                public void onFinish() {
                    negativeEndMessage();

                    btn_submit.setText("NEXT");
                    timerView4.setText("00:00");
                }
            }.start();
        }else {

            timerView4.setVisibility(View.INVISIBLE);
        }
    }

}