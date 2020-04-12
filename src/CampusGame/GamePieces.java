/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CampusGame;

import java.awt.Rectangle;
import javax.swing.JButton;

/**
 *
 * @author bgold
 */
public class GamePieces extends JButton{
    
    //adds game pieces to board
    
    int X, Y;
    int width = 20;
    int heigth = 20;
    
    public GamePieces()
    { 
        super(); 
    }
    
    public void setGamePieces()
    {
        double r1 = Math.random();
        double r2 = Math.random();
        
        X = (int) (r1 * 800f);
        Y = (int) (r2 * 500f);
        setBounds(new Rectangle(X, Y, width, heigth));
    }
    
}
