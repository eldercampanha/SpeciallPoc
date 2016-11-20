package br.com.startupweek.speciall.DrawingObjects;

/**
 * Created by elder-dell on 2016-11-20.
 */

public interface DrawingInterface {

    void setStartCoordinates(int x, int y);
    void setEndCoordinates(int x, int y);
    boolean validate (int x, int y, int height);
}
