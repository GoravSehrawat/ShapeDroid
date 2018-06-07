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
    ArrayList<Point> pointsList=new ArrayList<>();
    ArrayList<RectAngleStore> Store=new ArrayList<>();
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
        Iterator<Point> iter = pointsList.iterator();
        int length=pointsList.size();
        if(length==0){
            return;
        }
        Point touch=pointsList.get(pointsList.size()-1) ;
       // while(iter.hasNext()){
            System.out.println("count");

           // Point touch =iter.next();
            float x = touch.getX();
            float y=touch.getY();
          //  if (touched) {
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

    public String print(){
        Iterator<RectAngleStore> iter2 = Store.iterator();
        String message = "";
        while(iter2.hasNext())
        {
            RectAngleStore yp = iter2.next();
            message+=yp.printCoordinates();
        }
        return  message;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touched = true;
        //getting the touched x and y position
        x = event.getX();
         y = event.getY();
        pointsList.add(new Point(x,y));

        invalidate();
        return true;
    }
}