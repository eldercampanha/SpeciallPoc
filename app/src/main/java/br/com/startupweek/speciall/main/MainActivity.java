package br.com.startupweek.speciall.main;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
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
    }

    private void calculateLineLength(float x, float y) {

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;

        if(drawingInterface.validate((int)x, (int)y, height))
            Toast.makeText(this, "from Drawing Good Job!", Toast.LENGTH_SHORT).show();

    }
}
