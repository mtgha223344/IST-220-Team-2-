/*
*MainFrame for the game, sets up the frame and basic UI 
 */
package CampusGame;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    ControlPanel mjp;
    
    public MainFrame()
    {
        super("IST 220 Team 2 - Campus Game");
        setupUIManager();
        mjp = new ControlPanel();
        add(mjp);                                       //add the control panel to the Main Frame. All other panels will be added to the ControlPanel
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
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
