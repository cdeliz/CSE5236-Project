package com.example.chris.comicalstudios;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Chris on 11/25/2014.
 */
public class DrawingFragment extends Fragment {

    protected Page currentPage;
    protected Tool currentTool;

    private Bitmap pageBitmap;
    private Paint pagePaint;


    public DrawingFragment() {
        //super(context,attrs);
    }

    /*@Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        pageBitmap = currentPage.getBitmap();    //get currentPage bitmap
        w = pageBitmap.getWidth();
        h = pageBitmap.getHeight();

        pagePaint = currentPage.getPaint();
    }*/

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {

        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentTool.Touch(event);
                //drawPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                currentTool.Move(event); //drawPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                currentTool.Untouch(event);
                //drawCanvas.drawPath(drawPath, drawPaint);
                //drawPath.reset();
                break;
            default:
                return false;
        }
        //invalidate();
        return true;
    }*/

    /*@Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(pageBitmap, 0, 0, pagePaint);
    }*/

}
