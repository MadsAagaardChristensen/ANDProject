package com.example.examand1;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class GifsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifs);

        ImageView gifImageView = (ImageView) findViewById(R.id.iv_gif);

        Glide.with(this)
                .load("http://i.imgur.com/Vth6CBz.gif")
                .asBitmap()
                .placeholder(R.drawable.ic_cloud_off_red)
                .error(R.drawable.ic_cloud_off_red)
                .into(gifImageView);
    }

}
