package com.techease.danyal.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class HeightActivity extends AppCompatActivity {
    ImageButton next4;
    EditText getHeight ;
    String weightType ;
    float  weight;
    String heightType ;
    Spinner heightspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height);
        next4 = (ImageButton) findViewById(R.id.next4);
        getHeight = (EditText)findViewById(R.id.getHeight);
       heightspinner = (Spinner) findViewById(R.id.heightSpinner);


        final Intent wIntent = getIntent();
        weightType = wIntent.getStringExtra("weightType");
        weight = wIntent.getFloatExtra("weight",0);


        next4.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validate()) {

                    return;
                }

                String value= getHeight.getText().toString();
                float height =Integer.parseInt(value);
                Intent hIntent = new Intent(HeightActivity.this, FourthActivity.class);
                hIntent.putExtra("heightType", heightType);
                hIntent.putExtra("height", height );
                hIntent.putExtra("weightType" , weightType);
                hIntent.putExtra("wight",weight);
                startActivity(hIntent);
                finish();

            }
        });
        heightspinner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String heightType = heightspinner.getSelectedItem().toString();


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
