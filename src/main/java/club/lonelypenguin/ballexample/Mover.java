/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.ballexample;

import club.lonelypenguin.interfaces.IShape;
import club.lonelypenguin.math.Vector2D;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author davidb
 */
public class Mover implements IShape {

    private Vector2D location;
    private Vector2D velocity;
    private Vector2D acceleration;
    private Vector2D gravity;
    private Vector2D boxSize;

    private double mass; // the objects mass, eveything has a weight

    public Mover() {
        init();
    }

    @Override
    public void display(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawOval((int) location.getX(), (int) location.getY(), 16, 16);
        g.setColor(Color.black);
        g.fillOval((int) location.getX(), (int) location.getY(), 16, 16);
    }

    public void applyForce(Vector2D force) {
        Vector2D f = Vector2D.Divide(force, mass);
        acceleration.addition(f);
    }

    @Override
    public void checkEdge() {

        if (location.getX() > 640) {
            location.setX(0.0);
        } else if (location.getX() < 0) {
            location.setX(640);
        }

        if (location.getY() > 480) {
            velocity.setY(velocity.getY() * -1);
            location.setY(0.0);
        } 
    }

    @Override
    public void update() {
        acceleration = new Vector2D(-0.001, 0.01);
        velocity.addition(acceleration);
        location.addition(velocity);
    }

    private void init() {
        location = new Vector2D(320, 0);
        velocity = new Vector2D(0.0, 0.0);
        mass = 20.0;
    }

    @Override
    public void drag(Liquid liquid) {
        double speed = velocity.magnitude();
        double dragMagnitude = liquid.getC() * speed * speed;

        Vector2D drag = velocity;
        drag.multiply(-1);
        drag.normalize();
        drag.multiply(dragMagnitude);
        applyForce(drag);
    }

    @Override
    public boolean isInside(Liquid liquid) {
        return this.location.getX() > liquid.getX()
                && this.location.getX() < liquid.getX() + liquid.getWidth()
                && this.location.getY() > liquid.getY()
                && this.location.getY() < liquid.getY() + liquid.getHeight();
    }
}
