package com.example.learningappdev1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edt_weight, edt_ft, edt_in;
        Button btn_cal;
        TextView txt_res;
        LinearLayout main;

        edt_weight = findViewById(R.id.edt_weight);
        edt_ft = findViewById(R.id.edt_ft);
        edt_in = findViewById(R.id.edt_in);
        btn_cal = findViewById(R.id.btn_cal);
        txt_res = findViewById(R.id.txtResult);
        main = findViewById(R.id.main);

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edt_weight.getText().toString());
                int hgt_ft = Integer.parseInt(edt_ft.getText().toString());
                int hgt_in = Integer.parseInt(edt_in.getText().toString());

                 double hgt_m = ((hgt_ft*12 + hgt_in)*2.53)/100;
                 double bmi = wt/(hgt_m*hgt_m);

                 if (bmi>25){
                     txt_res.setText("You are Overweight");
                     main.setBackgroundColor(getResources().getColor(R.color.red));
                 }

                 else if(bmi<18){
                     txt_res.setText("You are Underweight");
                     main.setBackgroundColor(getResources().getColor(R.color.yellow));
                 }
                 else{
                     txt_res.setText("You are Healthy");
                     main.setBackgroundColor(getResources().getColor(R.color.green));
                 }
            }
        });

    }
}