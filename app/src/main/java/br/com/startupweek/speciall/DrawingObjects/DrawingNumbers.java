package br.com.startupweek.speciall.DrawingObjects;

/**
 * Created by elder-dell on 2016-11-20.
 */

public class DrawingNumbers extends Drawing implements DrawingInterface {


    private boolean firsStroke = false;
    private boolean secondStroke = false;

    @Override
    public void setEndCoordinates(int x, int y) {
        endX = x;
        endY = y;
    }

    @Override
    public boolean validate(int x, int y, int height) {

        int minLineSizeFS = (int)(height *0.1);
        int maxLineSizeFS = (int)(height *0.3);
        int minLineSizeSS = (int)(height *0.4);
        int maxLineSizeSS = (int)(height *0.9);
        int halfScreen = (int)(height *0.5);

        double b = Math.pow((int)y - (int)endY, 2);
        double c = Math.pow((int)x - (int)endX, 2);
        int lenght = (int)Math.sqrt(b + c);

        if(Math.abs(endY - y) > minLineSizeFS ) {
            if (x > endX && y < endY && lenght >= minLineSizeFS && lenght <= maxLineSizeFS) {
                firsStroke = true;
                return true;
            } else if (y > endY && lenght >= minLineSizeSS && lenght <= maxLineSizeSS) {
                secondStroke = true;
                return true;
            }
        }

        return false;
    }
}
