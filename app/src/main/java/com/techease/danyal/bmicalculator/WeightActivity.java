package com.techease.danyal.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class WeightActivity extends AppCompatActivity {
    ImageButton next3;
    EditText getWeight;
    Spinner weightSpinner;
    String weightType;
    String[] weightSpinnerValue = {
            "Kg",
            "Pounds"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        next3 = (ImageButton) findViewById(R.id.next3);
        getWeight = (EditText) findViewById(R.id.getweight);
        weightSpinner = (Spinner) findViewById(R.id.weightspinner);


        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), weightSpinnerValue);
        weightSpinner.setAdapter(customAdapter);
        weightSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 1) {
                    weightType = "KG";
                    Toast.makeText(WeightActivity.this, weightType, Toast.LENGTH_SHORT).show();
                } else if (i == 2) {
                    weightType = "Pounds";
                    Toast.makeText(WeightActivity.this, weightType, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });


        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validate()) {

                    return;
                }

                String value = getWeight.getText().toString();
                float weight = Integer.parseInt(value);
                Intent wIntent = new Intent(WeightActivity.this, HeightActivity.class);
                wIntent.putExtra("weightType", weightType);
                wIntent.putExtra("weight", weight);
                startActivity(wIntent);
                finish();


            }
        });
    }



             public boolean validate() {
                 boolean valid = true;
                 String weight = getWeight.getText().toString();


                 if (weight.isEmpty()) {
                     getWeight.setError("Enter your weight ");
                     valid = false;
                 } else {
                     getWeight.setError(null);
                 }


                 return valid;
             }

         }

