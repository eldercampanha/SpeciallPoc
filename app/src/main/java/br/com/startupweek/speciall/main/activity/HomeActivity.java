package br.com.startupweek.speciall.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import br.com.startupweek.speciall.R;
import br.com.startupweek.speciall.main.MainActivity;

public class HomeActivity extends AppCompatActivity {

    private final HomeActivity mHomeActivity = this;
    private final String tag = this.getClass().getName();

    private CardView alphabetCard;
    private CardView numberCard;
    private CardView symbolCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        alphabetCard = (CardView) findViewById(R.id.alphabetCard);
        alphabetCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity(MainActivity.class);
            }
        });

        numberCard = (CardView) findViewById(R.id.numberCard);
        symbolCard = (CardView) findViewById(R.id.symbolCard);
    }

    public void goToActivity(Class<?> toClass){
        Log.i(tag, "FROM: " + tag + " | TO: " + toClass.getName());
        Intent intent = new Intent(mHomeActivity, toClass);
        startActivity(intent);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // Set menu with model
        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_home, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_about:
                goToActivity(AboutActivity.class);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
