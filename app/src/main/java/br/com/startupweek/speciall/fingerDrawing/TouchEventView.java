package br.com.startupweek.speciall.fingerDrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by elder-dell on 2016-11-19.
 */

public class TouchEventView extends View {

    public ArrayList<Polygon> polygons = new ArrayList<>();
    boolean opa = true;

    public interface TouchEventViewInterface{
        void ditBrushCoordinatesChanged(Point point);
        void ditBrushCoordinatesChanged(float x, float y, float length);
        void didFinishTouchEvent(float x, float y);
        void didBeginTouchEvent(float x, float y);
    }

    private TouchEventViewInterface touchEventViewInterface;
    private Paint paint = new Paint();
    public Path path = new Path();

    public TouchEventView(Context ctx, AttributeSet attrs){
        super(ctx, attrs);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(Polygon p :  polygons)
            p.drawPolygon(canvas, paint);

        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float xPosition = event.getX();
        float yPosition = event.getY();


        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                path.moveTo(xPosition, yPosition);
                touchEventViewInterface.didBeginTouchEvent(xPosition,yPosition);
                return true;
            case MotionEvent.ACTION_MOVE:
                touchEventViewInterface.ditBrushCoordinatesChanged(new Point((int)xPosition,(int)yPosition));
                path.lineTo(xPosition,yPosition);
                break;
            case MotionEvent.ACTION_UP:
                touchEventViewInterface.didFinishTouchEvent(xPosition,yPosition);
//                path.reset();
                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }

    public void setInterface(TouchEventViewInterface eventViewInterface){
        this.touchEventViewInterface = eventViewInterface;
    }
}

