package com.shubham.tabandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

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

        TextView result ;
        EditText weight , height_inch,height_ft;
        Button calculate;
        LinearLayout linear_main;

        weight = findViewById(R.id.weight);
        height_ft = findViewById(R.id.height_ft);
        height_inch = findViewById(R.id.height_inch);
        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.result);
        linear_main = findViewById(R.id.layout_main);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(weight.getText().toString());
                int ft = Integer.parseInt(height_ft.getText().toString());
                int inch = Integer.parseInt(height_inch.getText().toString());

                int totalinch = (ft*12)+inch;

                double totalcm = (totalinch*2.53);

                double totalm = (totalcm/100);

                double bmi = wt/(totalm*totalm);

                if(bmi>25){
                    result.setText("YOU ARE OVERWEIGTH");
                    linear_main.setBackgroundColor(getResources().getColor(R.color.Red));
                } else if (bmi<18) {
                    result.setText("YOU ARE UNDERWEIGHT");
                    linear_main.setBackgroundColor(getResources().getColor(R.color.yellow));
                } else {
                    result.setText("YOU ARE OK");
                    linear_main.setBackgroundColor(getResources().getColor(R.color.green));
                }

            }
        });
    }
}