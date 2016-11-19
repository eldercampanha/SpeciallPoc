package br.com.startupweek.speciall.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import br.com.startupweek.speciall.R;
import br.com.startupweek.speciall.main.MainActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final HomeActivity mHomeActivity = this;
        final String tag = this.getClass().getName();

        Button mAboutButon = (Button) findViewById(R.id.aboutButton);
        mAboutButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(tag, "About button clicked");
                Intent intent = new Intent(mHomeActivity, AboutActivity.class);
                startActivity(intent);
            }
        });

        Button mStartbutton = (Button) findViewById(R.id.startButton);
        mStartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(tag, "Start button clicked");
                Intent intent = new Intent(mHomeActivity, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
