package com.example.examand1.Gallery;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import com.example.examand1.OptionsMenu;
import com.example.examand1.MainActivity;
import com.example.examand1.R;

public class YoutubeDisplay extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "Hallo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma);
        Log.d(TAG, String.valueOf(true));
        Button btnSingle = (Button) findViewById(R.id.btnPlaySingle);
        btnSingle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch(view.getId()) {
            case R.id.btnPlaySingle:
                intent = new Intent(this, YoutubeActivity.class);
                break;

            default:
        }

        if(intent != null) {
            startActivity(intent);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();

    }
}
