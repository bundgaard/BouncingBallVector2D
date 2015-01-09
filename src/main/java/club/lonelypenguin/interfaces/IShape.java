/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.interfaces;

import club.lonelypenguin.ballexample.Liquid;
import java.awt.Graphics;

/**
 *
 * @author davidb
 */
public interface IShape {
    
    public void update();
    public void display(Graphics g);
    public void checkEdge();
    public boolean isInside(Liquid l);
    public void drag(Liquid l);
    
}
