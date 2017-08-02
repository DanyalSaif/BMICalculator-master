package com.techease.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class HeightActivity extends AppCompatActivity {
    ImageButton next4;
    EditText getHeight ;
    String  weightType ;
    Float weight ;
    Spinner heightSpinner;
    String heightType;
    String[] heightSpinnerValue = {
            "CM",
            "Inches"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height);
        next4 = (ImageButton) findViewById(R.id.next4);
        getHeight = (EditText)findViewById(R.id.getHeight);
       heightSpinner = (Spinner) findViewById(R.id.heightSpinner);

        Intent wintent = getIntent();
        weightType = wintent.getStringExtra("weightType");
        weight = wintent.getFloatExtra("weight", 0);
        heightType = "CM" ;

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), heightSpinnerValue);
        heightSpinner.setAdapter(customAdapter);
        heightSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    heightType = "CM";

                } else if (i == 1) {
                    heightType = "Inches";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });


        next4.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validate()) {

                    return;
                }


                String value= getHeight.getText().toString();
                float height =Integer.parseInt(value);
                Intent hIntent = new Intent(HeightActivity.this, FourthActivity.class);
                hIntent.putExtra("weight", weight);
                hIntent.putExtra("weightType" , weightType);
                hIntent.putExtra("heightType", heightType);
                hIntent.putExtra("height", height );
                startActivity(hIntent);
                finish();

            }
        });


    }


    public boolean validate() {
        boolean valid = true;
        String height = getHeight.getText().toString();


        if (height.isEmpty() ) {
            getHeight.setError("Enter your height ");
            valid = false;
        } else {
            getHeight.setError(null);
        }


        return valid;
    }

}
