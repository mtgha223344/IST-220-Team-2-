/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CampusGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Options extends JPanel{
    
    boolean isStudentSelected = true, isMascotSelected = false, isProfessorSelected = false, isTheme1Selected = false, isTheme2Selected = false, isTheme3Selected = false;
    JButton optReturn, char1, char2, char3, them1, them2, them3;
    private final Image studentIcon, professorIcon, mascotIcon, defaultBackground, computersBackground, sportsBackground;
    
    public Options(){
        super();
        setBackground(Color.BLUE);
        setLayout(null);
   
        defaultBackground = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/pennStateBackground.JPG"));
        computersBackground = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/computersBackground.JPG"));
        sportsBackground = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/sportsBackground.JPG"));
        
        studentIcon = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/icon.JPG"));
        professorIcon = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/professorIcon.JPG"));
        mascotIcon = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/mascotIcon.JPG"));
        
        optReturn = new JButton("Return to Main Menu");     //button to return to IntroScreen
        char1 = new JButton("Nittany Lion");
        char2 = new JButton("Student");
        char3 = new JButton("Professor");
        
        them1= new JButton("Penn State (Default)");
        them2 = new JButton("Computers");
        them3 = new JButton("Sports");
        
        add(optReturn);
        add(char1);
        add(char2);
        add(char3);
        add(them1);
        add(them2);
        add(them3);
        
        optReturn.setBounds(new Rectangle(620,480,150,35));
        char1.setBounds(new Rectangle(150,125,125,25));
        char2.setBounds(new Rectangle(150,175,125,25));
        char3.setBounds(new Rectangle(150,225,125,25));
        
        them1.setBounds(new Rectangle(450,125,125,25));
        them2.setBounds(new Rectangle(450,175,125,25));
        them3.setBounds(new Rectangle(450,225,125,25));
        
        
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        
        Font f1 = new Font("Serif", Font.PLAIN, 20);
     
        if (isTheme1Selected == true)
        {
            
            g.drawImage(defaultBackground, 0, 0, null);
            g.setFont(f1);
            g.setColor(Color.WHITE);
            g.drawString("Choose 1 of 3 Character types:", 50, 100);
            g.drawString("Choose 1 of 3 Themes:", 400, 100);
            
            if (isStudentSelected == true)
            {
               g.drawImage(studentIcon, 300, 100, null);
            }
            else if (isMascotSelected == true)
            {
                g.drawImage(mascotIcon, 300, 125, null);
            }
            else if (isProfessorSelected == true)
            {
                g.drawImage(professorIcon, 300, 125, null);
                
            }
        }
        
        else if (isTheme2Selected == true)
        {
            g.drawImage(computersBackground, 0, 0, null);
            g.setFont(f1);
            g.setColor(Color.WHITE);
            g.drawString("Choose 1 of 3 Character types:", 50, 100);
            g.drawString("Choose 1 of 3 Themes:", 400, 100);
            
            if (isStudentSelected == true)
            {
               g.drawImage(studentIcon, 300, 100, null);
            }
            else if (isMascotSelected == true)
            {
                g.drawImage(mascotIcon, 300, 125, null);
            }
            else if (isProfessorSelected == true)
            {
                g.drawImage(professorIcon, 300, 125, null);
                
            }
        }
        else if (isTheme3Selected == true)
        {
            g.drawImage(sportsBackground, 0, 0, null);
            g.setFont(f1);
            g.setColor(Color.WHITE);
            g.drawString("Choose 1 of 3 Character types:", 50, 100);
            g.drawString("Choose 1 of 3 Themes:", 400, 100);
            
            if (isStudentSelected == true)
            {
               g.drawImage(studentIcon, 300, 100, null);
            }
            else if (isMascotSelected == true)
            {
                g.drawImage(mascotIcon, 300, 125, null);
            }
            else if (isProfessorSelected == true)
            {
                g.drawImage(professorIcon, 300, 125, null);
                
            }
        }
        else
        {
            g.drawImage(defaultBackground, 0, 0, null);
            g.setFont(f1);
            g.setColor(Color.WHITE);
            g.drawString("Choose 1 of 3 Character types:", 50, 100);
            g.drawString("Choose 1 of 3 Themes:", 400, 100);
            
            if (isStudentSelected == true)
            {
               g.drawImage(studentIcon, 300, 100, null);
            }
            else if (isMascotSelected == true)
            {
                g.drawImage(mascotIcon, 300, 125, null);
            }
            else if (isProfessorSelected == true)
            {
                g.drawImage(professorIcon, 300, 125, null);
                
            }
        }
        validate();
        repaint();

    }
}
