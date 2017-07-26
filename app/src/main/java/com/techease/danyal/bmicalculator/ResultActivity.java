package com.techease.danyal.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    ImageView result ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = (ImageView) findViewById(R.id.result);
        Intent mIntent = getIntent();

        float age = mIntent.getIntExtra("age", 0);
        float height = mIntent.getFloatExtra("height", 0);
        float weight = mIntent.getFloatExtra("weight", 0);
        String gender = mIntent.getStringExtra("gender");
        float bmi = mIntent.getIntExtra("bmi", 0);
        interpretBMI(bmi);


    }


    // Interpret what BMI means
    String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";

        } else if (bmiValue < 18.5) {
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



