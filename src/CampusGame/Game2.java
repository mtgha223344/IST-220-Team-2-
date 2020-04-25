package CampusGame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Game2 extends JPanel implements ActionListener {
    JButton b0, b00, b1, b2, b3, b4, b5, b6, b7;
    JRadioButton b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22;
    int score;
    boolean Sclicked, Pclicked, Vclicked, Iclicked, Bclicked, scoreChecked = false;
    private final Image sBackground, paBackground, vgBackground, startBackground, student, professor, mascot;
    ImageIcon jbRockTexture, jbVgTexture, jbPaTexture, jbsTexture;
    JLabel title;
    Options option;
    XML_240 x2;
    public Game2()
    {
        super();
        //Frame Layout and Background
        setLayout(null);
        
        //Creates JButton textures
        jbRockTexture = new ImageIcon(getClass().getResource("/resources/Game2JBTexture.jpg"));
        jbVgTexture = new ImageIcon(getClass().getResource("/resources/Game2VideoGameIcon.jpg"));
        jbPaTexture = new ImageIcon(getClass().getResource("/resources/Game2PAIcon.jpg"));
        jbsTexture = new ImageIcon(getClass().getResource("/resources/Game2Ball.png"));
        
        //creates the starting background and the backgrounds to be painted for each different game theme
        startBackground = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/QuizBackground.jpg"));
        sBackground = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/Game2ThemeSports.jpg"));
        paBackground = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/Game2ThemePA.jpg"));
        vgBackground = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/Game2ThemeGames.jpg"));
        student = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/Student.JPG"));
        professor = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/professorIcon.JPG"));
        mascot = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/mascotIcon.JPG"));
        
        //Create (White and black) Color to make some JButtons easier to see and create nicer looking fonts
        Color white = new Color(240,240,240);
        Color black = new Color(0,0,0);
        Color blue = new Color(0,255,255);
        Font f1 = new Font("Bookman", Font.BOLD, 16);
        Font f2 = new Font("Bookman", Font.BOLD, 12);
        option = new Options();
        
        //Create JLabel with a GIF on it to be used at the top of the starting screen
        java.net.URL url = this.getClass().getResource("/resources/TriviaGIF.gif");
        Icon GIF = new ImageIcon(url);
        title = new JLabel(GIF);
        title.setBounds(225, 0, 275, 80);
        title.setFocusable(false);
        
        //JButton 0 (Theme header)
        b0 = new JButton("Please select a theme below!");
        b0.setFont(f1);
        b0.setForeground(white);
        b0.setBorderPainted(false);
        b0.setContentAreaFilled(false);
        b0.setBounds(175,100, 370, 40);
        b0.setFocusable(false);
        
        //JButton 00 (Back Button for in instructions option)
        b00 = new JButton("Back", jbRockTexture);
        b00.setFont(f1);
        b00.setHorizontalTextPosition(JButton.CENTER);
        b00.setVerticalTextPosition(JButton.CENTER);
        b00.setBounds(635,521, 150, 40);
        b00.addActionListener(this);
        
        //JButton 1 (Quit)
        b1 = new JButton("Quit", jbRockTexture);
        b1.setBounds(10,350, 150, 40);
        b1.setFont(f1);
        b1.setHorizontalTextPosition(JButton.CENTER);
        b1.setVerticalTextPosition(JButton.CENTER);
        add(b1);
        
        //JButton 2 (Play)
        b2 = new JButton("Play", jbRockTexture);
        b2.setBounds(10, 250, 150, 40);
        b2.setFont(f1);
        b2.setHorizontalTextPosition(JButton.CENTER);
        b2.setVerticalTextPosition(JButton.CENTER);
        b2.addActionListener(this);
        add(b2);
        
        //JButton 3 (Instructions)
        b3 = new JButton("Instructions", jbRockTexture);
        b3.setBounds(10,300, 150, 40);
        b3.setFont(f1);
        b3.setHorizontalTextPosition(JButton.CENTER);
        b3.setVerticalTextPosition(JButton.CENTER);
        b3.addActionListener(this);
        add(b3);
        
        //JButton 4 (Sports Theme)
        b4 = new JButton("Penn State Football", jbsTexture);
        b4.setBounds(275,150, 150, 40);
        b4.setFont(f2);
        b4.setForeground(black);
        b4.setHorizontalTextPosition(JButton.CENTER);
        b4.setVerticalTextPosition(JButton.CENTER);
        b4.addActionListener(this);
        
        //JButton 5 (Pennsylvania Theme)
        b5 = new JButton("Pennsylvania", jbPaTexture);
        b5.setBounds(275,200, 150, 40);
        b5.setFont(f2);
        b5.setForeground(black);
        b5.setHorizontalTextPosition(JButton.CENTER);
        b5.setVerticalTextPosition(JButton.CENTER);
        b5.addActionListener(this);
        
        //JButton 6 (Video Games Theme)
        b6 = new JButton("Video Games", jbVgTexture);
        b6.setBounds(275,250, 150, 40);
        b6.setFont(f2);
        b6.setForeground(black);
        b6.setHorizontalTextPosition(JButton.CENTER);
        b6.setVerticalTextPosition(JButton.CENTER);
        b6.addActionListener(this);
        
        //JButton 7 (Question Representation Button)
        b7 = new JButton();
        b7.setBounds(165,150, 150, 40);
        b7.setFont(f2);
        b7.setForeground(blue);
        b7.setFocusable(false);
        b7.addActionListener(this);
        
        //JRadioButton 1 (Question Answer Choice A, Question 1)
        b8 = new JRadioButton();
        b8.setBounds(250,150, 150, 40);
        b8.setFont(f2);
        b8.setForeground(blue);
        b8.setBorderPainted(false);
        b8.setContentAreaFilled(false);
        b8.addActionListener(this);
        
        //JRadioButton 2 (Question Answer Choice B, Question 1)
        b9 = new JRadioButton();
        b9.setBounds(250,200, 150, 40);
        b9.setFont(f2);
        b9.setForeground(blue);
        b9.setBorderPainted(false);
        b9.setContentAreaFilled(false);
        b9.addActionListener(this);
        
        //JRadioButton 3 (Question Answer Choice C, Question 1)
        b10 = new JRadioButton();
        b10.setBounds(250,250, 150, 40);
        b10.setFont(f2);
        b10.setForeground(blue);
        b10.setBorderPainted(false);
        b10.setContentAreaFilled(false);
        b10.addActionListener(this);
        
        //JRadioButton 4 (Question Answer Choice A, Question 2)
        b11 = new JRadioButton();
        b11.setBounds(250,150, 200, 40);
        b11.setFont(f2);
        b11.setForeground(blue);
        b11.setBorderPainted(false);
        b11.setContentAreaFilled(false);
        b11.addActionListener(this);
        
        //JRadioButton 5 (Question Answer Choice B, Question 2)
        b12 = new JRadioButton();
        b12.setBounds(250,200, 150, 40);
        b12.setFont(f2);
        b12.setForeground(blue);
        b12.setBorderPainted(false);
        b12.setContentAreaFilled(false);
        b12.addActionListener(this);
        
        //JRadioButton 6 (Question Answer Choice C, Question 2)
        b13 = new JRadioButton();
        b13.setBounds(250,250, 150, 40);
        b13.setFont(f2);
        b13.setForeground(blue);
        b13.setBorderPainted(false);
        b13.setContentAreaFilled(false);
        b13.addActionListener(this);
        
        //JRadioButton 7 (Question Answer Choice A, Question 3)
        b14 = new JRadioButton();
        b14.setBounds(250,150, 150, 40);
        b14.setFont(f2);
        b14.setForeground(blue);
        b14.setBorderPainted(false);
        b14.setContentAreaFilled(false);
        b14.addActionListener(this);
        
        //JRadioButton 8 (Question Answer Choice B, Question 3)
        b15 = new JRadioButton();
        b15.setBounds(250,200, 150, 40);
        b15.setFont(f2);
        b15.setForeground(blue);
        b15.setBorderPainted(false);
        b15.setContentAreaFilled(false);
        b15.addActionListener(this);
        
        //JRadioButton 9 (Question Answer Choice C, Question 3)
        b16 = new JRadioButton();
        b16.setBounds(250,250, 150, 40);
        b16.setFont(f2);
        b16.setForeground(blue);
        b16.setBorderPainted(false);
        b16.setContentAreaFilled(false);
        b16.addActionListener(this);
        
        //JRadioButton 10 (Question Answer Choice A, Question 4)
        b17 = new JRadioButton();
        b17.setBounds(250,150, 150, 40);
        b17.setFont(f2);
        b17.setForeground(blue);
        b17.setBorderPainted(false);
        b17.setContentAreaFilled(false);
        b17.addActionListener(this);
        
        //JRadioButton 11 (Question Answer Choice B, Question 4)
        b18 = new JRadioButton();
        b18.setBounds(250,200, 150, 40);
        b18.setFont(f2);
        b18.setForeground(blue);
        b18.setBorderPainted(false);
        b18.setContentAreaFilled(false);
        b18.addActionListener(this);
        
        //JRadioButton 12 (Question Answer Choice C, Question 4)
        b19 = new JRadioButton();
        b19.setBounds(250,250, 150, 40);
        b19.setFont(f2);
        b19.setForeground(blue);
        b19.setBorderPainted(false);
        b19.setContentAreaFilled(false);
        b19.addActionListener(this);
        
        //JRadioButton 13 (Question Answer Choice A, Question 5)
        b20 = new JRadioButton();
        b20.setBounds(250,150, 150, 40);
        b20.setFont(f2);
        b20.setForeground(blue);
        b20.setBorderPainted(false);
        b20.setContentAreaFilled(false);
        b20.addActionListener(this);
        
        //JRadioButton 14 (Question Answer Choice B, Question 5)
        b21 = new JRadioButton();
        b21.setBounds(250,200, 150, 40);
        b21.setFont(f2);
        b21.setForeground(blue);
        b21.setBorderPainted(false);
        b21.setContentAreaFilled(false);
        b21.addActionListener(this);
        
        //JRadioButton 15 (Question Answer Choice C, Question 5)
        b22 = new JRadioButton();
        b22.setBounds(250,250, 150, 40);
        b22.setFont(f2);
        b22.setForeground(blue);
        b22.setBorderPainted(false);
        b22.setContentAreaFilled(false);
        b22.addActionListener(this);
        
        x2 = new XML_240();//Creates XML_240 object to read and write XML files
    }
    public int checkStartscore(){
    if (option.isProfessorSelected == true){
            score = score + 2;
        }
        else if(option.isStudentSelected == true){
            score = score -2;
        }
        else{
            score = 0;
        }
    return score;}
    @Override
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        Font f1 = new Font("Bookman", Font.BOLD, 16);
        if(scoreChecked == false){
            checkStartscore();
            scoreChecked = true;
        }
        //Check if b00 (Instructions back button) is clicked.
        if (obj == b00) {
            Bclicked = true;
            add(b1);
            add(b2);
            add(b3);
            title.setVisible(true);
            remove(b00);}
        
        //Check if b2 (Play) button is clicked.
        if (obj == b2) {
            remove(b1);
            remove(b2);
            remove(b3);
            title.setVisible(false);
            add(b0);
            add(b4);
            add(b5);
            add(b6);
            validate();
            repaint();}
        
        //Check if b3 (instructions) button is clicked
        if (obj == b3) {
            Iclicked = true;
            remove(b1);
            remove(b2);
            remove(b3);
            title.setVisible(false);
            add(b00);
        }
        
        //Check if b4 (Sports Theme) button is clicked
        if (obj == b4) {
            Sclicked = true;
            remove(b4);
            remove(b5);
            remove(b6);
            remove(b0);
            x2.openReaderXML("Game2SportsQuestionBank.xml");
            b7.setBorderPainted(false);
            b7.setContentAreaFilled(false);
            b7.setBounds(100,100, 500, 40);
            b7.setText((String) x2.ReadObject());
            b8.setText((String) x2.ReadObject());
            b9.setText((String) x2.ReadObject());
            b10.setText((String) x2.ReadObject());
            add(b7);
            add(b8);
            add(b9);
            add(b10);
            validate();
            repaint();}
        //Correct Answer (B) Sports Question 1
        if(obj == b9 && Sclicked == true){
            score = score + 2;
            b7.setBounds(50,100, 650, 40);
            b7.setText((String) x2.ReadObject());
            b11.setText((String) x2.ReadObject());
            b12.setText((String) x2.ReadObject());
            b13.setText((String) x2.ReadObject());
            add(b11);
            add(b12);
            add(b13);
            remove(b8);
            remove(b9);
            remove(b10);
            validate();
            repaint();}
        //Wrong Answer (A) Sports Question 1
        if(obj == b8 && Sclicked == true){
            b7.setBounds(50,100, 650, 40);
            b7.setText((String) x2.ReadObject());
            b11.setText((String) x2.ReadObject());
            b12.setText((String) x2.ReadObject());
            b13.setText((String) x2.ReadObject());
            add(b11);
            add(b12);
            add(b13);
            remove(b8);
            remove(b9);
            remove(b10);
            validate();
            repaint();}
        //Wrong Answer (C) Sports Question 1
        if(obj == b10 && Sclicked == true){
            b7.setBounds(50,100, 650, 40);
            b7.setText((String) x2.ReadObject());
            b11.setText((String) x2.ReadObject());
            b12.setText((String) x2.ReadObject());
            b13.setText((String) x2.ReadObject());
            add(b11);
            add(b12);
            add(b13);
            remove(b8);
            remove(b9);
            remove(b10);
            validate();
            repaint();}
        //Correct Answer (B) Sports Question 2
        if(obj == b12 && Sclicked == true){
            score = score + 2;
            b7.setText((String) x2.ReadObject());
            b14.setText((String) x2.ReadObject());
            b15.setText((String) x2.ReadObject());
            add(b14);
            add(b15);
            remove(b11);
            remove(b12);
            remove(b13);
            validate();
            repaint();}
        //Wrong Answer (A) Sports Question 2
        if(obj == b11 && Sclicked == true){
            b7.setText((String) x2.ReadObject());
            b14.setText((String) x2.ReadObject());
            b15.setText((String) x2.ReadObject());
            add(b14);
            add(b15);
            remove(b11);
            remove(b12);
            remove(b13);
            validate();
            repaint();}
        //Wrong Answer (C) Sports Question 2
        if(obj == b13 && Sclicked == true){
            b7.setText((String) x2.ReadObject());
            b14.setText((String) x2.ReadObject());
            b15.setText((String) x2.ReadObject());
            add(b14);
            add(b15);
            remove(b11);
            remove(b12);
            remove(b13);
            validate();
            repaint();}
        //Correct Answer (B) Sports Question 3
        if(obj == b15 && Sclicked == true){
            score = score + 2;
            b7.setText((String) x2.ReadObject());
            b16.setText((String) x2.ReadObject());
            b17.setText((String) x2.ReadObject());
            b18.setText((String) x2.ReadObject());
            add(b16);
            add(b17);
            add(b18);
            remove(b14);
            remove(b15);
            validate();
            repaint();}
        //Wrong Answer (A) Sports Question 3
        if(obj == b14 && Sclicked == true){
            b7.setText((String) x2.ReadObject());
            b16.setText((String) x2.ReadObject());
            b17.setText((String) x2.ReadObject());
            b18.setText((String) x2.ReadObject());
            add(b16);
            add(b17);
            add(b18);
            remove(b14);
            remove(b15);
            validate();
            repaint();}
        //Correct Answer (C) Sports Question 4
        if(obj == b18 && Sclicked == true){
            score = score + 2;
            b7.setText((String) x2.ReadObject());
            b19.setText((String) x2.ReadObject());
            b20.setText((String) x2.ReadObject());
            b21.setText((String) x2.ReadObject());
            add(b19);
            add(b20);
            add(b21);
            remove(b16);
            remove(b17);
            remove(b18);
            validate();
            repaint();}
        //Wrong Answer (A) Sports Question 4
        if(obj == b16 && Sclicked == true){
            b7.setText((String) x2.ReadObject());
            b19.setText((String) x2.ReadObject());
            b20.setText((String) x2.ReadObject());
            b21.setText((String) x2.ReadObject());
            add(b19);
            add(b20);
            add(b21);
            remove(b16);
            remove(b17);
            remove(b18);
            validate();
            repaint();}
        //Wrong Answer (B) Sports Question 4
        if(obj == b17 && Sclicked == true){
            b7.setText((String) x2.ReadObject());
            b19.setText((String) x2.ReadObject());
            b20.setText((String) x2.ReadObject());
            b21.setText((String) x2.ReadObject());
            add(b19);
            add(b20);
            add(b21);
            remove(b16);
            remove(b17);
            remove(b18);
            validate();
            repaint(); }
        //Correct Answer (A) Sports Question 5
        if(obj == b19 && Sclicked == true){
            score = score + 2;
            remove(b19);
            remove(b20);
            remove(b21);
            b7.setFont(f1);
            b7.setBackground(Color.WHITE);
            b7.setContentAreaFilled(true);
            b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
            b7.setBounds(200, 150, 400, 150);
            b1.setBounds(635,521, 150, 40);
            add(b1);
            x2.closeReaderXML();
            validate();
            repaint();
        }
        //Wrong Answer (B) Sports Question 5
        if(obj == b20 && Sclicked == true){
            remove(b19);
            remove(b20);
            remove(b21);
            b7.setFont(f1);
            b7.setBackground(Color.WHITE);
            b7.setContentAreaFilled(true);
            b7.setBounds(200, 150, 400, 150);
            b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
            b1.setBounds(635,521, 150, 40);
            add(b1);
            x2.closeReaderXML();
            validate();
            repaint();
        }
        //Wrong Answer (C) Sports Question 5
        if(obj == b21 && Sclicked == true){
            remove(b19);
            remove(b20);
            remove(b21);
            b7.setFont(f1);
            b7.setBackground(Color.WHITE);
            b7.setContentAreaFilled(true);
            b7.setBounds(200, 150, 400, 150);
            b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!" );
            b1.setBounds(635,521, 150, 40);
            add(b1);
            x2.closeReaderXML();
            validate();
            repaint();
        }
        //Check if b5 (PA Theme) button is clicked
        if (obj == b5) {
            Pclicked = true;
            x2.openReaderXML("Game2PAQuestionBank.xml");
            b7.setBorderPainted(false);
            b7.setContentAreaFilled(false);
            b7.setBounds(50,100, 600, 40);
            b7.setText((String) x2.ReadObject());
            b8.setText((String) x2.ReadObject());
            b9.setText((String) x2.ReadObject());
            b10.setText((String) x2.ReadObject());
            remove(b4);
            remove(b5);
            remove(b6);
            remove(b0);
            add(b7);
            add(b8);
            add(b9);
            add(b10);
            validate();
            repaint();}
        //Correct Answer (A) Pennsylvania Question 1
        if(obj == b8 && Pclicked == true){
            score = score + 2;
            b7.setText((String) x2.ReadObject());
            b11.setText((String) x2.ReadObject());
            b12.setText((String) x2.ReadObject());
            b13.setText((String) x2.ReadObject());
            add(b11);
            add(b12);
            add(b13);
            remove(b8);
            remove(b9);
            remove(b10);
            validate();
            repaint();}
        //Wrong Answer (B) Pennsylvania Question 1
        if(obj == b9 && Pclicked == true){
            b7.setText((String) x2.ReadObject());
            b11.setText((String) x2.ReadObject());
            b12.setText((String) x2.ReadObject());
            b13.setText((String) x2.ReadObject());
            add(b11);
            add(b12);
            add(b13);
            remove(b8);
            remove(b9);
            remove(b10);
            validate();
            repaint();}
        //Wrong Answer (C) Pennsylvania Question 1
        if(obj == b10 && Pclicked == true){
            b7.setText((String) x2.ReadObject());
            b11.setText((String) x2.ReadObject());
            b12.setText((String) x2.ReadObject());
            b13.setText((String) x2.ReadObject());
            add(b11);
            add(b12);
            add(b13);
            remove(b8);
            remove(b9);
            remove(b10);
            validate();
            repaint();}
        //Correct Answer (C) Pennsylvania Question 2
        if(obj == b13 && Pclicked == true){
            score = score + 2;
            b7.setText((String) x2.ReadObject());
            b14.setText((String) x2.ReadObject());
            b15.setText((String) x2.ReadObject());
            b16.setText((String) x2.ReadObject());
            add(b14);
            add(b15);
            add(b16);
            remove(b11);
            remove(b12);
            remove(b13);
            validate();
            repaint();}
        //Wrong Answer (A) Pennsylvania Question 2
        if(obj == b11 && Pclicked == true){
            b7.setText((String) x2.ReadObject());
            b14.setText((String) x2.ReadObject());
            b15.setText((String) x2.ReadObject());
            b16.setText((String) x2.ReadObject());
            add(b14);
            add(b15);
            add(b16);
            remove(b11);
            remove(b12);
            remove(b13);
            validate();
            repaint();}
        //Wrong Answer (B) Pennsylvania Question 2
        if(obj == b12 && Pclicked == true){
            b7.setText((String) x2.ReadObject());
            b14.setText((String) x2.ReadObject());
            b15.setText((String) x2.ReadObject());
            b16.setText((String) x2.ReadObject());
            add(b14);
            add(b15);
            add(b16);
            remove(b11);
            remove(b12);
            remove(b13);
            validate();
            repaint();}
        //Correct Answer (B) Pennsylvania Question 3
        if(obj == b15 && Pclicked == true){
            score = score + 2;
            b7.setText((String) x2.ReadObject());
            b17.setText((String) x2.ReadObject());
            b18.setText((String) x2.ReadObject());
            b19.setText((String) x2.ReadObject());
            add(b17);
            add(b18);
            add(b19);
            remove(b14);
            remove(b15);
            remove(b16);
            validate();
            repaint();}
        //Wrong Answer (A) Pennsylvania Question 3
        if(obj == b14 && Pclicked == true){
            b7.setText((String) x2.ReadObject());
            b17.setText((String) x2.ReadObject());
            b18.setText((String) x2.ReadObject());
            b19.setText((String) x2.ReadObject());
            add(b17);
            add(b18);
            add(b19);
            remove(b14);
            remove(b15);
            remove(b16);
            validate();
            repaint();}
        //Wrong Answer (C) Pennsylvania Question 3
        if(obj == b16 && Pclicked == true){
            b7.setText((String) x2.ReadObject());
            b17.setText((String) x2.ReadObject());
            b18.setText((String) x2.ReadObject());
            b19.setText((String) x2.ReadObject());
            add(b17);
            add(b18);
            add(b19);
            remove(b14);
            remove(b15);
            remove(b16);
            validate();
            repaint();}
        //Correct Answer (C) Pennsylvania Question 4
        if(obj == b19 && Pclicked == true){
            score = score + 2;
            b7.setText((String) x2.ReadObject());
            b20.setText((String) x2.ReadObject());
            b21.setText((String) x2.ReadObject());
            b22.setText((String) x2.ReadObject());
            add(b20);
            add(b21);
            add(b22);
            remove(b17);
            remove(b18);
            remove(b19);
            validate();
            repaint();}
        //Wrong Answer (A) Pennsylvania Question 4
        if(obj == b17 && Pclicked == true){
            b7.setText((String) x2.ReadObject());
            b20.setText((String) x2.ReadObject());
            b21.setText((String) x2.ReadObject());
            b22.setText((String) x2.ReadObject());
            add(b20);
            add(b21);
            add(b22);
            remove(b17);
            remove(b18);
            remove(b19);
            validate();
            repaint();}
        //Wrong Answer (B) Pennsylvania Question 4
        if(obj == b18 && Pclicked == true){
            b7.setText((String) x2.ReadObject());
            b20.setText((String) x2.ReadObject());
            b21.setText((String) x2.ReadObject());
            b22.setText((String) x2.ReadObject());
            add(b20);
            add(b21);
            add(b22);
            remove(b17);
            remove(b18);
            remove(b19);
            validate();
            repaint();}
        //Correct Answer (C) Pennsylvania Question 5
        if(obj == b22 && Pclicked == true){
            score = score + 2;
            remove(b20);
            remove(b21);
            remove(b22);
            b7.setFont(f1);
            b7.setBackground(Color.WHITE);
            b7.setContentAreaFilled(true);
            b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
            b7.setBounds(200, 150, 400, 150);
            b1.setBounds(635,521, 150, 40);
            add(b1);
            x2.closeReaderXML();
            validate();
            repaint();}
        //Wrong Answer (A) Pennsylvania Question 5
        if(obj == b20 && Pclicked == true){
            remove(b20);
            remove(b21);
            remove(b22);
            b7.setFont(f1);
            b7.setBackground(Color.WHITE);
            b7.setContentAreaFilled(true);
            b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
            b7.setBounds(200, 150, 400, 150);
            b1.setBounds(635,521, 150, 40);
            add(b1);
            x2.closeReaderXML();
            validate();
            repaint();}
        //Wrong Answer (B) Pennsylvania Question 5
        if(obj == b21 && Pclicked == true){
            remove(b20);
            remove(b21);
            remove(b22);
            b7.setFont(f1);
            b7.setBackground(Color.WHITE);
            b7.setContentAreaFilled(true);
            b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
            b7.setBounds(200, 150, 400, 150);
            b1.setBounds(635,521, 150, 40);
            add(b1);
            x2.closeReaderXML();
            validate();
            repaint();}
        //Check if b6 (Video Games Theme) button is clicked
        if (obj == b6) {
            Vclicked = true;
            remove(b4);
            remove(b5);
            remove(b6);
            x2.openReaderXML("Game2VideoGameQuestionBank.xml");
            b7.setBorderPainted(false);
            b7.setContentAreaFilled(false);
            b7.setBounds(150,100, 500, 40);
            b7.setText((String) x2.ReadObject());
            b8.setText((String) x2.ReadObject());
            b9.setText((String) x2.ReadObject());
            b10.setText((String) x2.ReadObject());
            remove(b0);
            remove(b4);
            remove(b5);
            remove(b6);
            add(b7);
            add(b8);
            add(b9);
            add(b10);
            validate();
            repaint();}
        //Correct Answer (B) Video Games Question 1
        if(obj == b9 && Vclicked == true){
            score = score + 2;
            b7.setText((String) x2.ReadObject());
            b11.setText((String) x2.ReadObject());
            b12.setText((String) x2.ReadObject());
            b13.setText((String) x2.ReadObject());
            add(b11);
            add(b12);
            add(b13);
            remove(b8);
            remove(b9);
            remove(b10);
            validate();
            repaint();}
        //Wrong Answer (A) Video Games Question 1
        if(obj == b8 && Vclicked == true){
            b7.setText((String) x2.ReadObject());
            b11.setText((String) x2.ReadObject());
            b12.setText((String) x2.ReadObject());
            b13.setText((String) x2.ReadObject());
            add(b11);
            add(b12);
            add(b13);
            remove(b8);
            remove(b9);
            remove(b10);
            validate();
            repaint();}
        //Wrong Answer (C) Video Games Question 1
        if(obj == b10 && Vclicked == true){
            b7.setText((String) x2.ReadObject());
            b11.setText((String) x2.ReadObject());
            b12.setText((String) x2.ReadObject());
            b13.setText((String) x2.ReadObject());
            add(b11);
            add(b12);
            add(b13);
            remove(b8);
            remove(b9);
            remove(b10);
            validate();
            repaint();}
        //Correct Answer (C) Video Games Question 2
        if(obj == b13 && Vclicked == true){
            score = score + 2;
            b7.setText((String) x2.ReadObject());
            b14.setText((String) x2.ReadObject());
            b15.setText((String) x2.ReadObject());
            b16.setText((String) x2.ReadObject());
            add(b14);
            add(b15);
            add(b16);
            remove(b11);
            remove(b12);
            remove(b13);
            validate();
            repaint();}
        //Wrong Answer (A) Video Games Question 2
        if(obj == b12 && Vclicked == true){
            b7.setText((String) x2.ReadObject());
            b14.setText((String) x2.ReadObject());
            b15.setText((String) x2.ReadObject());
            b16.setText((String) x2.ReadObject());
            add(b14);
            add(b15);
            add(b16);
            remove(b11);
            remove(b12);
            remove(b13);
            validate();
            repaint();}
        //Wrong Answer (B) Video Games Question 2
        if(obj == b11 && Vclicked == true){
            b7.setText((String) x2.ReadObject());
            b14.setText((String) x2.ReadObject());
            b15.setText((String) x2.ReadObject());
            b16.setText((String) x2.ReadObject());
            add(b14);
            add(b15);
            add(b16);
            remove(b11);
            remove(b12);
            remove(b13);
            validate();
            repaint();}
        //Correct Answer (B) Video Games Question 3
        if(obj == b15 && Vclicked == true){
            score = score + 2;
            b7.setBounds(100,100, 650, 40);
            b7.setText((String) x2.ReadObject());
            b17.setText((String) x2.ReadObject());
            b18.setText((String) x2.ReadObject());
            add(b17);
            add(b18);
            remove(b14);
            remove(b15);
            remove(b16);
            validate();
            repaint();}
        //Wrong Answer (A) Video Games Question 3
        if(obj == b14 && Vclicked == true){
            b7.setBounds(100,100, 650, 40);
            b7.setText((String) x2.ReadObject());
            b17.setText((String) x2.ReadObject());
            b18.setText((String) x2.ReadObject());
            add(b17);
            add(b18);
            remove(b14);
            remove(b15);
            remove(b16);
            validate();
            repaint();}
        //Wrong Answer (C) Video Games Question 3
        if(obj == b16 && Vclicked == true){
            b7.setBounds(100,100, 650, 40);
            b7.setText((String) x2.ReadObject());
            b17.setText((String) x2.ReadObject());
            b18.setText((String) x2.ReadObject());
            add(b17);
            add(b18);
            remove(b14);
            remove(b15);
            remove(b16);
            validate();
            repaint();}
        //Correct Answer (A) Video Games Question 4
        if(obj == b17 && Vclicked == true){
            score = score + 2;
            b7.setBounds(150, 100, 500, 40);
            b7.setText((String) x2.ReadObject());
            b19.setText((String) x2.ReadObject());
            b20.setText((String) x2.ReadObject());
            b21.setText((String) x2.ReadObject());
            add(b19);
            add(b20);
            add(b21);
            remove(b17);
            remove(b18);
            validate();
            repaint();}
        //Wrong Answer (B) Video Games Question 4
        if(obj == b18 && Vclicked == true){
            b7.setBounds(150, 100, 500, 40);
            b7.setText((String) x2.ReadObject());
            b19.setText((String) x2.ReadObject());
            b20.setText((String) x2.ReadObject());
            b21.setText((String) x2.ReadObject());
            add(b19);
            add(b20);
            add(b21);
            remove(b17);
            remove(b18);
            validate();
            repaint();}
        //Correct Answer (C) Video Games Question 5
        if(obj == b21 && Vclicked == true){
            score = score + 2;
            remove(b19);
            remove(b20);
            remove(b21);
            b7.setFont(f1);
            b7.setBackground(Color.WHITE);
            b7.setContentAreaFilled(true);
            b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
            b7.setBounds(200, 150, 400, 150);
            b1.setBounds(635,521, 150, 40);
            add(b1);
            x2.closeReaderXML();
            validate();
            repaint();
        }
        //Wrong Answer (A) Video Games Question 5
        if(obj == b19 && Vclicked == true){
            remove(b19);
            remove(b20);
            remove(b21);
            b7.setFont(f1);
            b7.setBackground(Color.WHITE);
            b7.setContentAreaFilled(true);
            b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
            b7.setBounds(200, 150, 400, 150);
            b1.setBounds(635,521, 150, 40);
            add(b1);
            x2.closeReaderXML();
            validate();
            repaint();
        }
        //Wrong Answer (B) Video Games Question 5
        if(obj == b20 && Vclicked == true){
            remove(b19);
            remove(b20);
            remove(b21);
            b7.setFont(f1);
            b7.setBackground(Color.WHITE);
            b7.setContentAreaFilled(true);
            b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
            b7.setBounds(200, 150, 400, 150);
            b1.setBounds(635,521, 150, 40);
            add(b1);
            x2.closeReaderXML();
            validate();
            repaint();
            
        }}
    private void drawChar(Graphics g)
    {
        
        if(option.isStudentSelected == true){
            g.drawImage(student,50, 50, null);
        }
        else if(option.isProfessorSelected == true){
            g.drawImage(professor, 50, 50, null);
            
        }
        else{
            g.drawImage(mascot, 50, 50, null);
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        //Draw character, add title header, and starting background
        g.drawImage(startBackground, 0, 0, null );
        drawChar(g);
        add(title);
        revalidate();
        repaint();
        
        //If instructions is clicked
        if (Iclicked == true){
            
            g.setColor(Color.WHITE);
            Font f2 = new Font("Bookman", Font.BOLD, 20);
            g.setFont(f2);
            g.drawString("INSTRUCTIONS", 300, 125);
            Font f1 = new Font("Bookman", Font.BOLD, 15);
            g.setFont(f1);
            g.drawString("1. After selecting play, you will choose a theme that will decide the subject of questions asked.", 50, 200);
            g.drawString("2. There are 5 questions per theme, each worth 2 points.", 50, 230);
            g.drawString("3. Score is displayed at the top right.", 50, 260);}
        
        //If back button in instructions is clicked
        if (Bclicked == true){
            
            g.drawImage(startBackground, 0, 0, null);
            drawChar(g);
        }
        
        //If Sports Theme is clicked
        if (Sclicked == true){
            g.drawImage(sBackground, 0, 0, null);
            g.setColor(Color.WHITE);
            g.drawString("Score: " + score, 650, 30);
            drawChar(g);
        //Nested if to check for professor intelligence notification
        if(option.isProfessorSelected == true){
            g.drawString("+2! (Professor Intelligence)", 600, 10);}
        //Nested if to check for student intelligence notification
        if(option.isStudentSelected == true){
            g.drawString("-2! Student Intelligence!)", 600, 10);
        }
        }     
        //If Pennsylvania Theme is clicked
        if (Pclicked == true){
            g.drawImage(paBackground, 0, 0, null);
            g.setColor(Color.WHITE);
            g.drawString("Score: " + score, 650, 30);
            drawChar(g);
       if(option.isProfessorSelected == true){
            g.drawString("+2! (Professor Intelligence)", 600, 10);}
        if(option.isStudentSelected == true){
            g.drawString("-2! Student Intelligence!)", 600, 10);
        } }
        
        //If Video Games Theme is clicked
        if (Vclicked == true){
            g.drawImage(vgBackground, 0, 0, null);
            g.setColor(Color.WHITE);
            g.drawString("Score: " + score, 650, 30);
            drawChar(g);
        
         if(option.isProfessorSelected == true){
            g.drawString("+2! (Professor Intelligence)", 600, 10);}
        if(option.isStudentSelected == true){
            g.drawString("-2! Student Intelligence!)", 600, 10);
        }}
        validate();
        repaint();
    }
}


