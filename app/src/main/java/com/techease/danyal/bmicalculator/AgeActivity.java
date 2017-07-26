package com.techease.danyal.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class AgeActivity extends AppCompatActivity {
    ImageButton next2;
    EditText getAge ;
    ImageButton malebut , female;
    boolean isPressed = false;
    String gender ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        getAge = (EditText)findViewById(R.id.getage);
        next2 = (ImageButton) findViewById(R.id.next2);
        malebut = (ImageButton) findViewById(R.id.malebutton);
        female = (ImageButton) findViewById(R.id.femalebutton);

        malebut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(isPressed){
                    malebut.setBackgroundResource(R.drawable.male);
                    gender = "male" ;
                }else {
                    malebut.setBackgroundResource(R.drawable.male1);
                }
                isPressed =! isPressed;
            }
        });


        female.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(isPressed){
                    female.setBackgroundResource(R.drawable.female);
                    gender = "female" ;
                }else {
                    female.setBackgroundResource(R.drawable.female1);
                }
                isPressed =! isPressed;
            }
        });


        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validate()) {

                    return;
                }

                String age= getAge.getText().toString();
                float finalAge =Integer.parseInt(age);
                Intent aIntent = new Intent(AgeActivity.this, WeightActivity.class);
                aIntent.putExtra("age", finalAge);
                aIntent.putExtra("gender", gender) ;
                startActivity(aIntent);
                finish();

            }
        });
    }


    public boolean validate() {
        boolean valid = true;
        String age = getAge.getText().toString();


        if (age.isEmpty() ) {
            getAge.setError("Enter your age ");
            valid = false;
        } else {
            getAge.setError(null);
        }


        return valid;
    }

}
