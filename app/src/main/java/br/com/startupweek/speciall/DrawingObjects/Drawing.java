package br.com.startupweek.speciall.DrawingObjects;

import android.content.Context;

/**
 * Created by elder-dell on 2016-11-20.
 */

public class Drawing {

    public static final int LETTERS_TYPE = 0;
    public static final int NUMBERS_TYPE = 1;
    public static final int SYMBOLS_TYPE = 2;
    protected int startX;
    protected int startY;
    protected int endX;
    protected int endY;
    public Context context;

    private String preparationText;

    public Drawing(){

    }

    public Drawing(String preparationText){
        this.preparationText = preparationText;
    }

    public void setStartCoordinates(int x, int y) {
        startX = x;
        startY = y;
    }

    public void setEndCoordinates(int x, int y) {
        endX = x;
        endY = y;
    }

    public String getPreparationText() {
        return preparationText;
    }

    public void setPreparationText(String preparationText) {
        this.preparationText = preparationText;
    }
}
