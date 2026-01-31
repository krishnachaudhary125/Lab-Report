package com.example.labreport;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class QnTwelveImage extends AppCompatActivity {

    ImageView largeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qn_twelve_image);

        largeImageView = findViewById(R.id.largeImageView);

        int imageRes = getIntent().getIntExtra("image", -1);
        if (imageRes != -1) {
            largeImageView.setImageResource(imageRes);
        }
    }
}
