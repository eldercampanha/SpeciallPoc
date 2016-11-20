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
//                lastX = x;
//                lastY = y;
                drawingInterface.setEndCoordinates( (int) x, (int) y);
            }
        });
    }

    private void calculateLineLength(float x, float y) {

//        int width = size.x;
//        int maxY = (int)(height * 0.9);
//        int minY = (int)(height * 0.1);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;
        int minLineSize = (int)(height *0.6);
        int maxLineSize = (int)(height *0.9);


//        double b = Math.pow((int)y - (int)lastY, 2);
//        double c = Math.pow((int)x - (int)lastX, 2);
//        int lenght = (int)Math.sqrt(b + c);


        if(drawingInterface.validate((int)x, (int)y, height))
            Toast.makeText(this, "from Drawing Good Job!", Toast.LENGTH_SHORT).show();


//
//        Log.i("TAG", "W " + width + " H " + height);
//        Log.i("TAG", "L = " + lenght);
//        Log.i("TAG", "minY = " + minY);
//        Log.i("TAG", "maxY = " + maxY);
//        Log.i("TAG", "minLineSize = " + minLineSize);
//        Log.i("TAG", "maxLineSize = " + maxLineSize);
//        Log.i("TAG", "success X " + (int) x + " LX " + (int) lastX);
//        Log.i("TAG", "success Y " + (int) y + " LY" + (int) lastY);

//        I/TAG: W 1080 H 1776
//        I/TAG: L = 1288
//        I/TAG: minY = 177
//        I/TAG: maxY = 1598
//        I/TAG: minLineSize = 1243
//        I/TAG: maxLineSize = 1598
//        I/TAG: success X 556 LX 67
//        I/TAG: success Y 102 LY 1294
//        I/TAG: success X 67 556 1192

//        I/TAG: W 720 H 1184
//        I/TAG: L = 702
//        I/TAG: minY = 118
//        I/TAG: maxY = 1065
//        I/TAG: minLineSize = 828
//        I/TAG: maxLineSize = 1065
//        I/TAG: success X 405 LX 83
//        I/TAG: success Y 151 LY 775
//        I/TAG: success X 83 405 624



//        if(lenght <= maxLineSize && lenght >= minLineSize)
//        {
//
//            if ((int) y < (int) lastY && (int) x > lastX) {
//                Toast.makeText(this, "LY > y Good Job!", Toast.LENGTH_SHORT).show();
//                lines++;
//            }
//            else if ((int) y > (int)lastY && (int)x > lastX )
//            {
//                Toast.makeText(this, "Good Job!", Toast.LENGTH_SHORT).show();
//                lines++;
//            }
//        }
//        else if( (int)x < lastX && Math.abs(y - lastY) < 80){
//            Toast.makeText(this, "Good Job!", Toast.LENGTH_SHORT).show();
//        }
//    }

//        if ( (int)lastX > (int)x ){//&& Math.abs((int)lastY - (int)y)  < 50){
//                Toast.makeText(this,"Good Job!",Toast.LENGTH_SHORT).show();
//        }
//        Log.i("TAG", "success X " + (int)lastX  + " " + (int)x + " " +Math.abs((int)lastY - (int)y));

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
