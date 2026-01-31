package com.example.labreport;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QnTenRecyclerView extends RecyclerView.Adapter<QnTenRecyclerView.ViewHolder> {

    ArrayList<QnTenCarModel> list;

    public QnTenRecyclerView(ArrayList<QnTenCarModel> list) {
        this.list = list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView model, year, price;

        ViewHolder(View v) {
            super(v);
            model = v.findViewById(R.id.tvModel);
            year = v.findViewById(R.id.tvYear);
            price = v.findViewById(R.id.tvPrice);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.qn_ten_recyclerview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int position) {
        QnTenCarModel c = list.get(position);
        h.model.setText("Model: " + c.model);
        h.year.setText("Year: " + c.year);
        h.price.setText("Price: Rs " + c.price);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
