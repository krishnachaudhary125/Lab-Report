package com.example.labreport;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QnTenActivity extends AppCompatActivity {

    EditText etModel, etYear, etPrice;
    Button btnSave;
    RecyclerView recyclerView;
    QnTenSQLiteDbHelper dbHelper;
    QnTenRecyclerView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qn_ten_activity);

        etModel = findViewById(R.id.etModel);
        etYear = findViewById(R.id.etYear);
        etPrice = findViewById(R.id.etPrice);
        btnSave = findViewById(R.id.btnSave);
        recyclerView = findViewById(R.id.recyclerView);

        dbHelper = new QnTenSQLiteDbHelper(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadData();

        btnSave.setOnClickListener(v -> {
            dbHelper.insertCar(
                    etModel.getText().toString(),
                    Integer.parseInt(etYear.getText().toString()),
                    Double.parseDouble(etPrice.getText().toString())
            );
            loadData();
        });
    }

    private void loadData() {
        ArrayList<QnTenCarModel> list = dbHelper.getAllCars();
        adapter = new QnTenRecyclerView(list);
        recyclerView.setAdapter(adapter);
    }
}
