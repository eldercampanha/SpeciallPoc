package br.com.startupweek.speciall.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import br.com.startupweek.speciall.R;
import br.com.startupweek.speciall.fingerDrawing.TouchEventView;

public class MainActivity extends AppCompatActivity {

    private static float lastX = 0;
    private static float lastY = 0;
    private int counter = 0;
    private ImageView imgLetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.i(this.getClass().getName(), "ON CREATE");

        TouchEventView myView = (TouchEventView)this.findViewById(R.id.view2);
        myView.setInterface(new TouchEventView.TouchEventViewInterface() {
            @Override
            public void ditBrushCoordinatesChanged(float x, float y, float length) {
//                checkAcurrency(x,y, length);
            }

            @Override
            public void didFinishTouchEvent(float x, float y) {
                calculateLineLength(x, y);
//                counter++;
            }

            @Override
            public void didBeginTouchEvent(float x, float y) {
                lastX = x;
                lastY = y;
            }
        });
    }

    private void calculateLineLength(float x, float y) {

        double b = Math.pow((int)y - (int)lastY, 2);
        double c = Math.pow((int)x - (int)lastX, 2);

        Log.i("LENGHT", "L = " + Math.sqrt(b + c));
    }

    public boolean checkAcurrency(float x, float y, float length){

        if(counter == 0) {
            //test for the first 'A' stroke
            if ((x + 8) > lastX) {
                if ((int) x < (int) lastX) {
                    Log.i(this.getClass().getName(), "1 x error");
                    Log.i(this.getClass().getName(), "1 x difference = " + ((int) x - (int) lastX));
                }
            }
            if ((y + 50) < lastY) {
                Log.i(this.getClass().getName(), "1 y error");
                Log.i(this.getClass().getName(), "1 lastY = " + lastY + " y = " + y);
            }
        } else if (counter == 1) {

            if ((x + 8) < lastX) {
                if ((int) x < (int) lastX) {
                    Log.i(this.getClass().getName(), "2 x error");
                    Log.i(this.getClass().getName(), "2 x difference = " + ((int) x - (int) lastX));
                }
            }
            if ((y - 50) > lastY) {
                Log.i(this.getClass().getName(), "2 y error");
                Log.i(this.getClass().getName(), "2 lastY = " + lastY + " y = " + y);
            }
        } else {

        }

        Log.i("LENGHT", "L = " + length);
        lastX = x;
        lastY = y;

        return true;
    }
}
