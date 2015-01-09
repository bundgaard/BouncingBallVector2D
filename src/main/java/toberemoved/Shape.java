/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.ballexample;

import club.lonelypenguin.math.Vector2D;
import java.awt.Graphics;

/**
 *
 * @author davidb
 */
public abstract class Shape {
    
    private double width, height;
    private double mass;
    
    private Vector2D location;
    private Vector2D velocity;
    
    
    public abstract void display(Graphics g);
    
    public abstract void update(Graphics g);
    
    public Vector2D getLocation() {
        return this.location;
    }
    
    public void setLocation(Vector2D newLocation) {
        this.location = newLocation;
    }
    
    public Vector2D getVelocity() {
        return this.velocity;
    }
    public void setVelocity(Vector2D newVelocity) {
        this.velocity = newVelocity;
    }
    
//    public void setX(double newX) {
//        this.x = newX;
//    }
//    
//    public void setY(double newY) {
//        this.y = newY;
//    }
//    
    public void setWidth(double newWidth) {
        this.width = newWidth;
    }
    
    public void setHeight(double newHeight) {
        this.height = newHeight;
    }
    
//    public double getX() {
//        return this.x;
//    }
//    
//    public double getY() {
//        return this.y;
//    }
//    
    public double getWidth() {
        return this.width;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public void setMass(double newMass) {
        this.mass = newMass;
    }
    
    public double getMass() {
        return this.mass;
    }
    
    
    
}
