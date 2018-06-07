package com.example.bsw123.shapedroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

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
        if (touched) {
            canvas.drawRect(x - width/2, y - height/2, x + width/2, y + height/2, mPaint);

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