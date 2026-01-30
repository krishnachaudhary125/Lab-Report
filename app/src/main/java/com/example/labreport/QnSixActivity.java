package com.example.labreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class QnSixActivity extends AppCompatActivity {
    EditText etRadius;
    Button btnCalculate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qn_six_activity);

        etRadius = findViewById(R.id.etRadius);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double radius = Double.parseDouble(etRadius.getText().toString());

                double area = Math.PI * radius * radius;
                double perimeter = 2 * Math.PI * radius;

                Intent intent = new Intent(QnSixActivity.this, QnSixSecondActivity.class);
                intent.putExtra("area", area);
                intent.putExtra("perimeter", perimeter);
                startActivity(intent);
            }
        });
    }
}
