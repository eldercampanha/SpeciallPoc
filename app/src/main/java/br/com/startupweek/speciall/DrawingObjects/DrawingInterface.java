package br.com.startupweek.speciall.DrawingObjects;

import android.content.Context;

/**
 * Created by elder-dell on 2016-11-20.
 */

public interface DrawingInterface {

    void setStartCoordinates(int x, int y);
    void setContext(Context context);
    void setEndCoordinates(int x, int y);
    boolean validate (int x, int y, int height);
}
