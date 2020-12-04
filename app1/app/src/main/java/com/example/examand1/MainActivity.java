package com.example.examand1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button showGalleryBtn = (Button) findViewById(R.id.btn_show_gallery);
            showGalleryBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent galleryIntent = new Intent(MainActivity.this, SpaceGalleryActivity.class);
                    startActivity(galleryIntent);
                }
            });

            Button showGif = (Button) findViewById(R.id.btn_show_gif);
            showGif.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent gifIntent = new Intent(MainActivity.this, GifsActivity.class);
                    startActivity(gifIntent);
                }
            });

        }
    }
