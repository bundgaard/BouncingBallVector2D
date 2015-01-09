/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.ballexample;

/**
 *
 * @author davidb
 */
public class Liquid {
    
    private double x,y,w,h;
    
    private double c;
    
    public Liquid(double x, double y, double w, double h, double c) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.c = c;
    }
    
    public void setX(double newX){
        this.x = newX;
    }
    
    public void setY(double newY){
        this.y = newY;
    }
    
    public void setWidth(double newW){
        this.w = newW;
    }
    public void setHeight(double newHeight) {
        this.h = newHeight;
    }
    
    public double getWidth() {
        return this.w;
    }
    
    public double getHeight() {
        return this.h;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setC(double newC){
        this.c = newC;
    }
    
    public double getC() {
        return this.c;
    }
    
    
    
}
