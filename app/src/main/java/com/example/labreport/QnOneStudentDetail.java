package com.example.labreport;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class QnOneStudentDetail extends Fragment {
    public static QnOneStudentDetail newInstance(int roll, String name, String addr){
        QnOneStudentDetail fragment = new QnOneStudentDetail();
        Bundle bundle = new Bundle();
        bundle.putInt("roll", roll);
        bundle.putString("name", name);
        bundle.putString("addr", addr);
        fragment.setArguments(bundle);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.qn_one_fragment, container, false);
        TextView roll = view.findViewById(R.id.roll);
        TextView name = view.findViewById(R.id.name);
        TextView addr = view.findViewById(R.id.addr);

        Bundle bundle = getArguments();
        if (bundle != null) {
            roll.setText("Roll: " + bundle.getInt("roll"));
            name.setText("Name: " + bundle.getString("name"));
            addr.setText("Address: " + bundle.getString("addr"));
        }
        return view;
    }
}
