package com.example.labreport;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class QnOneActivity extends AppCompatActivity {
    ListView listView;
    FrameLayout fragment;
    String[] name = {"Krishna", "Subodh", "Sumit", "Sagar", "Passang"};
    int[] roll = {1,2,3,4,5};
    String[] addr = {"Lalitpur", "Kathmandu", "Bhaktapur", "Makwanpur", "Bhojpur"};
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qn_one_activity);

        listView = findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter<String>(QnOneActivity.this, android.R.layout.simple_dropdown_item_1line, name);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                QnOneStudentDetail fragment =
                        QnOneStudentDetail.newInstance(
                                roll[position],
                                name[position],
                                addr[position]
                        );
                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
