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
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author IPsoft
 */
public class BallPanel extends JPanel implements Runnable {

    BallWindow parent;
    
    ArrayList<IShape> shapes = new ArrayList<>();
    
    public BallPanel(BallWindow parent) {
        this.parent = parent;
        init();
    }

    private void init() {
        Random rand = new Random();
        Mover mover = new Mover();

        Color colors[] = new Color[5];
        colors[0] = Color.gray;
        colors[1] = Color.gray.brighter();
        colors[2] = Color.yellow.darker();
        colors[3] = Color.yellow.brighter();
        colors[4] = new Color(127, 127, 127);

        shapes.add(mover);

        Thread t = new Thread(this);
        t.start();

    }

    @Override
    public void run() {

        try {
            while (true) {
                for(IShape shape : shapes) {
                    shape.update();
                    shape.checkEdge();
                    repaint();
                }
//                for (Ball b : balls) {
//                    Vector2D acceleration = new Vector2D(0.02, 0.1);
//
//                    b.getVelocity().addition(acceleration);
//                    b.getVelocity().limit(10);
//                    b.getLocation().addition(b.getVelocity());
//                    acceleration.multiply(0);
//                    repaint();
//                }
//                for ( int i = 0; i < 5; i++) 
//                {
//                    
//                    balls[i].setLocation(balls[i].getLocation().Addition(balls[i].getVelocity()));
//                    repaint();
//                }
                Thread.sleep(35);
            }
        } catch (InterruptedException ie) {
            System.err.println("" + ie.getMessage());
        }
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        Liquid l = new Liquid(0, 240, 640, 240, 0.9);
        g.setColor(new Color(128,128,255,128));
        
        g.fillRect(0,480 >> 1, 640, 480 >> 1);
        for(IShape shape : shapes) {
            if ( shape.isInside(l)) {
                shape.drag(l);
            }
            shape.display(g);
            
        }

//        BufferedImage offscreenImage = new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);
//        Graphics2D offscreenGraphics = offscreenImage.createGraphics();
//        offscreenGraphics.clearRect(0, 0, 640, 480);
//        offscreenGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//        Vector2D wind = new Vector2D(0.001, 0);
//
//        Liquid liquid = new Liquid(0, 480 >> 1, 640, 480 >> 1, 0.1);
//        offscreenGraphics.setColor(Color.blue);
//        offscreenGraphics.fillRect(0, 480 >> 1, 640, 480 >> 1);
//        for (Shape s : shapes) {
//            s.display(g);
//        }
//        for (Ball b : balls) {
//            
//            if ( b.isInside(liquid)) {
//                b.drag(liquid);
//            }
//            double m = 0.1 * b.getMass();
//            Vector2D gravity = new Vector2D(0,m);
//            
//            b.applyForce(gravity);
//
//            
//            //b.checkEdgeBounce(640, 480);
//            offscreenGraphics.setColor(b.getColor());
//            offscreenGraphics.fillOval((int) b.getLocation().getX(), (int) b.getLocation().getY(), (int) (b.getMass() * b.getSize().width * 0.3), (int) (b.getMass() * b.getSize().height * .3));
//            b.checkEdgeChangeVelocity(640, 480);
//        }
//        

//        g.setColor(Color.RED);
//        g.drawImage(offscreenImage, 0, 0, this);
//        g.drawRect(0, 0, 640 - 1, 480 - 1);
    }
}
