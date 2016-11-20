package br.com.startupweek.speciall.main;

import android.content.Intent;
import android.graphics.Point;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import br.com.startupweek.speciall.DrawingObjects.DrawingInterface;
import br.com.startupweek.speciall.DrawingObjects.DrawingLetters;
import br.com.startupweek.speciall.R;
import br.com.startupweek.speciall.fingerDrawing.TouchEventView;

public class MainActivity extends AppCompatActivity {

    private static float lastX = 0;
    private static float lastY = 0;
    private int counter = 0;
    private ImageView imgLetter;
    private TouchEventView myView;
    private int lines = 0;

    private DrawingInterface drawingInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(this.getClass().getName(), "ON CREATE");

        drawingInterface = new DrawingLetters();


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

        startCountdown();
    }

    private void calculateLineLength(float x, float y) {

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;

        if(drawingInterface.validate((int)x, (int)y, height))
            Toast.makeText(this, "from Drawing Good Job!", Toast.LENGTH_SHORT).show();

    }

    private void startCountdown(){
        TextView preparationText = null;
        if(drawingInterface instanceof DrawingLetters){
            preparationText = createPreparationViewWithText("A");
        }

        final RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.activity_main);
        mainLayout.addView(preparationText);

        final TextView finalPreparationText = preparationText;
        new CountDownTimer(5000, 1000){
            @Override
            public void onTick(long l) {
                Log.d("COUNTDOWN", "ON TICK " + l);
            }

            @Override
            public void onFinish() {
                Log.d("COUNTDOWN", "FINISH");
                mainLayout.removeView(finalPreparationText);
            }
        }.start();
    }

    private TextView createPreparationViewWithText(String text){
        TextView preparationText = new TextView(this);
        preparationText.setText(text);
        preparationText.setTextSize(72);

        preparationText.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        return preparationText;
    }

//    private TextView createTimerCountdownView(){
//        TextView preparationText = new TextView(this);
//        preparationText.setText(text);
//        preparationText.setTextSize(72);
//
//        preparationText.setLayoutParams(new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT));
//
//        return preparationText;
//    }
}
