package br.com.startupweek.speciall.DrawingObjects;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by elder-dell on 2016-11-20.
 */

public class DrawingSymbols extends Drawing implements DrawingInterface {

    public DrawingSymbols(){
        super();
    }

    public DrawingSymbols(String preparationText){
        super(preparationText);
    }

    private boolean firstStroke = false;
    private boolean secondStroke = false;
    private boolean thirdStroke = false;
    private boolean forthStroke = false;

    @Override
    public void setContext(Context context) {
        this.context =context;
    }

    @Override
    public void setEndCoordinates(int x, int y) {
        endX = x;
        endY = y;
    }

    @Override
    public boolean validate(int x, int y, int height) {

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        double b = Math.pow((int)y - (int)endY, 2);
        double c = Math.pow((int)x - (int)endX, 2);
        int lenght = (int)Math.sqrt(b + c);
        int minStrokeLenght = (int) (height * 0.3);
        int maxStrokeLenght = (int) (height * 0.6);
        int minErrorMargingForX = (int) (width * 0.2);
        int minErrorMargingForY = (int) (height * 0.2);
/*       ____________
        |/////|/////|
        |  1  |  2  |
        |_____|_____|
        |     |     |
        |  3  |  4  |
        |/////|/////|
 */

        //1.2 # goes after midle of the screen
        if(x < (width/2 * 1.2)  && endX < (width/2 * 1.2)){ // 1 and 3 firstStroke

            if(y < endY &&  lenght >= minStrokeLenght && lenght <= maxStrokeLenght) { // up to down / line with minimum lenght

                if(Math.abs(x - endX) <= minErrorMargingForX){
                    firstStroke = true;
                    return true;
                }
            }
        } else { // 2 and 4 secondStroke, thirdStroke, forthStroke

            if(y < endY &&  lenght >= minStrokeLenght && lenght <= maxStrokeLenght) { // up to down / line with minimum lenght

                if(Math.abs(x - endX) <= minErrorMargingForX){
                    secondStroke = true;
                    return true;
                }
            }

            if(y < height /2 && x > width/2){ // end up on 2 thirdStroke

                if(endX < width/2 && Math.abs(y - endY) < minErrorMargingForY) { // came from 1
                    thirdStroke = true;
                    return true;
                }
            }
            if(y > height /2 && x > width/2) { // end up on 4 forthStroke

                if(endX < width/2 && Math.abs(y - endY) < minErrorMargingForY) { // came from 1
                    forthStroke = true;
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
        return firstStroke && secondStroke && thirdStroke && forthStroke;
    }

}
