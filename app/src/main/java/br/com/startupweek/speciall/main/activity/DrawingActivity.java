package br.com.startupweek.speciall.main.activity;

import android.graphics.Color;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.CountDownTimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import br.com.startupweek.speciall.DrawingObjects.Drawing;
import br.com.startupweek.speciall.DrawingObjects.DrawingInterface;
import br.com.startupweek.speciall.DrawingObjects.DrawingLetters;
import br.com.startupweek.speciall.DrawingObjects.DrawingNumbers;
import br.com.startupweek.speciall.DrawingObjects.DrawingSymbols;
import br.com.startupweek.speciall.R;
import br.com.startupweek.speciall.fingerDrawing.TouchEventView;

public class DrawingActivity extends AppCompatActivity {

    private TouchEventView myView;
    private int counter = 0;

    private DrawingInterface drawingInterface;

    private LinearLayout preparationLayout;
    private TextView preparationText;
    private TextView countdownText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(this.getClass().getName(), "ON CREATE");
        setDrawingInterface(getIntent().getIntExtra("TYPE",0));

        myView = (TouchEventView)this.findViewById(R.id.view2);
        myView.setInterface(new TouchEventView.TouchEventViewInterface() {
            @Override
            public void ditBrushCoordinatesChanged(float x, float y, float length) {}

            @Override
            public void didFinishTouchEvent(float x, float y) {
                calculateLineLength(x, y);
            }

            @Override
            public void didBeginTouchEvent(float x, float y) {
                drawingInterface.setEndCoordinates( (int) x, (int) y);
            }
        });

        preparationLayout = (LinearLayout) findViewById(R.id.preparationLayout);
        preparationText = (TextView) findViewById(R.id.preparationText);
        countdownText = (TextView) findViewById(R.id.countdownText);

        startCountdown();
    }

    private void calculateLineLength(float x, float y) {

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;

        if(drawingInterface.validate((int)x, (int)y, height)) {

            if (drawingInterface.isCompleted()) {
                Toast.makeText(this, "Perfec!", Toast.LENGTH_SHORT).show();
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.perfect_song);
                mp.start();
                reset();
            }
            else {
                Toast.makeText(this, "Boa!", Toast.LENGTH_SHORT).show();
            }
        }

        counter++;

        if(counter > 5)
            reset();
    }

    public void didTapReset(View view){
        reset();
    }
    private void reset() {
        counter = 0;
        myView.path.reset();
    }

    public void setDrawingInterface(int type) {
        Drawing drawing = null;
        if(type == Drawing.LETTERS_TYPE){
            this.drawingInterface = new DrawingLetters("A");
            this.getSupportActionBar().setTitle("A");
        } else if(type == Drawing.NUMBERS_TYPE){
            this.drawingInterface = new DrawingNumbers("1");
            this.getSupportActionBar().setTitle("1");
        } else if(type == Drawing.SYMBOLS_TYPE){
            this.drawingInterface = new DrawingSymbols("#");
            this.getSupportActionBar().setTitle("#");
        }
        this.drawingInterface.setContext(this.getApplicationContext());
    }


    private void startCountdown(){
        preparationText.setText(drawingInterface.createPreparationText());
        countdownText.setText("5");
        preparationLayout.setVisibility(View.VISIBLE);

        myView.setVisibility(View.INVISIBLE);

        new CountDownTimer(4000, 1000){
            @Override
            public void onTick(long l) {
                countdownText.setText(Long.toString((l/1000) % 60));
                Log.d("COUNTDOWN", "HUMAN NUMBER: " + (l/1000) % 60);
            }

            @Override
            public void onFinish() {
                Log.d("COUNTDOWN", "FINISH");
                ((LinearLayout.LayoutParams)preparationText.getLayoutParams()).weight = 0;
                myView.setVisibility(View.VISIBLE);
                countdownText.setVisibility(View.GONE);
            }
        }.start();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_drawing, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_reset:
                reset();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
