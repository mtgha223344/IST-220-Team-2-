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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Options extends JPanel{
    
    JButton optReturn, char1, char2, char3;
    
    public Options(){
        super();
        setBackground(Color.BLUE);
        setLayout(null);
        optReturn = new JButton("Return to Main Menu");     //button to return to IntroScreen
        char1 = new JButton("Character 1");
        char2 = new JButton("Character 2");
        char3 = new JButton("Character 3");
        
        add(optReturn);
        add(char1);
        add(char2);
        add(char3);
        
        optReturn.setBounds(new Rectangle(450,375,150,35));
        char1.setBounds(new Rectangle(150,125,125,25));
        char2.setBounds(new Rectangle(150,175,125,25));
        char3.setBounds(new Rectangle(150,225,125,25));
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Font f1 = new Font("Serif", Font.PLAIN, 20);
        g.setFont(f1);
        g.setColor(Color.WHITE);
        g.drawString("Choose 1 of 3 Character types:", 50, 100);
    }
    
}
