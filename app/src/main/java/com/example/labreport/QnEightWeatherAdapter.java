package com.example.labreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class QnEightWeatherAdapter extends BaseAdapter {

    Context context;
    ArrayList<QnEightWeatherModel> list;

    public QnEightWeatherAdapter(Context context, ArrayList<QnEightWeatherModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.qn_eight_grid_item, parent, false);
        }

        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        TextView tvValue = convertView.findViewById(R.id.tvValue);

        QnEightWeatherModel model = list.get(position);
        tvTitle.setText(model.getTitle());
        tvValue.setText(model.getValue());

        return convertView;
    }
}
