package br.com.startupweek.speciall.fingerDrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by elder-dell on 2016-11-19.
 */

public class TouchEventView extends View {

    public interface TouchEventViewInterface{
        void ditBrushCoordinatesChanged(float x, float y);
    }

    private TouchEventViewInterface touchEventViewInterface;
    private Paint paint = new Paint();
    private Path path = new Path();

    public TouchEventView(Context ctx, AttributeSet attrs){
        super(ctx, attrs);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float xPosition = event.getX();
        float yPosition = event.getY();

        if(this.touchEventViewInterface != null)
            this.touchEventViewInterface.ditBrushCoordinatesChanged(xPosition, yPosition);

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                path.moveTo(xPosition, yPosition);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(xPosition,yPosition);
                break;
            case MotionEvent.ACTION_UP:
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
