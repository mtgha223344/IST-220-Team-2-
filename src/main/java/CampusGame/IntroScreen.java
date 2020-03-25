
package CampusGame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;


public class IntroScreen extends JPanel{
    
    
    Instructions instructionsPanel;
    Options optionsPanel;
    MainMap mainMapPanel;
    CreditsAndAbout creditsAndAboutPanel;
    JButton b1, b2;

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
        b1 = new JButton("Button");
        b2 = new JButton("Button");
        add(b1);
        add(b2);
    }

    
}
