package com.techease.bmicalculator;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class FourthActivity extends AppCompatActivity {
    ImageButton imageButton;
    TextView tvBmi ;
    double bmi  ;
    double height , weight ;
    String heightType , weightType ;
    double newBMI ;
    java.text.DecimalFormat f ;



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        tvBmi = (TextView)findViewById(R.id.bmi);

        Intent mIntent = getIntent();
        height = mIntent.getFloatExtra("height", 0);
        weight = mIntent.getFloatExtra("weight", 0);
        heightType = mIntent.getStringExtra("heightType");
        weightType = mIntent.getStringExtra("weightType");

        imageButton = (ImageButton) findViewById(R.id.tick);
        imageButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bmiIntent = new Intent(FourthActivity.this, ResultActivity.class);
                bmiIntent.putExtra("bmi", newBMI );
                startActivity(bmiIntent);
                finish();

            }
        });



        // calculate bmi value - pounds and inch
        if (weightType.equals("Pounds") && heightType.equals("Inches")) {
            bmi = calculateBMI(weight, height);
        } else if (weightType.equals("KG") && weightType.equals("Inches")){
            weight = weight * 2.205;
            bmi = calculateBMI(weight, height);
        } else if (weightType.equals("Pounds") && heightType.equals("CM")){
            height = height / 2.54;
            bmi = calculateBMI(weight, height);
        } else {
            weight = weight * 2.205;
            height = height / 2.54;
            bmi = calculateBMI(weight, height);
        }

        // round to 2 digits
        newBMI = Math.round(bmi*100.0)/100.0;
        f = new java.text.DecimalFormat("##.00");

        // interpret the meaning of the bmi value
        String bmiInterpretation = interpretBMI(bmi);

        // now set the value in the results text
        tvBmi.setText(f.format(newBMI) );

    }




// the formula to calculate the BMI index
private double calculateBMI (double weight, double height) {
        // convert values to metric
        return (double) (((weight / 2.2046) / (height * 0.0254)) / (height * 0.0254));
        }



    private String interpretBMI(double bmi) {

        if (bmi < 16) {
            return "You are Severely Underweight";
        } else if (bmi < 18.5) {
            return "You are Underweight";
        } else if (bmi < 25) {
            return "You are Normal";
        }else if (bmi < 30) {
            return "You are Overweight";
        }else if (bmi < 40) {
            return "You are Obese";
        }else if (bmi >= 40) {
            return "You are Morbidly Obese";
        }else {
            return "Enter your Details";
        }
    }

}
