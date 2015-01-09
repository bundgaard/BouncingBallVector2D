/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.ballexample;

import club.lonelypenguin.math.Vector2D;
import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author davidb
 */
public class Ball {

    private Vector2D location;
    private Vector2D velocity;
    private Vector2D acceleration;

    private Color color;
    private Dimension size;
    private String id;

    private double mass;
    private double drag;

    public Ball() {
        this(new Vector2D(0, 0), new Vector2D(0, 0), Color.WHITE, new Dimension(10, 10), 10.0,0.0);

    }

    public Ball(Vector2D location, Vector2D velocity, Color color, Dimension size) {
        this(location, velocity, color, size, 10.0,0.0);
    }

    public Ball(Vector2D location, Vector2D velocity, Color color, Dimension size, double mass, double drag) {
        this.color = color;
        this.location = location;
        this.velocity = velocity;
        this.acceleration = new Vector2D(0, 0);
        this.size = size;
        this.mass = mass;
        this.drag = drag;
    }

    public double getMass() {
        return this.mass;
    }

    public double getDrag() {
        return this.drag;
    }
    
    public void drag(Liquid liquid) {
        double speed = getVelocity().magnitude();
        double dragMagnitude = liquid.getC() * speed * speed;
        
        Vector2D drag = getVelocity();
        drag.multiply(-1);
        drag.normalize();
        drag.multiply(dragMagnitude);
        applyForce(drag);
    }
    public boolean isInside(Liquid liquid) {
        if (this.getLocation().getX() > liquid.getX()
                && this.getLocation().getX() < liquid.getX() + liquid.getWidth()
                && this.getLocation().getY() > liquid.getY()
                && this.getLocation().getY() < liquid.getY() + liquid.getHeight()) {
            return true;
        } else {
            return false;
        }
    }

    public void setLocation(Vector2D newLocation) {
        if (newLocation != null) {
            this.location = newLocation;
        }
    }

    public void setVelocity(Vector2D newVelocity) {
        if (newVelocity != null) {
            this.velocity = newVelocity;
        }
    }

    public Vector2D getVelocity() {
        return this.velocity;
    }

    public Vector2D getLocation() {
        return this.location;
    }

    public void setAcceleration(Vector2D newAcceleration) {
        this.acceleration = newAcceleration;
    }

    public Vector2D getAcceleration() {
        return this.acceleration;
    }

    public void setColor(Color newColor) {
        if (newColor != null) {
            this.color = newColor;
        }
    }

    public Color getColor() {
        return this.color;
    }

    public void setSize(Dimension size) {
        if (size != null) {
            this.size = size;
        }
    }

    public Dimension getSize() {
        return this.size;
    }

    public void applyForce(Vector2D force) {
        Vector2D f = Vector2D.Divide(force, mass);

        acceleration.addition(f);
    }

    @Override
    public String toString() {
        return String.format("Velocity %.2f,%.2f\nLocation %.2f,%.2f", this.velocity.getX(), this.velocity.getY(), this.location.getX(), this.location.getY());
    }

    public void checkEdge(Dimension size) {
        checkEdge(size.width, size.height);
    }

    // Rain algorithm
    public void checkEdge(int width, int height) {
        if (this.location.getX() > width) {
            this.location.setX(0);
        } else if (this.location.getX() < 0) {
            this.location.setX(width);
        }

        if (this.location.getY() > height) {
            this.location.setY(0);
        } else if (this.location.getY() < 0) {
            this.location.setY(height);
        }

    }

    // Bounce
    public void checkEdgeBounce(Dimension size) {
        checkEdgeBounce(size.width, size.height);
    }

    public void checkEdgeBounce(int width, int height) {
        if ((this.location.getX() + this.getSize().width > width) || (this.location.getX() + this.getSize().width < 0)) {
            this.velocity.setX(this.velocity.getX() * -1);

        }
        if ((this.location.getY() + getSize().height > height) || (this.location.getY() + getSize().height < 0)) {
            this.velocity.setY(this.velocity.getY() * -1);
        }
    }

    public void checkEdgeChangeVelocity(int width, int height) {
        if (this.location.getX() > width) {
            location.setX(width);
            velocity.setX(velocity.getX() * -1);
        } else if (this.location.getX() < 0) {
            velocity.setX(velocity.getX() * -1);
            location.setX(0);
        }

        if (this.location.getY() > height) {
            velocity.setY(velocity.getY() * - 1);
            location.setY(height);
        }
    }

}
