/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.ballexample;

import club.lonelypenguin.math.Vector2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author IPsoft
 */
public class BallPanel extends JPanel implements Runnable, MouseListener, MouseMotionListener{
    
    Vector2D mouse;
    Vector2D center;
    Vector2D velocity;
    Vector2D location;
    
    BallWindow parent;
    
    
    public BallPanel(BallWindow parent) {
        this.parent = parent;       
        
        init();
        
    }
    
    private void init() {
        Random rand = new Random();
        
        mouse = new Vector2D(0.0, 0.0);
        location = new Vector2D(10,10);
        velocity = new Vector2D(rand.nextDouble() * 2.2, rand.nextDouble() * 2.2);
        
        
        center = new Vector2D( 1.0 * ( parent.getSize().width / 2), 1.0 * (parent.getSize().height / 2) );
        addMouseListener(this);
        addMouseMotionListener(this);
        
        Thread t = new Thread(this);
        t.start();
        
        
       
    }
    
    @Override
    public void run() {
        try { 
            while ( true ) {
                location = location.Addition(velocity);

                repaint();
                Thread.sleep(100);
            }
            
        }catch (InterruptedException ie) {
            System.err.println("" + ie.getMessage());
        }
        
    }
    
    
    private void checkEdge() {
        if ( (location.getX() > 640) ) {
            location.setX(0);
        } else if ( location.getX() < 0 ) {
            location.setX(640);
        }
        
        if ( location.getY() > 480 ) {
            location.setY(0);
        } else if ( location.getY() < 0){
            location.setY(480); 
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        checkEdge();
        
        g.drawString(
                String.format("mouseX %d mouseY %d centerX %d, centerY %d magnitude %d", 
                        (int) mouse.getX(),(int) mouse.getY(),
                        (int) center.getX(), (int) center.getY(),
                        (int) mouse.Magnitude()
                ), 10, 10);
        
        mouse = mouse.Subtract(center).Normalize().Multiply(50.0);
        
        g.setColor(Color.GREEN);
        g.fillOval((int) location.getX(), (int) location.getY(), 64, 64);
        g.setColor(Color.BLACK);
        
        g.translate((int) center.getX(), (int) center.getY() );
        g.drawLine(0,0,(int) mouse.getX(), (int) mouse.getY());
        g.translate((int)-center.getX(),(int)-center.getY());
        g.fillRect(0,parent.getSize().height - 70,(int) mouse.Magnitude(),10);
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    
    }

    @Override
    public void mousePressed(MouseEvent e) {
    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouse.setX(e.getXOnScreen());
        mouse.setY(e.getYOnScreen());
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouse.setX(e.getXOnScreen());
        mouse.setY(e.getYOnScreen());
        repaint();
     
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouse.setX(e.getX());
        mouse.setY(e.getY());
        repaint();
    }
    
    
    
    
    
    
}
