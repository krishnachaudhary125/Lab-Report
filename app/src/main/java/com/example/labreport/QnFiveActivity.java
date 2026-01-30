package com.example.labreport;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QnFiveActivity extends AppCompatActivity {
    EditText etName, etPhone, etEmail;
    Button btnSave;
    ListView listView;
    QnFiveSQLiteDbHelper myDb;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qn_five_activity);
        etName = findViewById(R.id.name);
        etPhone = findViewById(R.id.phone);
        etEmail = findViewById(R.id.email);
        btnSave = findViewById(R.id.saveBtn);
        listView = findViewById(R.id.listView);

        myDb = new QnFiveSQLiteDbHelper(this);
        list = new ArrayList<>();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean inserted = myDb.insertData(
                        etName.getText().toString(),
                        etPhone.getText().toString(),
                        etEmail.getText().toString()
                );

                if (inserted) {
                    Toast.makeText(QnFiveActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    displayData();
                } else {
                    Toast.makeText(QnFiveActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        displayData();
    }
    private void displayData() {
        list.clear();
        Cursor cursor = myDb.displayData();

        while (cursor.moveToNext()) {
            list.add(
                    "Name: " + cursor.getString(1) +
                            "\nPhone: " + cursor.getString(2) +
                            "\nEmail: " + cursor.getString(3)
            );
        }

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }
}
