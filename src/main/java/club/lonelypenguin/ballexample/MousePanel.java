/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.ballexample;

import club.lonelypenguin.math.Vector2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author davidb
 */
public class MousePanel extends JPanel implements Runnable, MouseListener, MouseMotionListener{
    
    
    private final BallWindow parent;
    private Vector2D mouse;
    private Vector2D location;
    
    public MousePanel(BallWindow parent) {
        this.parent = parent;
        init();
        
    }
    
    private void init() {
        Random rand = new Random();
        
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

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
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouse = new Vector2D(e.getX(), e.getY());
        repaint(); 
        
    }
    
}
