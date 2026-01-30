package com.example.labreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnTen, btnEleven, btnTwelve, btnThirteen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = findViewById(R.id.one);
        btnTwo = findViewById(R.id.two);
        btnThree = findViewById(R.id.three);
        btnFour = findViewById(R.id.four);
        btnFive = findViewById(R.id.five);
        btnSix = findViewById(R.id.six);
        btnSeven = findViewById(R.id.seven);
        btnEight = findViewById(R.id.eight);
        btnNine = findViewById(R.id.nine);
        btnTen = findViewById(R.id.ten);
        btnEleven = findViewById(R.id.eleven);
        btnTwelve = findViewById(R.id.twelve);
        btnThirteen = findViewById(R.id.thirteen);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QnOneActivity.class);
                startActivity(intent);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QnTwoActivity.class);
                startActivity(intent);
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, QnThreeActivity.class);
                startActivity(intent);
            }
        });
    }
}