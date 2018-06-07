package com.example.bsw123.shapedroid;

import static java.lang.System.out;

/**
 * Created by bsw123 on 07/06/18.
 */

public class Point {
    private float x;
    private float y;
    Point(float x,float y){
        System.out.print(this.x);

        this.x=x;
        this.y=y;

    }
    public float getX(){
        return this.x;

    }
    public float getY(){
        return  this.y;

    }
}
