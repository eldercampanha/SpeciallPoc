package br.com.startupweek.speciall.main.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;


import br.com.startupweek.speciall.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final View rootView = findViewById(R.id.activity_about);

        String finalMessage = "Feito por pessoas specialls para pessoas specialls :)";

        final Snackbar snackbar = Snackbar
                .make(rootView, finalMessage, Snackbar.LENGTH_INDEFINITE)
                .setAction("FECHAR", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
        snackbar.show();
    }

}
