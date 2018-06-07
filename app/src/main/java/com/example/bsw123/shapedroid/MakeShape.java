package com.example.bsw123.shapedroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by bsw123 on 07/06/18.
 */

public class MakeShape extends View {

    float x, y;
    Bitmap bmp;
    Paint mPaint;
    float width = 200.0f;
    float height = 100.0f;

    boolean touched = false;

    public MakeShape(Context context) {
        super(context);
        x = y = 0;
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        ArrayList<RectAngleStore> Store;
        Store = new ArrayList();
        if (touched) {
            RectAngleStore object=new RectAngleStore();
            canvas.drawRect(x - width/2, y - height/2, x + width/2, y + height/2, mPaint);
            object.setX1coordinate(x-width/2);
            object.setX2coordinate(x+width/2);
            object.setX3coordinate(x+width/2);
            object.setX4coordinate(x-width/2);
            object.setY1coordinate(y-height/2);
            object.setY2coordinate(y-height/2);
            object.setY3coordinate(y+height/2);
            object.setY4coordinate(y+height/2);
            Store.add(object);
        }
        Iterator<RectAngleStore> iter = Store.iterator();
        while(iter.hasNext())
        {
            RectAngleStore yp = iter.next();
            yp.printCoordinates();
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touched = true;
        //getting the touched x and y position
        x = event.getX();
        y = event.getY();
        invalidate();
        return true;
    }
}