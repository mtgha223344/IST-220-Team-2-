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
    GameOver gameOver;
    JButton goTo1, goTo2;
    int gameScore, gamesPlayed = 0; //This is the overall game score.
    String gameScoreToString; //Used for printing the Game Score to the Display in the Main Map

    public ControlPanel() {
        super();
        SetUpForControlPanel();
        CreateComponentsThatWillBeSwapped();
    }

    public void SetUpForControlPanel() {
        //The listeners for the navigation will need to be implemented here
        BorderLayout border = new BorderLayout();
        setLayout(border);
        setBackground(Color.gray);
        SetUpIntroScreen();
    }

    public void SetUpIntroScreen() {
        intro = new IntroScreen();

        add(intro, "Center");
        intro.b1.addActionListener(this);       //adds the action listener to each of the 4 buttons in the IntroScreen
        intro.b2.addActionListener(this);
        intro.b3.addActionListener(this);
        intro.b4.addActionListener(this);

    }

    public void CreateGame1() {
        gm1 = new Game1();                //creates game1
        add(gm1);
        gm1.returnToMainMap.addActionListener(this);

    }

    public void CreateGame2() {
        gm2 = new Game2();                //creates game2
        add(gm2);
        gm2.b1.addActionListener(this);
    }

    public void CreateGame3() {
        gm3 = new Game3();                //creates game2
        add(gm3);
        gm3.b1.addActionListener(this);
    }

    public void GameOver() {

        mm.stopTimer();
    }

    public void CreateComponentsThatWillBeSwapped() {
        
        ca = new CreditsAndAbout();             //creates the CreditsAndAbout panel    
        ca.credReturn.addActionListener(this);  //attach listener to the Return button in the CreditsAndAbout panel
        
        in = new Instructions();                //creates the Instructions panel
        in.inReturn.addActionListener(this);    //attach listener to the Return button in the Instructions panel
        
        opt = new Options();                    //creates the Options panel
        opt.optReturn.addActionListener(this);  //attach listener to the Return button in the Options panel
        opt.studentButton.addActionListener(this);
        opt.professorButton.addActionListener(this);
        opt.nittanyLionButton.addActionListener(this);
        opt.them1.addActionListener(this);
        opt.them2.addActionListener(this);
        opt.them3.addActionListener(this);
        
        mm = new MainMap();
        mm.mapReturn.addActionListener(this);   //attach listener to the Return button in the MainMap panel  
        mm.game1.addActionListener(this);
        mm.game2.addActionListener(this);
        mm.game3.addActionListener(this);
        
        gm1 = new Game1();
        gm1.returnToMainMap.addActionListener(this);         //attach listener to the Game1 button in the Game1 panel
        
        gm2 = new Game2();
        gm2.b1.addActionListener(this);         //attach listener to the Game2 button in the Game2 panel
        
        gm3 = new Game3();
        gm3.b1.addActionListener(this);         //attach listener to the Game3 button in the Game3 panel
        
        gameOver = new GameOver();
        gameOver.restart.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Object obj = e.getSource();

        if (mm.gamesPlayed == 3) //test Game Over Functionality here. Eventually should respond to actual game over event. 
        {

            //Here there is no Action Event object so the Control Panel continually queries for the game over condition
            //Will probably respond to a variable numberOfGamesPlayed which will iterate each time a game button is clicked
            GameOver();
            removeAll();
            add(gameOver);
            validate();
            repaint();
        }
        if (obj == intro.b1) //adds the CreditsAndAbout panel
        {
            remove(intro);
            add(ca);
            validate();
            repaint();
        }
        if (obj == intro.b2) //adds the Instructions panel
        {
            remove(intro);
            add(in);
            validate();
            repaint();
        }
        if (obj == intro.b3) //adds the Options panel
        {
            remove(intro);
            add(opt);
            validate();
            repaint();
        }
        if (obj == intro.b4) //adds the MainMap panel
        {
            remove(intro);
            add(mm);
            if (mm.isGameStarted == false) {
                mm.startTimer();
            }
            validate();
            repaint();
        }
        if (obj == ca.credReturn) {
            remove(ca);
            add(intro);
            validate();
            repaint();
        }
        if (obj == in.inReturn) {
            remove(in);
            add(intro);
            validate();
            repaint();
        }
        if (obj == opt.optReturn) {
            remove(opt);
            add(intro);
            validate();
            repaint();
        }
        if (obj == opt.studentButton) {
            opt.isStudentSelected = true;
            opt.isMascotSelected = false;
            opt.isProfessorSelected = false;
            mm.isStudentSelected = true;
            validate();
            repaint();
            
        }
        if (obj == opt.professorButton) {
            
            opt.isProfessorSelected = true;
            opt.isStudentSelected = false;
            opt.isMascotSelected = false; 
            mm.isProfessorSelected = true;
            validate();
            repaint();
            
        }
        if (obj == opt.nittanyLionButton) {
            opt.isMascotSelected = true;
            opt.isProfessorSelected = false;
            opt.isStudentSelected = false;
            mm.isNittanyLionSelected = true;
            validate();
            repaint();
            
        }
        if (obj == opt.them1) {
            opt.isTheme1Selected = true;
            opt.isTheme2Selected = false;
            opt.isTheme3Selected = false;
            validate();
            repaint();
            
        }
        if (obj == opt.them2) {
            opt.isTheme2Selected = true;
            opt.isTheme1Selected = false;
            opt.isTheme3Selected = false;
            
            validate();
            repaint();   
        }
        if (obj == opt.them3) {
            opt.isTheme3Selected = true;
            opt.isTheme2Selected = false;
            opt.isTheme1Selected = false;
            
            validate();
            repaint();   
        }
        if (obj == mm.mapReturn) {
            remove(mm);
            add(intro);
            validate();
            repaint();
        }
        if (obj == mm.game1) //adds the Game1 panel when Game1 button is pressed in the MainMap panel
        {
            mm.setVisible(false);
            CreateGame1();
            mm.hasGame1BeenPlayed = true;
            mm.gamesPlayed++;
            validate();
            repaint();
        }
        if (obj == mm.game2) //adds the Game2 panel when Game1 button is pressed in the MainMap panel
        {
            mm.setVisible(false);
            CreateGame2();
            mm.hasGame2BeenPlayed = true;
            mm.gamesPlayed++;
            validate();
            repaint();
        }
        if (obj == mm.game3) //adds the Game3 panel when Game1 button is pressed in the MainMap panel
        {
            mm.setVisible(false);
            CreateGame3();
            mm.hasGame3BeenPlayed = true;
            mm.gamesPlayed++;
            validate();
            repaint();
        }
        //This will navigate back to the IntroScreen. Needs to navigate back to MainMap
        if (obj == gm1.returnToMainMap) {
            gm1.setVisible(false);
            gameScore = gameScore + gm1.score;
            gameScoreToString = Integer.toString(gameScore);
            mm.scoreDisplayField.setText("Score: " + gameScoreToString);
            mm.setVisible(true); //rebuild the original ControlPanel again
            validate();
            repaint();
        }

        if (obj == gm2.b1) {
            gm2.setVisible(false);
            gameScore = gameScore + gm2.score;
            gameScoreToString = Integer.toString(gameScore);
            mm.scoreDisplayField.setText("Score: " + gameScoreToString);
            mm.setVisible(true); //rebuild the original ControlPanel again
            validate();
            repaint();
        }
        if (obj == gm3.b1) {
            gm3.setVisible(false);
            gameScore = gameScore + gm3.score;
            gameScoreToString = Integer.toString(gameScore);
            mm.scoreDisplayField.setText("Score: " + gameScoreToString);
            mm.setVisible(true);//rebuild the original ControlPanel again
            validate();
            repaint();
        }

        if (obj == gameOver.restart) {
            removeAll();
            SetUpForControlPanel();
            CreateComponentsThatWillBeSwapped();
            validate();
            repaint();
        }

    }

}
