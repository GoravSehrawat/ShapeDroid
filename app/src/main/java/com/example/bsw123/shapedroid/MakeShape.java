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
//class for drwaing the shapes
public class MakeShape extends View {

    float x, y;
    Bitmap bmp;
    Paint mPaint;
    //an arraylist of object named pointslist of class dimensions
    ArrayList<Dimensions> pointsList=new ArrayList<>();
    //an arraylist of object named store of class rectangle store.
    ArrayList<RectAngleStore> Store=new ArrayList<>();
    float width = 200.0f;//setting default values for width and height
    float height = 100.0f;

    boolean touched = false;
//setting up the paint to draw
    public MakeShape(Context context) {
        super(context);
        x = y = 0;
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
    }
//a setter function for setting width and height with slider
    public void setDimensions(float width,float height){
        this.width=width;
        this.height=height;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
//iterate over the list of dimensions to draw on canvas .
        Iterator<Dimensions> iter = pointsList.iterator();
        while(iter.hasNext()) {
            Dimensions touch = iter.next();
//fetching all the dimensions of the rectangle to be drawn
            float x = touch.getX();//x coordinate
            float y = touch.getY();//ycoodinate
            float width=touch.getWidth();//width of the rectangle
            float height=touch.getHeight();//height of the rectangle
//drawing on the canvas
            canvas.drawRect(x - width / 2, y - height / 2, x + width / 2, y + height / 2, mPaint);
        }
    }

    public String print(){
        //function to print the coordinates , this can be imporoved can be converted into json.
        //iterator to iterate over the store.
        Iterator<RectAngleStore> iter = Store.iterator();
        String message = "";
        while(iter.hasNext())
        {
            RectAngleStore item = iter.next();
            message+=item.printCoordinates();
        }
        return message;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touched = true;
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //considering only the move down action to avoid duplicate values
            //getting the touched x and y position
            x = event.getX();//get the x coordinate of touch
            y = event.getY();//get the y coordinate of touch
            //adding the x,y coordinate and current height and width of the rectangle to the object
            pointsList.add(new Dimensions(x, y,width,height));

            //storing the coordinates of the rectangle to the store ,
            RectAngleStore object = new RectAngleStore();
            object.setX1coordinate(x - width / 2);
            object.setX2coordinate(x + width / 2);
            object.setX3coordinate(x + width / 2);
            object.setX4coordinate(x - width / 2);
            object.setY1coordinate(y - height / 2);
            object.setY2coordinate(y - height / 2);
            object.setY3coordinate(y + height / 2);
            object.setY4coordinate(y + height / 2);
            Store.add(object);
        }
        invalidate();
        return true;
    }
}