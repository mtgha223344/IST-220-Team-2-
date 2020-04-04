package CampusGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainMap extends JPanel implements ActionListener {
    //TODO, Create Independent Displays for Timer and Score
    //TODO, Create Graphics for MainMap
    //TODO, Catch Scores in MainMap
    //TODO, Create basic GameOver
    //TODO, Implement Character Functionality
    
    Game1 gm1;
    Game2 gm2;
    Game3 gm3;
    JButton mapReturn, game1, game2, game3, gameOver, testbutton;
    private Character character;
    private Timer timer;
    private int DELAY = 10;
    int timerDisplay = 0;
    int timerDisplaySeconds = 0;
    int timerDisplayMinutes = 0;
    int timerDisplayHours = 0;
    String timerDisplayToStringSeconds;
    String timerDisplayToStringMinutes;
    String timerDisplayToStringHours;
    boolean isGameStarted = false;
    String StopWatch;

    public MainMap() {
        super();
        SetUpForMainMap();
    }

    public void SetUpForMainMap() {
        setBackground(Color.white);
        setLayout(null);

        mapReturn = new JButton("Return to Main Menu");     //button to return to IntroScreen

        testbutton = new JButton("Test");

        game1 = new JButton("Proceed to Game 1?");
        game2 = new JButton("Game 2");
        game3 = new JButton("Game 3");
        gameOver = new JButton("Game Over");

        add(mapReturn);
        add(game1);
        add(game2);
        add(game3);
        add(gameOver);

        mapReturn.setBounds(new Rectangle(450, 375, 150, 35));
        testbutton.setBounds(new Rectangle(450, 5, 150, 50));
        game1.setBounds(new Rectangle(200, 300, 150, 50));
        game1.setVisible(false);
        game2.setBounds(new Rectangle(450, 125, 150, 50));
        game3.setBounds(new Rectangle(450, 200, 150, 50));
        gameOver.setBounds(new Rectangle(450, 275, 150, 50));

        addKeyListener(new TAdapter());
        setFocusable(true);

        character = new Character();

    }

    public void startTimer() {
        timer = new Timer(DELAY, this);
        timer.start();
        isGameStarted = true;
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

        g2d.drawImage(character.getImage(), character.getX(),
                character.getY(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        step();
        timerDisplay++;
        UpdateTimerDisplay();
        
    }
    
    private void UpdateTimerDisplay(){
        
        timerDisplaySeconds = timerDisplay / 100;
        if (timerDisplaySeconds >= 60)
        {
        timerDisplayMinutes ++;
        timerDisplay = 0;
        }
        
        if (timerDisplayMinutes >= 60)
        {
        timerDisplayHours ++;
        timerDisplayMinutes = timerDisplayMinutes - 60;
        }
        timerDisplayToStringSeconds = Integer.toString(timerDisplaySeconds);
        timerDisplayToStringMinutes = Integer.toString(timerDisplayMinutes);
        timerDisplayToStringHours = Integer.toString(timerDisplayHours);
        mapReturn.setText(timerDisplayToStringHours + ":" + timerDisplayMinutes + ":" + timerDisplayToStringSeconds);
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

        Rectangle r2 = testbutton.getBounds();

        if (r3.intersects(r2)) {
            game1.setVisible(true);
        } else {
            game1.setVisible(false);
        }
    }

}
