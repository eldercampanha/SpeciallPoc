package br.com.startupweek.speciall.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import br.com.startupweek.speciall.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button mAboutButon = (Button) findViewById(R.id.aboutButton);
        final HomeActivity mHomeActivity = this;

        mAboutButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(this.getClass().getName(), "About button clicked");
                Intent intent = new Intent(mHomeActivity, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

}
