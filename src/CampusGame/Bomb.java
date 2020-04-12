/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CampusGame;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JButton;

/**
 *
 * @author bgold
 */
public class Bomb extends JButton{
    
    //creates bombs to drop on player
    int X;
    int Y = 0;
    int dy = 25;
    int width = 25;
    int height = 25;
    
    public Bomb(int inX)
    {
        super();
        X = inX;
    }
    
    public void createBomb()
    {
        Y = Y + dy;
        setBackground(Color.RED);
        setBounds(new Rectangle(X, Y, width, height));
        if(Y > 600){
            Y = 0;
        }
    }
}
