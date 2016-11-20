package br.com.startupweek.speciall.DrawingObjects;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.Window;

import java.io.Serializable;

/**
 * Created by elder-dell on 2016-11-20.
 */

public class DrawingLetters extends Drawing implements DrawingInterface, Serializable {

    private boolean firstStroke = false;
    private boolean secondStroke = false;
    private boolean thirdStroke = false;

    public DrawingLetters(){
        super();
    }

    public DrawingLetters(String preparationText){
        super(preparationText);
    }

    @Override
    public void setContext(Context context) {

    }

    @Override
    public void setEndCoordinates(int x, int y) {
        endX = x;
        endY = y;
    }

    @Override
    public boolean validate(int x, int y, int height) {

        int minLineSize = (int)(height *0.3);
        int maxLineSize = (int)(height *0.7);

        double b = Math.pow((int)y - (int)endY, 2);
        double c = Math.pow((int)x - (int)endX, 2);
        int lenght = (int)Math.sqrt(b + c);


        int minDrawingAreaY = (int) (height * 0.15);
        int maxDrawingAreaY = (int) (height * 0.8);

/*       ____________
        |/////|/////|
        |  1  |  2  |
        |_____|_____|
        |     |     |
        |  3  |  4  |
        |/////|/////|
 */
        if(y > minDrawingAreaY && y < maxDrawingAreaY ){

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
            else if( (int)x > endX && Math.abs(y - endY) < 80){
                thirdStroke = true;
                return true;
            }

        }


        return false;
    }

    @Override
    public boolean isCompleted() {
        return firstStroke && secondStroke && thirdStroke;
    }

    @Override
    public String createPreparationText() {
        return getPreparationText();
    }
}
