package com.example.labreport;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QnSixSecondActivity extends AppCompatActivity {
    TextView tvArea, tvPerimeter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qn_six_second_activity);

        tvArea = findViewById(R.id.tvArea);
        tvPerimeter = findViewById(R.id.tvPerimeter);

        double area = getIntent().getDoubleExtra("area", 0);
        double perimeter = getIntent().getDoubleExtra("perimeter", 0);

        tvArea.setText("Area of Circle = " + area);
        tvPerimeter.setText("Perimeter of Circle = " + perimeter);
    }
}
