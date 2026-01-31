package com.example.labreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class QnTwelveActivity extends AppCompatActivity {

    GridView gridView;
    int[] images = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qn_twelve_activity);

        gridView = findViewById(R.id.gridView);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int position) {
                return images[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, android.view.ViewGroup parent) {
                ImageView imageView;
                if (convertView == null) {
                    imageView = new ImageView(QnTwelveActivity.this);
                    imageView.setLayoutParams(new GridView.LayoutParams(400, 400));
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView = (ImageView) convertView;
                }
                imageView.setImageResource(images[position]);
                return imageView;
            }
        };

        gridView.setAdapter(adapter);

        // Click listener
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(QnTwelveActivity.this, QnTwelveImage.class);
                intent.putExtra("image", images[position]);
                startActivity(intent);
            }
        });
    }
}
