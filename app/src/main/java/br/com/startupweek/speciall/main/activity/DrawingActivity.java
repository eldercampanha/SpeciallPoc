package br.com.startupweek.speciall.main.activity;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.NumberPicker;
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
    }

    private void calculateLineLength(float x, float y) {

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;

        if(drawingInterface.validate((int)x, (int)y, height)) {
            Toast.makeText(this, "Good Job!", Toast.LENGTH_SHORT).show();
            counter++;
        }

//        if( (drawingInterface instanceof DrawingLetters) && counter > 3) {
//            drawingInterface = new DrawingNumbers();
//            reset();
//        }
//        else if( (drawingInterface instanceof DrawingNumbers) && counter > 2) {
//            drawingInterface = new DrawingLetters();
//            reset();
//        }

    }

    private void reset() {
        counter = 0;
        myView.path.reset();
    }

    public void setDrawingInterface(int type) {

        if(type == Drawing.LETTERS_TYPE)
           this.drawingInterface = new DrawingLetters();
        if(type == Drawing.NUMBERS_TYPE)
            this.drawingInterface = new DrawingNumbers();
        if(type == Drawing.SYMBOLS_TYPE)
            this.drawingInterface = new DrawingSymbols();
    }
}
