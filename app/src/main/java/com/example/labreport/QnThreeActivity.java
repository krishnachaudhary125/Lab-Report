package com.example.labreport;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class QnThreeActivity extends AppCompatActivity {
    QnThreeSQLiteDbHelper myDb;
    EditText roll, name, address;
    Button insertBtn, displayBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qn_three_activity);
        myDb = new QnThreeSQLiteDbHelper(this);

        roll = findViewById(R.id.roll);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        insertBtn = findViewById(R.id.insertBtn);
        displayBtn = findViewById(R.id.displayBtn);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.insertData(Integer.parseInt(roll.getText().toString()), name.getText().toString(), address.getText().toString());
                Toast.makeText(QnThreeActivity.this, "Data Inserted Successfully.", Toast.LENGTH_SHORT).show();
            }
        });

        displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = myDb.displayData();
                StringBuffer buffer = new StringBuffer();
                while (cursor.moveToNext()){
                    buffer.append("Roll : "+cursor.getInt(0)+"\n")
                            .append("Name : "+cursor.getString(1)+"\n")
                            .append("Address : "+cursor.getString(2));
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(QnThreeActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Student Records").setMessage(buffer.toString()).show();
            }
        });
    }
}
