package br.com.startupweek.speciall.DrawingObjects;

import android.content.Context;

/**
 * Created by elder-dell on 2016-11-20.
 */

public class DrawingNumbers extends Drawing implements DrawingInterface {


    private boolean firsStroke = false;
    private boolean secondStroke = false;

    public DrawingNumbers(){
        super();
    }

    public DrawingNumbers(String preparationText){
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

        //first Stroke
        int minLineSizeFS = (int)(height *0.1);
        int maxLineSizeFS = (int)(height *0.3);

        //Second Stroke
        int minLineSizeSS = (int)(height *0.4);
        int maxLineSizeSS = (int)(height *0.7);
        //int halfScreen = (int)(height *0.5);

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


        if(y >= minDrawingAreaY && y <= maxDrawingAreaY) {

            if (Math.abs(endY - y) < minLineSizeFS) { // fisrt Stroke

                if (x > endX && y < endY && lenght >= minLineSizeFS && lenght <= maxLineSizeFS) {
                    firsStroke = true;
                    return true;
                }
            }
            else { // second Stroke
                if (y > endY && lenght >= minLineSizeSS && lenght <= maxLineSizeSS) {
                    secondStroke = true;
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public String createPreparationText() {
        return getPreparationText();
    }

    @Override
    public boolean isCompleted() {
        return firsStroke && secondStroke;
    }

}
