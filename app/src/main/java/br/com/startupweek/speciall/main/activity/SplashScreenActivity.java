package br.com.startupweek.speciall.main.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import br.com.startupweek.speciall.R;
import br.com.startupweek.speciall.main.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final Handler mHandler = new Handler();
        final SplashScreenActivity mSplashScreen = this;
        mHandler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(mSplashScreen, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
