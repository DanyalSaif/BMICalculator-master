package com.techease.bmicalculator;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    ImageView result , calcAgain ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = (ImageView) findViewById(R.id.result);
        calcAgain = (ImageView) findViewById(R.id.calcAgain);
        Intent mIntent = getIntent();
        double bmi = mIntent.getDoubleExtra("bmi", 0);
        String bmiInterpretation = interpretBMI(bmi);


        calcAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this , StartScreen.class));
                finish();
            }
        });


    }


    // Interpret what BMI means
    String interpretBMI(double bmiValue) {

        if (bmiValue < 16) {
            result.setImageResource(R.drawable.severlyunderweight);
            return "Severely underweight";

        } else if (bmiValue < 18.5) {
            result.setImageResource(R.drawable.underweight);
            return "Underweight";
        } else if (bmiValue < 25) {
            result.setImageResource(R.drawable.normal);
            return "Normal";
        } else if (bmiValue < 30) {
            result.setImageResource(R.drawable.overweight);
            return "Overweight";
        } else {
            result.setImageResource(R.drawable.obese);
            return "Obese";
        }
    }

}



