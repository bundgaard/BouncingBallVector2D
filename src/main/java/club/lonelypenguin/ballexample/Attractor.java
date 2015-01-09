/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.ballexample;

import club.lonelypenguin.math.Vector2D;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author davidb
 */
public class Attractor extends Shape {
    
    
    
    public Attractor() {
        this.setLocation(new Vector2D(320,240));
        this.setMass(20);
        
    }

    @Override
    public void display(Graphics g) {
        g.setColor(new Color(175,200,0));
        
        g.fillOval((int) getLocation().getX(),(int)  getLocation().getY(), (int) getMass() * 2, (int) getMass() * 2);
        g.setColor(Color.BLACK);
        g.drawOval((int) getLocation().getX(), (int) getLocation().getY(), (int) getMass() * 2 , (int) getMass() * 2 );
        
    }

    @Override
    public void update(Graphics g) {
        
    }
    
}
