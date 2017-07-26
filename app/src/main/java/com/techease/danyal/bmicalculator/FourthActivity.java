package com.techease.danyal.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class FourthActivity extends AppCompatActivity {
    ImageButton imageButton;
    TextView bmi ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        bmi = (TextView)findViewById(R.id.bmi);

        Intent mIntent = getIntent();
        float height = mIntent.getFloatExtra("height", 0);
        float weight = mIntent.getFloatExtra("weight", 0);
        String heightType = mIntent.getStringExtra("heightType");
        String weightType = mIntent.getStringExtra("weightType");

        Toast.makeText(FourthActivity.this, heightType, Toast.LENGTH_SHORT).show();
        Toast.makeText(FourthActivity.this, weightType, Toast.LENGTH_SHORT).show();




        final float bmiValue = calculateBMI(weight,height);
        bmi.setText(String.valueOf(bmiValue));

        imageButton = (ImageButton) findViewById(R.id.tick);

        imageButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bmiIntent = new Intent(FourthActivity.this, ResultActivity.class);
                bmiIntent.putExtra("bmi", bmiValue);
                startActivity(bmiIntent);
                finish();

            }
        });


    }

    //Calculate BMI
    private float calculateBMI (float weight, float height) {

        return (float) (weight / (height * height));
    }



}
