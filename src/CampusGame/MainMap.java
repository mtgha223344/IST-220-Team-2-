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
    //TODO, add collisions for all buttons for all characters
    //make sure tracking score
    //edit default character scenario

    Game1 gm1;
    Game2 gm2;
    Game3 gm3;
    protected JButton mapReturn, universityParkButton, worldCampusButton, scrantonButton, duBoisButton, abingtonButton, gameOver, universityParkIcon, worldCampusIcon, abingtonIcon, scrantonIcon, duBoisIcon, timerDisplayField, scoreDisplayField;
    private Character character;
    private Student student;
    private NittanyLion nitannyLion;
    private Professor professor;
    private Timer timer;
    private int timerDisplay = 0, timerDisplaySeconds = 0, timerDisplayMinutes = 0, timerDisplayHours = 0, DELAY = 10;
    boolean isTheme2Selected = false, isGameStarted = false, isStudentSelected = false, isProfessorSelected = false, isNittanyLionSelected = false, hasUniversityParkBeenPlayed = false, hasWorldCampusBeenPlayed = false, hasScrantonBeenPlayed = false;
    boolean hasduBoisBeenPlayed = false, hasAbingtonBeenPlayed = false;
    protected String timerDisplayToStringSeconds, timerDisplayToStringMinutes, timerDisplayToStringHours;
    private ImageIcon scranton, universityPark, worldCampus, abington, duBois;
    private Image background, testBackground;
    protected int gamesPlayed = 0;

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

        //creates the background to be painted
        background = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/Background.JPG"));
        testBackground = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/testBackground.JPG"));

        //Creates all of the buttons and assigns Icons to them
        universityParkIcon = new JButton(universityPark);
        worldCampusIcon = new JButton(worldCampus);
        abingtonIcon = new JButton(abington);
        duBoisIcon = new JButton(duBois);
        scrantonIcon = new JButton(scranton);
        mapReturn = new JButton("Return to Main Menu");     //button to return to IntroScreen
        universityParkButton = new JButton("Proceed to Game?");
        worldCampusButton = new JButton("Proceed to Game?");
        scrantonButton = new JButton("Proceed to Game?");
        duBoisButton = new JButton("Proceed to Game?");
        abingtonButton = new JButton("Proceed to Game?");
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
        add(universityParkButton);
        add(worldCampusButton);
        add(scrantonButton);
        add(duBoisButton);
        add(abingtonButton);
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

        universityParkButton.setBounds(new Rectangle(600, 50, 150, 50));
        universityParkButton.setBackground(Color.RED);
        universityParkButton.setVisible(false);
        worldCampusButton.setBounds(new Rectangle(600, 50, 150, 50));
        worldCampusButton.setBackground(Color.RED);
        worldCampusButton.setVisible(false);
        scrantonButton.setBounds(new Rectangle(600, 50, 150, 50));
        scrantonButton.setVisible(false);
        scrantonButton.setBackground(Color.RED);

        duBoisButton.setBounds(new Rectangle(600, 50, 150, 50));
        duBoisButton.setVisible(false);
        duBoisButton.setBackground(Color.RED);

        abingtonButton.setBounds(new Rectangle(600, 50, 150, 50));
        abingtonButton.setVisible(false);
        abingtonButton.setBackground(Color.RED);

        gameOver.setBounds(new Rectangle(450, 275, 150, 50));
        gameOver.setVisible(false);
        timerDisplayField.setBounds(new Rectangle(0, 525, 110, 40));
        scoreDisplayField.setBounds(new Rectangle(110, 525, 110, 40));

        //adds KeyListener to be eventually delegated to the character class
        addKeyListener(new TAdapter());
        setFocusable(true);

        SetUpCharacter();
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

    //creates the characters to be drawn depending on the options selected
    public void SetUpCharacter() {
        professor = new Professor();
        student = new Student();
        nitannyLion = new NittanyLion();
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

        if (isStudentSelected == true) {
            g2d.drawImage(student.getImage(), student.getX(),
                    student.getY(), this);
        } else if (isProfessorSelected == true) {
            g2d.drawImage(professor.getImage(), professor.getX(),
                    professor.getY(), this);
        } else if (isNittanyLionSelected == true) {
            g2d.drawImage(nitannyLion.getImage(), nitannyLion.getX(),
                    nitannyLion.getY(), this);
        } else {
            g2d.drawImage(nitannyLion.getImage(), nitannyLion.getX(),
                    nitannyLion.getY(), this);
        }

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

        if (isStudentSelected == true) {
            student.move();
        } else if (isProfessorSelected == true) {
            professor.move();
        } else{
            nitannyLion.move();
        }
        checkCollisions();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

            if (isStudentSelected == true) {
                student.keyReleased(e);
            } else if (isProfessorSelected == true) {
                professor.keyReleased(e);
            } else{
                nitannyLion.keyReleased(e);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (isStudentSelected == true) {
                student.keyPressed(e);
            } else if (isProfessorSelected == true) {
                professor.keyPressed(e);
            } else{
                nitannyLion.keyPressed(e);
            }
        }
    }

    public void checkCollisions() {

        //check collisions for student icon if student is selected
        if (isStudentSelected == true) {
            Rectangle r3 = student.getBounds();

            Rectangle r2 = universityParkIcon.getBounds();
            Rectangle r4 = worldCampusIcon.getBounds();
            Rectangle r5 = scrantonIcon.getBounds();
            Rectangle r6 = duBoisIcon.getBounds();
            Rectangle r7 = abingtonIcon.getBounds();

            if (r3.intersects(r2) && hasUniversityParkBeenPlayed == false) {
                universityParkButton.setVisible(true);
            } else if (r3.intersects(r4) && hasWorldCampusBeenPlayed == false) {
                worldCampusButton.setVisible(true);
            } else if (r3.intersects(r5) && hasScrantonBeenPlayed == false) {
                scrantonButton.setVisible(true);
            } else if (r3.intersects(r6) && hasduBoisBeenPlayed == false) {
                duBoisButton.setVisible(true);
            } else if (r3.intersects(r7) && hasAbingtonBeenPlayed == false) {
                abingtonButton.setVisible(true);
            } else {
                universityParkButton.setVisible(false);
                worldCampusButton.setVisible(false);
                scrantonButton.setVisible(false);
                duBoisButton.setVisible(false);
                abingtonButton.setVisible(false);
            }
        } //check for collisions on professor icon if professor is selected 
        else if (isProfessorSelected == true) {
            Rectangle r3 = professor.getBounds();

            Rectangle r2 = universityParkIcon.getBounds();
            Rectangle r4 = worldCampusIcon.getBounds();
            Rectangle r5 = scrantonIcon.getBounds();
            Rectangle r6 = duBoisIcon.getBounds();
            Rectangle r7 = abingtonIcon.getBounds();

            if (r3.intersects(r2) && hasUniversityParkBeenPlayed == false) {
                universityParkButton.setVisible(true);
            } else if (r3.intersects(r4) && hasWorldCampusBeenPlayed == false) {
                worldCampusButton.setVisible(true);
            } else if (r3.intersects(r5) && hasScrantonBeenPlayed == false) {
                scrantonButton.setVisible(true);
            } else if (r3.intersects(r6) && hasduBoisBeenPlayed == false) {
                duBoisButton.setVisible(true);
            } else if (r3.intersects(r7) && hasAbingtonBeenPlayed == false) {
                abingtonButton.setVisible(true);
            } else {
                universityParkButton.setVisible(false);
                worldCampusButton.setVisible(false);
                scrantonButton.setVisible(false);
                duBoisButton.setVisible(false);
                abingtonButton.setVisible(false);
            }
        } else  {
            Rectangle r3 = nitannyLion.getBounds();

            Rectangle r2 = universityParkIcon.getBounds();
            Rectangle r4 = worldCampusIcon.getBounds();
            Rectangle r5 = scrantonIcon.getBounds();
            Rectangle r6 = duBoisIcon.getBounds();
            Rectangle r7 = abingtonIcon.getBounds();

            if (r3.intersects(r2) && hasUniversityParkBeenPlayed == false) {
                universityParkButton.setVisible(true);
            } else if (r3.intersects(r4) && hasWorldCampusBeenPlayed == false) {
                worldCampusButton.setVisible(true);
            } else if (r3.intersects(r5) && hasScrantonBeenPlayed == false) {
                scrantonButton.setVisible(true);
            } else if (r3.intersects(r6) && hasduBoisBeenPlayed == false) {
                duBoisButton.setVisible(true);
            } else if (r3.intersects(r7) && hasAbingtonBeenPlayed == false) {
                abingtonButton.setVisible(true);
            } else {
                universityParkButton.setVisible(false);
                worldCampusButton.setVisible(false);
                scrantonButton.setVisible(false);
                duBoisButton.setVisible(false);
                abingtonButton.setVisible(false);
            }
        }
    }

}
