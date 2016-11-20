package br.com.startupweek.speciall.DrawingObjects;

import android.graphics.Point;
import android.view.Display;
import android.view.Window;

/**
 * Created by elder-dell on 2016-11-20.
 */

public class DrawingLetters extends Drawing implements DrawingInterface {

    private boolean firstStroke = false;
    private boolean secondStroke = false;
    private boolean thirdStroke = false;

    @Override
    public void setEndCoordinates(int x, int y) {
        endX = x;
        endY = y;
    }

    @Override
    public boolean validate(int x, int y, int height) {

        int minLineSize = (int)(height *0.6);
        int maxLineSize = (int)(height *0.9);

        double b = Math.pow((int)y - (int)endY, 2);
        double c = Math.pow((int)x - (int)endX, 2);
        int lenght = (int)Math.sqrt(b + c);


        if(lenght <= maxLineSize && lenght >= minLineSize)
        {
            if ((int) y < (int) endY && (int) x > endX) {
                firstStroke = true;
                return true;
            }
            else if ((int) y > (int)endY && (int)x > endX )
            {
                secondStroke = true;
                return true;
            }
        }
        else if( (int)x < endX && Math.abs(y - endY) < 80){
            thirdStroke = true;
            return true;
        }

        return false;
    }
}
