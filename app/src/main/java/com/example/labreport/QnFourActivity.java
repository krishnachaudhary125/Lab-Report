package com.example.labreport;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class QnFourActivity extends AppCompatActivity {
    Button customDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qn_four_activity);

        customDialog = findViewById(R.id.customDialog);
        customDialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }
    public void showCustomDialog() {

        Dialog dialog = new Dialog(QnFourActivity.this, android.R.style.Theme_Material_Light_Dialog);
        dialog.setContentView(R.layout.qn_four_custom_dialog);
        dialog.setCancelable(true);

        EditText etP = dialog.findViewById(R.id.principal);
        EditText etT = dialog.findViewById(R.id.time);
        EditText etR = dialog.findViewById(R.id.rate);
        Button btnResult = dialog.findViewById(R.id.calculateBtn);
        TextView tvResult = dialog.findViewById(R.id.result);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double p = Double.parseDouble(etP.getText().toString());
                double t = Double.parseDouble(etT.getText().toString());
                double r = Double.parseDouble(etR.getText().toString());

                double si = (p * t * r) / 100;

                tvResult.setText("Simple Interest = " + si);
            }
        });
        dialog.show();
    }
}
