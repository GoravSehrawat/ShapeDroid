package com.example.bsw123.shapedroid;

/**
 * Created by bsw123 on 07/06/18.
 */

public class RectAngleStore {
    private float X1coordinate;
    private float X2coordinate;
    private float X3coordinate;
    private float X4coordinate;
    private float Y1coordinate;
    private float Y2coordinate;
    private float Y3coordinate;
    private float Y4coordinate;

    public float getX1coordinate() {
        return X1coordinate;
    }

    public void setX1coordinate(float x1coordinate) {
        X1coordinate = x1coordinate;
    }

    public float getX2coordinate() {
        return X2coordinate;
    }

    public void setX2coordinate(float x2coordinate) {
        X2coordinate = x2coordinate;
    }

    public float getX3coordinate() {
        return X3coordinate;
    }

    public void setX3coordinate(float x3coordinate) {
        X3coordinate = x3coordinate;
    }

    public float getX4coordinate() {
        return X4coordinate;
    }

    public void setX4coordinate(float x4coordinate) {
        X4coordinate = x4coordinate;
    }

    public float getY1coordinate() {
        return Y1coordinate;
    }

    public void setY1coordinate(float y1coordinate) {
        Y1coordinate = y1coordinate;
    }

    public float getY2coordinate() {
        return Y2coordinate;
    }

    public void setY2coordinate(float y2coordinate) {
        Y2coordinate = y2coordinate;
    }

    public float getY3coordinate() {
        return Y3coordinate;
    }

    public void setY3coordinate(float y3coordinate) {
        Y3coordinate = y3coordinate;
    }

    public float getY4coordinate() {
        return Y4coordinate;
    }

    public void setY4coordinate(float y4coordinate) {
        Y4coordinate = y4coordinate;
    }
    public String makeCoordinateSets(float x,float y){
        String output ="("+x+","+y+")";
        return  output;


    }
    public String printCoordinates(){
        String output="coordinates:[";
        output+=makeCoordinateSets(this.getX1coordinate(),this.getY1coordinate());
        output+=makeCoordinateSets(this.getX2coordinate(),this.getY2coordinate());
        output+=makeCoordinateSets(this.getX3coordinate(),this.getY3coordinate());
        output+=makeCoordinateSets(this.getX4coordinate(),this.getY4coordinate());
        output+="]";
       // System.out.println(output);
        return output;
    }
}
