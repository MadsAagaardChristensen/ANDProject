package com.example.examand1.settings;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.example.examand1.R;

public class SettingsActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new MyPreferenceFragment())
                .commit();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public static class MyPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);

            Preference version = findPreference("version");
            try {
                String versionName = getActivity().getPackageManager()
                        .getPackageInfo(getActivity().getPackageName(), 0).versionName;
                version.setSummary(versionName);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

            //ini
            Preference buttonfeedback = findPreference(getString(R.string.send_feedback));

            buttonfeedback.setOnPreferenceClickListener(preference -> {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "your_email@gmail.com", null));
             //emnefelt
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, this.getString(R.string.app_name) + " Feedback");
             //tekst
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Write your feedback here...");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

                return true;
            });
        }
    }
}