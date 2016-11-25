package br.com.startupweek.speciall.fingerDrawing;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.ArrayList;

public class Polygon {

    ArrayList<Point> points = new ArrayList<>();

    public void addPoints(Point point){
        this.points.add(point);
    }

    public void drawPolygon (Canvas canvas, Paint paint){


        for (int i = 1; i < points.size(); i++){
            canvas.drawLine(points.get(i-1).x, points.get(i-1).y, points.get(i).x, points.get(i).y, paint);
        }

    }

    public boolean containsPoint(Point point) {

        int i, j, nvert = this.points.size();
        boolean c = false;

        for(i = 0, j = nvert - 1; i < nvert; j = i++) {
            if( ( (points.get(i).y >= point.y ) != (points.get(j).y >= point.y) ) &&
                    (point.x <= (points.get(j).x - points.get(i).x) * (point.y - points.get(i).y) / (points.get(j).y - points.get(i).y) + points.get(i).x)
                    )
                c = !c;
        }

        return c;
    }
}
