
package CampusGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;


public class IntroScreen extends JPanel{
    
    JButton b1, b2, b3, b4;
    private Image background;

    public IntroScreen()
    {
        super();
        InitialSetUpForIntroScreen();
    }

    public void InitialSetUpForIntroScreen()
    {

        //This will need to have all of the navigation buttons added and graphically formatted
        //The listeners should be implemented in the ControlPanel
        setBackground(Color.blue);
        setLayout(null);
        
        background = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/IntroScreenBackground.JPG"));
        
        b1 = new JButton("Credits/About");          //Buttons to direct user to the different panels for the game
        b2 = new JButton("Instructions");
        b3 = new JButton("Options");
        b4 = new JButton("Begin Game");
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        
        b1.setBounds(new Rectangle (550,75,150,25));        //sets layout of buttons
        b2.setBounds(new Rectangle (550,150,150,25));
        b3.setBounds(new Rectangle (550,225,150,25));
        b4.setBounds(new Rectangle (550,300,150,25));
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        Font f1 = new Font("Serif", Font.BOLD, 20);
        g.setFont(f1);
        g.setColor(Color.white);
        g.drawString("Welcome to Group 2's IST 240 Game!", 25, 90);
        g.drawString("Main Menu", 25, 125);
    }

    
}
