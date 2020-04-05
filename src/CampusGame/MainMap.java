package CampusGame;

import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Image;

public class MainMap extends JPanel implements ActionListener {
    //TODO, Create Independent Displays for Timer and Score
    //TODO, Create Graphics for MainMap
    //TODO, Catch Scores in MainMap
    //TODO, Create basic GameOver
    //TODO, Implement Character Functionality

    Game1 gm1;
    Game2 gm2;
    Game3 gm3;
    protected JButton mapReturn, game1, game2, game3, gameOver, universityParkIcon, worldCampusIcon, abingtonIcon, scrantonIcon, duBoisIcon, timerDisplayField, scoreDisplayField;
    private Character character;
    private Timer timer;
    private int timerDisplay = 0, timerDisplaySeconds = 0, timerDisplayMinutes = 0, timerDisplayHours = 0,DELAY = 10;
    boolean isGameStarted = false;
    private String timerDisplayToStringSeconds, timerDisplayToStringMinutes, timerDisplayToStringHours;
    private ImageIcon scranton, universityPark, worldCampus, abington, duBois; 
    private Image background;

    public MainMap() {
        super();
        SetUpForMainMap();
    }

    public void SetUpForMainMap() {

        setLayout(null);

        //Pulls the images for the campus icons from the Project Sources
        universityPark = new ImageIcon(getClass().getResource("/resources/UniversityPark.JPG"));
        worldCampus = new ImageIcon(getClass().getResource("/resources/WorldCampus.JPG"));
        abington = new ImageIcon(getClass().getResource("/resources/Abington.JPG"));
        duBois = new ImageIcon(getClass().getResource("/resources/DuBois.JPG"));
        scranton = new ImageIcon(getClass().getResource("/resources/Scranton.JPG"));

        //Paints the Background
        background = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/Background.JPG"));

        //Creates all of the buttons and assigns Icons to them
        universityParkIcon = new JButton(universityPark);
        worldCampusIcon = new JButton(worldCampus);
        abingtonIcon = new JButton(abington);
        duBoisIcon = new JButton(duBois);
        scrantonIcon = new JButton(scranton);
        mapReturn = new JButton("Return to Main Menu");     //button to return to IntroScreen
        game1 = new JButton("Proceed to Game 1?");
        game2 = new JButton("Game 2");
        game3 = new JButton("Game 3");
        gameOver = new JButton("Game Over");
        timerDisplayField = new JButton();
        scoreDisplayField = new JButton();

        //adds the buttons to the frame
        add(mapReturn);
        add(universityParkIcon);
        add(worldCampusIcon);
        add(abingtonIcon);
        add(duBoisIcon);
        add(scrantonIcon);
        add(game1);
        add(game2);
        add(game3);
        add(gameOver);
        add(timerDisplayField);
        add(scoreDisplayField);

        //Placing the icons in the main map
        mapReturn.setBounds(new Rectangle(450, 525, 150, 35));
        universityParkIcon.setBounds(new Rectangle(334, 250, 50, 50));
        worldCampusIcon.setBounds(new Rectangle(300, 80, 125, 50));
        abingtonIcon.setBounds(new Rectangle(720, 388, 50, 50));
        duBoisIcon.setBounds(new Rectangle(222, 190, 50, 50));
        scrantonIcon.setBounds(new Rectangle(640, 150, 50, 50));
        game1.setBounds(new Rectangle(600, 50, 150, 50));
        game1.setBackground(Color.RED);
        game1.setVisible(false);
        game2.setBounds(new Rectangle(600, 50, 150, 50));
        game2.setBackground(Color.RED);
        game2.setVisible(false);
        game3.setBounds(new Rectangle(600, 50, 150, 50));
        game3.setVisible(false);
        gameOver.setBounds(new Rectangle(450, 275, 150, 50));
        gameOver.setVisible(false);
        timerDisplayField.setBounds(new Rectangle(0, 525, 110, 40));
        scoreDisplayField.setBounds(new Rectangle(110, 525, 110, 40));

        //adds KeyListener to be eventually delegated to the character class
        addKeyListener(new TAdapter());
        setFocusable(true);

        character = new Character();

    }

    public void startTimer() {
        timer = new Timer(DELAY, this);
        timer.start();
        isGameStarted = true; // verifies that the game is started
    }
    
    //used for the game over functionality
    public void stopTimer() {
        timer.stop();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
        requestFocusInWindow();

        Font f1 = new Font("Serif", Font.BOLD, 20);
        g.setFont(f1);
        g.setColor(Color.BLUE);
        g.drawString("Main Map", 50, 100);
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g.drawImage(background, 0, 0, null);

        g2d.drawImage(character.getImage(), character.getX(),
                character.getY(), this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        step();
        timerDisplay++;
        UpdateTimerDisplay();

    }

    private void UpdateTimerDisplay() {

        timerDisplaySeconds = timerDisplay / 100;
        if (timerDisplaySeconds >= 60) {
            timerDisplayMinutes++;
            timerDisplay = 0;
        }

        if (timerDisplayMinutes >= 60) {
            timerDisplayHours++;
            timerDisplayMinutes = timerDisplayMinutes - 60;
        }
        timerDisplayToStringSeconds = Integer.toString(timerDisplaySeconds);
        timerDisplayToStringMinutes = Integer.toString(timerDisplayMinutes);
        timerDisplayToStringHours = Integer.toString(timerDisplayHours);
        timerDisplayField.setText("Time: " + timerDisplayToStringHours + ":" + timerDisplayMinutes + ":" + timerDisplayToStringSeconds);
    }

    private void step() {

        character.move();
        checkCollisions();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            character.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            character.keyPressed(e);
        }
    }

    public void checkCollisions() {

        Rectangle r3 = character.getBounds();

        Rectangle r2 = universityParkIcon.getBounds();
        Rectangle r4 = worldCampusIcon.getBounds();

        if (r3.intersects(r2)) {
            game1.setVisible(true);
        } else if (r3.intersects(r4))
        {
            game2.setVisible(true);
        }
        else
        {
            game1.setVisible(false);
            game2.setVisible(false);
        }
    }

}
