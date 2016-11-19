package br.com.startupweek.speciall.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import br.com.startupweek.speciall.R;
import br.com.startupweek.speciall.fingerDrawing.TouchEventView;

public class MainActivity extends AppCompatActivity {

    private static float lastX = 0;
    private static float lastY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.i(this.getClass().getName(), "ON CREATE");

        TouchEventView myView = (TouchEventView)this.findViewById(R.id.view2);
        myView.setInterface(new TouchEventView.TouchEventViewInterface() {
            @Override
            public void ditBrushCoordinatesChanged(float x, float y) {
                checkAcurrency(x,y);
            }
        });
    }

    public boolean checkAcurrency(float x, float y){

//        Log.i(this.getClass().getName(), "x = " + x + " y = " + y);


        //test for the first 'A' stroke
        if( (x + 8)  > lastX ) {
            if ( (int)x < (int)lastX ) {
                Log.i(this.getClass().getName(), "x error");
                Log.i(this.getClass().getName(), " x difference = " + ((int)x - (int)lastX));
            }
        }
        if( (y + 50) < lastY ) {
            Log.i(this.getClass().getName(), "y error");
            Log.i(this.getClass().getName(), "lastY = " + lastY + " y = " + y);
        }
        lastX = x;
        lastY = y;

        return true;
    }
}
