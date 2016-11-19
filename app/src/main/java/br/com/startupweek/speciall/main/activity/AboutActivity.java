package br.com.startupweek.speciall.main.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import br.com.startupweek.speciall.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
