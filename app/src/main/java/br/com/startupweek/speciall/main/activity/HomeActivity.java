package br.com.startupweek.speciall.main.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import br.com.startupweek.speciall.DrawingObjects.Drawing;
import br.com.startupweek.speciall.DrawingObjects.DrawingLetters;
import br.com.startupweek.speciall.DrawingObjects.DrawingNumbers;
import br.com.startupweek.speciall.DrawingObjects.DrawingSymbols;
import br.com.startupweek.speciall.R;

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
                new MaterialDialog.Builder(mHomeActivity)
                        .title("Vamos praticar")
                        .content("Começaremos pela letra A, você está pronto ?")
                        .positiveText("Sim, vamos lá!")
                        .negativeText("Ainda não")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                goToDrawingActivity(DrawingLetters.class);
                            }
                        })
                        .onAny(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });

        numberCard = (CardView) findViewById(R.id.numberCard);
        numberCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.perfect_song);
                mp.start();

                new MaterialDialog.Builder(mHomeActivity)
                        .title("Vamos praticar")
                        .content("Hora do número 1, você está pronto ?")
                        .positiveText("Sim, vamos lá!")
                        .negativeText("Ainda não")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                goToDrawingActivity(DrawingNumbers.class);
                            }
                        })
                        .onAny(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });

        symbolCard = (CardView) findViewById(R.id.symbolCard);
        symbolCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(mHomeActivity)
                        .title("Vamos praticar")
                        .content("Hora do símbolo #, você está pronto ?")
                        .positiveText("Sim, vamos lá!")
                        .negativeText("Ainda não")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                goToDrawingActivity(DrawingSymbols.class);
                            }
                        })
                        .onAny(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
    }

    private void goToDrawingActivity(Class<?> drawingLettersClass) {

        Intent intent = new Intent(mHomeActivity, DrawingActivity.class);

        if (drawingLettersClass.isInstance(new DrawingLetters())) {
            intent.putExtra("TYPE", Drawing.LETTERS_TYPE);
        }
        else if (drawingLettersClass.isInstance(new DrawingNumbers())) {
            intent.putExtra("TYPE", Drawing.NUMBERS_TYPE);
        }
        else if (drawingLettersClass.isInstance(new DrawingSymbols())) {
            intent.putExtra("TYPE", Drawing.SYMBOLS_TYPE);
        }

        startActivity(intent);

    }
    public void goToActivity(Class<?> toClass){
        Log.i(tag, "FROM: " + tag + " | TO: " + toClass.getName());
        Intent intent = new Intent(mHomeActivity, toClass);
        startActivity(intent);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_home, menu);
        this.getSupportActionBar().setTitle("Home");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_about:
                goToActivity(AboutActivity.class);
                return true;
            case R.id.action_grafico:
                goToActivity(GraphicsActivity.class);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
