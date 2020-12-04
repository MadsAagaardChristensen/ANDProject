package com.example.examand1;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examand1.Gallery.YoutubeDisplay;
import com.example.examand1.settings.SettingsActivity;
import com.google.firebase.auth.FirebaseAuth;

import Login.Login;

public class OptionsMenu extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Home:
                message("Enjoy");
                startActivity(new Intent(this, MainActivity.class));
                return true;

            case R.id.Gallery:
                message("Enjoy");
                startActivity(new Intent(this, YoutubeDisplay.class));
                finish();
                return true;

            case R.id.settings:
                message("Enjoy");
                startActivity(new Intent(this, SettingsActivity.class));
                return true;

            case R.id.LogOut:
                    message("Logged out");
                    FirebaseAuth.getInstance().signOut();
                    finish();
                    startActivity(new Intent(this, Login.class));
                    return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void message (String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
