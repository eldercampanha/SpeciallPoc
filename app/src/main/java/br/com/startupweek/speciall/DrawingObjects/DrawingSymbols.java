package br.com.startupweek.speciall.DrawingObjects;

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

    @Override
    public boolean validate(int x, int y, int height) {
        return false;
    }

    @Override
    public String createPreparationText() {
        return getPreparationText();
    }
}
