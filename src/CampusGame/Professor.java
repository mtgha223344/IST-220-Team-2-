package CampusGame;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Professor extends Character {

    private int width;
    private int height;
    private Image image;

    public Professor() {

        loadImage();
    }

    @Override
    public void loadImage() {

        ImageIcon ii = new ImageIcon(getClass().getResource("/resources/professorIcon.JPG"));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    @Override
    public Image getImage() {

        return image;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(super.getX(), super.getY(), width, height);
    }

}
