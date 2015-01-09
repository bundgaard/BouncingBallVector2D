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

    private double x, y;

    public Vector2D() {
        this(0.0, 0.0);
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double newX) {
        this.x = newX;
    }

    public void setY(double newY) {
        this.y = newY;
    }

    public void subtract(Vector2D vector) {
        this.x -= vector.getX();
        this.y -= vector.getY();
    }

    public void addition(Vector2D vector) {
        this.x += vector.getX();
        this.y += vector.getY();
    }

    public void multiply(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }

    public void divide(double scalar) {
        this.x /= scalar;
        this.y /= scalar;
    }

    public void normalize() {
        double m = this.magnitude();
        if (m != 0.0) {
            this.divide(m);
        }
    }

    public void limit(double newLimit) {
        double m = this.magnitude();
        if (m > newLimit) {
            this.normalize();
            this.multiply(newLimit);
        }
    }

    public double magnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double magnitudeSq() {
        return (this.x * this.x + this.y * this.y);
    }

    /*
    returns the value as double in radians.
    remember to * ( 180.0 / Math.PI)
    */
    public double heading() {

        /* 
         Vinkel for X asin(this.x) * (180.0 / Math.PI)
         Vinkel for Y acos(this.y) * (180.0 / Math.PI)
         */
        return -1 * Math.atan2(-y, x);
    }

    public void Rotate() {
    }

    public void Lerp() {
    }

    public void Dist(Vector2D vector1, Vector2D vector2) {
    }

    public void AngleBetween(Vector2D vector1, Vector2D vector2) {
    }

    public void Dot(Vector2D vector1, Vector2D vector2) {
    }

    public void Cross(Vector2D vector1, Vector2D vector2) {
    }

    public static Vector2D Addition(Vector2D vector1, Vector2D vector2) {
        Vector2D tmp = new Vector2D(vector1.getX() + vector2.getX(), vector1.getY() + vector2.getY());
        return tmp;
    }

    public static Vector2D Subtract(Vector2D vector1, Vector2D vector2) {
        Vector2D tmp = new Vector2D(vector1.getX() - vector2.getX(), vector1.getY() - vector2.getY());
        return tmp;
    }

    public static Vector2D Divide(Vector2D vector1, double scalar) {
        Vector2D tmp = new Vector2D(vector1.getX() / scalar, vector1.getY() / scalar);
        return tmp;
    }

    public static Vector2D Multiply(Vector2D vector1, double scalar) {
        Vector2D tmp = new Vector2D(vector1.getX() * scalar, vector1.getY() * scalar);
        return tmp;
    }

    @Override
    public String toString() {
        return String.format("(%.2f,%.2f)", this.x, this.y);
    }
}
