/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.ballexample;

import club.lonelypenguin.math.Vector2D;
import javax.swing.SwingUtilities;

/**
 *
 * @author IPsoft
 */
public class App {
    
    public static void main(String args[]){
        
        final BallWindow ballWindow= new BallWindow();
        Runnable r = new Runnable() {
            @Override
            public void run(){
                ballWindow.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
        
    }
    
}
