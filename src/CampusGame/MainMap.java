/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CampusGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class MainMap extends JPanel{
    
    Game1 gm1;
    Game2 gm2;
    Game3 gm3;
    JButton mapReturn, game1, game2, game3, gameOver;
    
    public MainMap(){ 
        super();
        SetUpForMainMap();
    }
    
    public void SetUpForMainMap()
    {
        setBackground(Color.white);
        setLayout(null);
        
        
        mapReturn = new JButton("Return to Main Menu");     //button to return to IntroScreen
        game1 = new JButton("Game 1");
        game2 = new JButton("Game 2");
        game3 = new JButton("Game 3");
        gameOver = new JButton("Game Over");
        
        add(mapReturn);
        add(game1);
        add(game2);
        add(game3);
        add(gameOver);
        
        mapReturn.setBounds(new Rectangle(450,375,150,35));
        game1.setBounds(new Rectangle(450,50,150,50));
        game2.setBounds(new Rectangle(450,125,150,50));
        game3.setBounds(new Rectangle(450,200,150,50));
        gameOver.setBounds(new Rectangle(450,275,150,50));
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Font f1 = new Font("Serif", Font.BOLD, 20);
        g.setFont(f1);
        g.setColor(Color.BLUE);
        g.drawString("Main Map", 50, 100);
    }
    
}
