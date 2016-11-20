package br.com.startupweek.speciall.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import br.com.startupweek.speciall.R;
import br.com.startupweek.speciall.fingerDrawing.TouchEventView;

public class MainActivity extends AppCompatActivity {

    private static float lastX = 0;
    private static float lastY = 0;
    private int counter = 0;
    private ImageView imgLetter;
    private TouchEventView myView;
    private int lines = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.i(this.getClass().getName(), "ON CREATE");

        myView = (TouchEventView)this.findViewById(R.id.view2);
        myView.setInterface(new TouchEventView.TouchEventViewInterface() {
            @Override
            public void ditBrushCoordinatesChanged(float x, float y, float length) {
//                checkAcurrency(x,y, length);
            }

            @Override
            public void didFinishTouchEvent(float x, float y) {
                calculateLineLength(x, y);
                //counter++;
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
        int lenght = (int)Math.sqrt(b + c);
        Log.i("LENGHT", "L = " + lenght);

        if((int)lastY > (int)y) {
            if ((int) lastY <= 1270 && (int) y >= 50 && lenght <= 1200 && lenght >= 1100) {
                Toast.makeText(this,"Good Job!",Toast.LENGTH_SHORT).show();
                lines++;
//                Log.i("TAG", "success down up");
//                Log.i("TAG", "success X " + (int) x + " " + (int) lastX);
//                Log.i("TAG", "success Y" + (int) y + " " + (int) lastY);
            }
        }
        else if((int)lastY < (int)y) {
            if ((int) y <= 1270 && (int) lastY >= 50 && lenght <= 1200 && lenght >= 1100) {
                Toast.makeText(this,"Good Job!",Toast.LENGTH_SHORT).show();
                lines++;
//                Log.i("TAG", "success up down");
//                Log.i("TAG", "success X " + (int) x + " " + (int) lastX);
//                Log.i("TAG", "success Y" + (int) y + " " + (int) lastY);
            }
        }


        if ( (int)lastX > (int)x ){//&& Math.abs((int)lastY - (int)y)  < 50){
                Toast.makeText(this,"Good Job!",Toast.LENGTH_SHORT).show();
        }
                Log.i("TAG", "success X " + (int)lastX  + " " + (int)x + " " +Math.abs((int)lastY - (int)y));

//        switch (counter){
//            case 0:
//                if(lastY < 1300 && y > 50 && lenght <= 1200)
//                    Log.i("TAG","success");
//                return;
//            case 1:
//                return;
//
//            case 2:
//                return;
//        }
    }

}
