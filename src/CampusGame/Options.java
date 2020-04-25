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
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

/**
 *
 * @author user
 */
public class Options extends JPanel{
    
    boolean isStudentSelected = true, isMascotSelected = false, isProfessorSelected = false, isTheme1Selected = false, isTheme2Selected = false, isTheme3Selected = false;
    JButton optReturn, studentButton, professorButton, nittanyLionButton, them1, them2, them3;
    private final Image studentIcon, professorIcon, mascotIcon, defaultBackground, computersBackground, sportsBackground;
    JProgressBar professorMSbar, professorIbar, studentMSbar, studentIbar, mascotMSbar, mascotIbar;
    
    public Options(){
        super();
        setBackground(Color.BLUE);
        setLayout(null);
   
        defaultBackground = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/pennStateBackground.JPG"));
        computersBackground = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/computersBackground.JPG"));
        sportsBackground = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/sportsBackground.JPG"));
        
        studentIcon = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/student.JPG"));
        professorIcon = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/professorIcon.JPG"));
        mascotIcon = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/mascotIcon.JPG"));
        
        optReturn = new JButton("Return to Main Menu");     //button to return to IntroScreen
        studentButton = new JButton("Student");
        professorButton = new JButton("Professor");
        nittanyLionButton = new JButton("Nitanny Lion");
        
        them1= new JButton("Penn State (Default)");
        them2 = new JButton("Computers");
        them3 = new JButton("Sports");
        
        add(optReturn);
        add(studentButton);
        add(professorButton);
        add(nittanyLionButton);
        add(them1);
        add(them2);
        add(them3);
        
        optReturn.setBounds(new Rectangle(620,480,150,35));
        studentButton.setBounds(new Rectangle(150,125,125,25));
        professorButton.setBounds(new Rectangle(150,175,125,25));
        nittanyLionButton.setBounds(new Rectangle(150,225,125,25));
        
        them1.setBounds(new Rectangle(450,125,125,25));
        them2.setBounds(new Rectangle(450,175,125,25));
        them3.setBounds(new Rectangle(450,225,125,25));
        
        //Professor movement speed stat progress bar
        professorMSbar = new JProgressBar(SwingConstants.VERTICAL, -5 , 5);
        professorMSbar.setValue(-2); //Set Value to reflect professor movement speed stat
        professorMSbar.setMinimum(-5); 
        professorMSbar.setString("Movement Speed");
        professorMSbar.setBounds(90, 325,30, 125); 
        professorMSbar.setStringPainted(true);
        
        
        //Professor intelligence stat progress bar
        professorIbar = new JProgressBar(SwingConstants.VERTICAL, -5 , 5);
        professorIbar.setValue(2); //Set Value to reflect professor Intelligence stat
        professorIbar.setMinimum(-5); 
        professorIbar.setString("Intelligence");
        professorIbar.setBounds(120, 325,30, 125); 
        professorIbar.setStringPainted(true);
        
         //Student movement speed stat progress bar
        studentMSbar = new JProgressBar(SwingConstants.VERTICAL, -5 , 5);
        studentMSbar.setValue(2); //Set Value to reflect student movement speed stat
        studentMSbar.setMinimum(-5); 
        studentMSbar.setString("Movement Speed");
        studentMSbar.setBounds(90, 325,30, 125); 
        studentMSbar.setStringPainted(true);
        
        
        //Student intelligence stat progress bar
        studentIbar = new JProgressBar(SwingConstants.VERTICAL, -5 , 5);
        studentIbar.setValue(-2); //Set Value to reflect student Intelligence stat
        studentIbar.setMinimum(-5);
        studentIbar.setString("Intelligence");
        studentIbar.setBounds(120, 325,30, 125);
        studentIbar.setStringPainted(true);
        
         //Mascot movement speed stat progress bar
        mascotMSbar = new JProgressBar(SwingConstants.VERTICAL, -5 , 5);
        mascotMSbar.setValue(0); //Set Value to reflect mascot movement speed stat
        mascotMSbar.setMinimum(-5);
        mascotMSbar.setString("Movement Speed");
        mascotMSbar.setBounds(90, 325,30, 125); 
        mascotMSbar.setStringPainted(true);
        
        
        //Mascot intelligence stat progress bar
        mascotIbar = new JProgressBar(SwingConstants.VERTICAL, -5 , 5);
        mascotIbar.setValue(0); //Set Value to reflect mascot Intelligence stat
        mascotIbar.setMinimum(-5);
        mascotIbar.setString("Intelligence");
        mascotIbar.setBounds(120, 325,30, 125); 
        mascotIbar.setStringPainted(true);
        
        
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        
        Font f1 = new Font("Serif", Font.PLAIN, 20);
        Font f2 = new Font("Serif", Font.PLAIN, 14);
     
        if (isTheme1Selected == true)
        {
            
            g.drawImage(defaultBackground, 0, 0, null);
            g.setFont(f1);
            g.setColor(Color.WHITE);
            g.drawString("Choose 1 of 3 Character types:", 50, 100);
            g.drawString("Choose 1 of 3 Themes:", 400, 100);
            g.drawString("Character Attributes", 50, 310);
            g.setFont(f2);
            g.drawString("-Character attributes provide advantages or disadvantages in some of the mini games.", 50, 475);
            g.drawString("-The Student has higher movement speed but lower intelligence.", 50, 490);
            g.drawString("-The Professor has higher intelligence but lower movement speed.", 50, 505);
            g.drawString("-The Mascot has average movement speed and intelligence; no upside nor downside.", 50, 520);
            g.drawString("-5", 76, 455);
            g.drawString("0", 80, 392);
            g.drawString("5", 80, 333);
            g.drawString("2", 80, 368);
            g.drawString("-2", 76, 416);
            
            if (isStudentSelected == true)
            {
               g.drawImage(studentIcon, 300, 100, null);
               remove(professorIbar);
               remove(professorMSbar);
               remove(mascotIbar);
               remove(mascotMSbar);
               add(studentIbar);
               add(studentMSbar);
            }
            else if (isMascotSelected == true)
            {
                g.drawImage(mascotIcon, 300, 125, null);
                remove(studentIbar);
                remove(studentMSbar);
                remove(professorIbar);
                remove(professorMSbar);
                add(mascotIbar);
                add(mascotMSbar);
            }
            else if (isProfessorSelected == true)
            {
                g.drawImage(professorIcon, 300, 125, null);
                remove(studentIbar);
                remove(studentMSbar);
                remove(mascotIbar);
                remove(mascotMSbar);
                add(professorIbar);
                add(professorMSbar);
                
            }
        }
        
        else if (isTheme2Selected == true)
        {
            g.drawImage(computersBackground, 0, 0, null);
            g.setFont(f1);
            g.setColor(Color.WHITE);
            g.drawString("Choose 1 of 3 Character types:", 50, 100);
            g.drawString("Choose 1 of 3 Themes:", 400, 100);
            g.drawString("Character Attributes", 50, 310);
            g.setFont(f2);
            g.drawString("-Character attributes provide advantages or disadvantages in some of the mini games.", 50, 475);
            g.drawString("-The Student has higher movement speed but lower intelligence.", 50, 490);
            g.drawString("-The Professor has higher intelligence but lower movement speed.", 50, 505);
            g.drawString("-The Mascot has average movement speed and intelligence; no upside nor downside.", 50, 520);
            g.drawString("-5", 76, 455);
            g.drawString("0", 80, 392);
            g.drawString("5", 80, 333);
            g.drawString("2", 80, 368);
            g.drawString("-2", 76, 416);
            
            if (isStudentSelected == true)
            {
               g.drawImage(studentIcon, 300, 100, null);
               remove(professorIbar);
               remove(professorMSbar);
               remove(mascotIbar);
               remove(mascotMSbar);
               add(studentIbar);
               add(studentMSbar);
            }
            else if (isMascotSelected == true)
            {
                g.drawImage(mascotIcon, 300, 125, null);
                remove(studentIbar);
                remove(studentMSbar);
                remove(professorIbar);
                remove(professorMSbar);
                add(mascotIbar);
                add(mascotMSbar);
            }
            else if (isProfessorSelected == true)
            {
                g.drawImage(professorIcon, 300, 125, null);
                remove(studentIbar);
                remove(studentMSbar);
                remove(mascotIbar);
                remove(mascotMSbar);
                add(professorIbar);
                add(professorMSbar);
                
            }
        }
        else if (isTheme3Selected == true)
        {
            g.drawImage(sportsBackground, 0, 0, null);
            g.setFont(f1);
            g.setColor(Color.WHITE);
            g.drawString("Choose 1 of 3 Character types:", 50, 100);
            g.drawString("Choose 1 of 3 Themes:", 400, 100);
            g.drawString("Character Attributes", 50, 310);
            g.setFont(f2);
            g.drawString("-Character attributes provide advantages or disadvantages in some of the mini games.", 50, 475);
            g.drawString("-The Student has higher movement speed but lower intelligence.", 50, 490);
            g.drawString("-The Professor has higher intelligence but lower movement speed.", 50, 505);
            g.drawString("-The Mascot has average movement speed and intelligence; no upside nor downside.", 50, 520);
            g.drawString("-5", 76, 455);
            g.drawString("0", 80, 392);
            g.drawString("5", 80, 333);
            g.drawString("2", 80, 368);
            g.drawString("-2", 76, 416);
            
            if (isStudentSelected == true)
            {
               g.drawImage(studentIcon, 300, 100, null);
               remove(professorIbar);
               remove(professorMSbar);
               remove(mascotIbar);
               remove(mascotMSbar);
               add(studentIbar);
               add(studentMSbar);
            }
            else if (isMascotSelected == true)
            {
                g.drawImage(mascotIcon, 300, 125, null);
                remove(studentIbar);
                remove(studentMSbar);
                remove(professorIbar);
                remove(professorMSbar);
                add(mascotIbar);
                add(mascotMSbar);
            }
            else if (isProfessorSelected == true)
            {
                g.drawImage(professorIcon, 300, 125, null);
                remove(studentIbar);
                remove(studentMSbar);
                remove(mascotIbar);
                remove(mascotMSbar);
                add(professorIbar);
                add(professorMSbar);
                
            }
        }
        else
        {
            g.drawImage(defaultBackground, 0, 0, null);
            g.setFont(f1);
            g.setColor(Color.WHITE);
            g.drawString("Choose 1 of 3 Character types:", 50, 100);
            g.drawString("Choose 1 of 3 Themes:", 400, 100);
            g.drawString("Character Attributes", 50, 310);
            g.setFont(f2);
            g.drawString("-Character attributes provide advantages or disadvantages in some of the mini games.", 50, 475);
            g.drawString("-The Student has higher movement speed but lower intelligence.", 50, 490);
            g.drawString("-The Professor has higher intelligence but lower movement speed.", 50, 505);
            g.drawString("-The Mascot has average movement speed and intelligence; no upside nor downside.", 50, 520);
            g.drawString("-5", 76, 455);
            g.drawString("0", 80, 392);
            g.drawString("5", 80, 333);
            g.drawString("2", 80, 368);
            g.drawString("-2", 76, 416);
            add(mascotIbar);
            add(mascotMSbar);
            
            if (isStudentSelected == true)
            {
               g.drawImage(studentIcon, 300, 100, null);
               remove(professorIbar);
               remove(professorMSbar);
               remove(mascotIbar);
               remove(mascotMSbar);
               add(studentIbar);
               add(studentMSbar);
            }
            else if (isMascotSelected == true)
            {
                g.drawImage(mascotIcon, 300, 125, null);
                remove(studentIbar);
                remove(studentMSbar);
                remove(professorIbar);
                remove(professorMSbar);
                add(mascotIbar);
                add(mascotMSbar);
            }
            else if (isProfessorSelected == true)
            {
                g.drawImage(professorIcon, 300, 125, null);
                remove(studentIbar);
                remove(studentMSbar);
                remove(mascotIbar);
                remove(mascotMSbar);
                add(professorIbar);
                add(professorMSbar);
                
            }
        }
        validate();
        repaint();

    }
}
