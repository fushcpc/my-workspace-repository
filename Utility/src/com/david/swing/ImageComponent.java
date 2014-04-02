package com.david.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class ImageComponent extends JComponent {
    private static final long serialVersionUID = -4598696263998220727L;
    private int x;
    private int y;
    private Image image;

    public ImageComponent(Point point, String imageFileName) {
        this((int) point.getX(), (int) point.getY(), imageFileName);
    }

    public ImageComponent(int x, int y, String imageFileName) {
        this.x = x;
        this.y = y;
        try {
            this.image = ImageIO.read(new File(imageFileName));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "无法读取图片");
            e.printStackTrace();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Rectangle2D getRectangle() {
        return new Rectangle(getX(), getY(), getImage().getWidth(null), getImage().getHeight(null));
    }

    public boolean isHit(Rectangle2D rect) {
        return getRectangle().intersects(rect);
    }

    public void draw(Graphics g, JComponent component) {
        g.drawImage(getImage(), getX(), getY(), getImage().getWidth(null), getImage().getHeight(null), component);
    }
}
