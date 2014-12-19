/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.math;

/**
 *
 * @author IPsoft
 */
public class Vector2D {
    
    private double direction;
    private double speed;
    
    
    public Vector2D() {
        this(0.0f, 0.0f);
    }
    
    public Vector2D(double x, double y) {
        this.direction = x;
        this.speed = y;
    }
    
    public double getX() {
        return this.direction;
    }
    
    public double getY() {
        return this.speed;
    }
    
    public void setX(double direction) {
        if ( direction > 0.0f) {
            this.direction = direction;
        }        
    }
    
    public void setY(double speed) {
        if ( speed > 0.0f ) {
            this.speed = speed;
        }
    }
    
    
    
    public Vector2D Subtract(Vector2D vector) {
        
        
        return new Vector2D(getX() + (vector.getX() * -1 ) , getY() + ( vector.getY() * -1));
        
    }
    
    public Vector2D Addition(Vector2D vector) {
        return new Vector2D(getX() + vector.getX(), getY() - vector.getY());
    }
    
    public Vector2D Multiply(double scalar){
        return new Vector2D(getX() * scalar, getY() * scalar);
    }
    
    public Vector2D Divide(double scalar) {
        return new Vector2D(getX() / scalar, getY() / scalar);
    }
    
    public double Magnitude() {
        return Math.sqrt(getX() * getX() + getY() * getY());
    }
    
    public Vector2D Normalize() {
        double m = this.Magnitude();
        Vector2D temp;
        if ( m != 0.0) {
            temp = Divide(m);
            return temp;
        }
        return null;
    }
    public double dotProduct() { return 0.0;}
    
    
    
    
}
