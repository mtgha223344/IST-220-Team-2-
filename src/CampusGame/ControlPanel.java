/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CampusGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 **The Control Panel will listen to events and based on those events, it will
 * add and remove the necessary panels.
 */
public class ControlPanel extends JPanel implements ActionListener {

    CreditsAndAbout ca;
    Instructions in;
    Options opt;
    MainMap mm;
    IntroScreen intro;
    Game1 gm1;
    Game2 gm2;
    Game3 gm3;
    JButton goTo1, goTo2;

    public ControlPanel()
    {
        super();
        SetUpForControlPanel();
        CreateComponentsThatWillBeSwapped();
    }

    public void SetUpForControlPanel()
    {
        //The listeners for the navigation will need to be implemented here
        BorderLayout border = new BorderLayout();
        setLayout(border);
        setBackground(Color.gray);
        intro = new IntroScreen();
        add(intro, "Center");
        intro.b1.addActionListener(this);       //adds the action listener to each of the 4 buttons in the IntroScreen
        intro.b2.addActionListener(this);
        intro.b3.addActionListener(this);
        intro.b4.addActionListener(this);
    }

    public void BackToMainMap()
    {
        BorderLayout border = new BorderLayout();
        setLayout(border);
        setBackground(Color.gray);
        mm = new MainMap();
        add(mm);
        mm.game1.addActionListener(this);
        mm.game2.addActionListener(this);
        mm.game3.addActionListener(this);
        mm.mapReturn.addActionListener(this);
    }

    public void CreateComponentsThatWillBeSwapped()
    {
        ca = new CreditsAndAbout();             //creates the CreditsAndAbout panel    
        ca.credReturn.addActionListener(this);  //attach listener to the Return button in the CreditsAndAbout panel
        in = new Instructions();                //creates the Instructions panel
        in.inReturn.addActionListener(this);    //attach listener to the Return button in the Instructions panel
        opt = new Options();                    //creates the Options panel
        opt.optReturn.addActionListener(this);  //attach listener to the Return button in the Options panel
        mm = new MainMap();
        mm.mapReturn.addActionListener(this);   //attach listener to the Return button in the MainMap panel  
        mm.game1.addActionListener(this);
        mm.game2.addActionListener(this);
        mm.game3.addActionListener(this);
        gm1 = new Game1();
        gm1.b1.addActionListener(this);         //attach listener to the Game1 button in the Game1 panel
        gm2 = new Game2();
        gm2.b1.addActionListener(this);         //attach listener to the Game2 button in the Game2 panel
        gm3 = new Game3();
        gm3.b1.addActionListener(this);         //attach listener to the Game3 button in the Game3 panel
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Object obj = e.getSource();
        if (obj == intro.b1)    //adds the CreditsAndAbout panel
        {
            removeAll();
            add(ca);
            validate();
            repaint();
        }
        if (obj == intro.b2)    //adds the Instructions panel
        {
            removeAll();
            add(in);
            validate();
            repaint();
        }
        if (obj == intro.b3)    //adds the Options panel
        {
            removeAll();
            add(opt);
            validate();
            repaint();
        }
        if (obj == intro.b4)    //adds the MainMap panel
        {
            removeAll();
            add(mm);
            validate();
            repaint();
        }
        if (obj == ca.credReturn)
        {
            removeAll();
            SetUpForControlPanel(); //rebuild the IntroScreen again
            validate();
            repaint();
        }
        if (obj == in.inReturn)
        {
            removeAll();
            SetUpForControlPanel(); //rebuild the IntroScreen again
            validate();
            repaint();
        }
        if (obj == opt.optReturn)
        {
            removeAll();
            SetUpForControlPanel(); //rebuild the original IntroScreen again
            validate();
            repaint();
        }
        if (obj == mm.mapReturn)
        {
            removeAll();
            SetUpForControlPanel(); //rebuild the original IntroScreen again
            validate();
            repaint();
        }
        if (obj == mm.game1)    //adds the Game1 panel when Game1 button is pressed in the MainMap panel
        {
            removeAll();
            add(gm1);
            validate();
            repaint();
        }
        if (obj == mm.game2)    //adds the Game2 panel when Game1 button is pressed in the MainMap panel
        {
            removeAll();
            add(gm2);
            validate();
            repaint();
        }
        if (obj == mm.game3)    //adds the Game3 panel when Game1 button is pressed in the MainMap panel
        {
            removeAll();
            add(gm3);
            validate();
            repaint();
        }
        //This will navigate back to the IntroScreen. Needs to navigate back to MainMap
        if (obj == gm1.b1)
        {
            removeAll();
            BackToMainMap(); //rebuild the original ControlPanel again
            validate();
            repaint();
        }
        if (obj == gm2.b1)
        {
            removeAll();
            BackToMainMap(); //rebuild the original ControlPanel again
            validate();
            repaint();
        }
        if (obj == gm3.b1)
        {
            removeAll();
            BackToMainMap(); //rebuild the original ControlPanel again
            validate();
            repaint();
        }
    }

}
