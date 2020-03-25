/*
*MainFrame for the game, sets up the frame and basic UI 
 */
package CampusGame;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
 
    
    ControlPanel mjp;
    IntroScreen introScreen;
    
    public MainFrame()
    {
        super("IST 220 Team 2 - Campus Game");
        setupUIManager();
        introScreen = new IntroScreen();
        add(introScreen);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
    }

    private void setupUIManager()
    {  
        try
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        //------------------------------------------------------
    }
}
