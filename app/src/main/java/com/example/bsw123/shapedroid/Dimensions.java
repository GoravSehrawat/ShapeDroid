package com.example.bsw123.shapedroid;

/**
 * Created by bsw123 on 07/06/18.
 */

public class Dimensions {
    private float width;
    private float height;
    private float x;
    private float y;

    Dimensions(float x,float y,float width,float height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;

    }
    public float getX(){
        return this.x;

    }
    public float getY(){
        return  this.y;

    }
    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width=width;
    }
    public  float getHeight(){
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
