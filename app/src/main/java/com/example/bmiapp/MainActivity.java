package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText Heightininches, Heightinft, Weight;
        Button CalculateBMI;
        TextView CalculatedResult;
        LinearLayout LinearMain;

        Heightininches= findViewById(R.id.Heightininches);
        Heightinft= findViewById(R.id.Heightinft);
        Weight=findViewById(R.id.Weight);
        CalculateBMI=findViewById(R.id.CalculateBMI);
        CalculatedResult=findViewById(R.id.CalculatedResult);
        LinearMain= findViewById(R.id.LinearMain);

        CalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(Weight.getText().toString());
                int inc = Integer.parseInt(Heightininches.getText().toString());
                int ft= Integer.parseInt(Heightinft.getText().toString());

                int totalInc= ft*12 + inc;

                double heightCm = totalInc*2.53;

                double totalM = heightCm/100;

                double bmi= wt/(totalM*totalM);

                if (bmi>25){
                    CalculatedResult.setText("You are OverWeight");
                    LinearMain.setBackgroundColor(getResources().getColor(R.color.overWeight));
                    
                } else if (bmi<18) {
                    
                    CalculatedResult.setText("You are Under Weight");
                    LinearMain.setBackgroundColor(getResources().getColor(R.color.underWeight));
                } else{
                CalculatedResult.setText("You are Healthy");
                LinearMain.setBackgroundColor(getResources().getColor(R.color.healthy));

            }
        }
    });
    }
}