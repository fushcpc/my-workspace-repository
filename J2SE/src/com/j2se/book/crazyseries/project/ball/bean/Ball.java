package com.j2se.book.crazyseries.project.ball.bean;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.List;

import com.david.swing.ImageComponent;
import com.j2se.book.crazyseries.project.ball.Constants;

public class Ball extends ImageComponent {
    private final static String BALL_IMAGE = "Images/Ball/ball.gif";
    private final static int    BALL_SIZE  = 15;
    private int                 moveX      = 5;
    private int                 moveY      = -5;

    public Ball() {
        super((Constants.PANEL_WIDTH - BALL_SIZE) / 2, Constants.PANEL_HEIGHT - BALL_SIZE - Constants.STICK_IMAGE_HEIGHT, BALL_IMAGE);
    }

    public GameState move(List<List<Brick>> bricks, Stick stick) {
        if (getY() >= Constants.PANEL_HEIGHT) {
            return GameState.LOSE;
        }
        if ((getMaxX() + moveX >= Constants.PANEL_WIDTH) || (getX() + moveX <= 0)) {
            moveX = -moveX;
        } else if ((getY() + moveY <= 0) || (stick.isHit(this.getRectangle())) || stick.isHit(this.getNextRectangle())) {
            moveY = -moveY;
        }

        boolean isAllBricksEnable = true;
        boolean hasHit = false;
        for (List<Brick> brickList : bricks) {
            for (Brick brick : brickList) {
                if (brick.isEnabled()) {
                    isAllBricksEnable = false;
                    if (this.getRectangle().intersects(brick.getRectangle())) {
                        brick.setEnabled(false);
                        moveY = -moveY;
                        hasHit = true;
                        break;
                    }
                }
            }
            if (hasHit) {
                break;
            }
        }
        if (isAllBricksEnable) {
            return GameState.WIN;
        }

        setNewPoint();
        return GameState.PLAYING;
    }

    private Rectangle2D getNextRectangle() {
        return new Rectangle(getX() + moveX, getY() + moveY, getImage().getWidth(null), getImage().getHeight(null));
    }

    private void setNewPoint() {
        setX(getX() + moveX);
        setY(getY() + moveY);
    }

    public int getMaxX() {
        return getX() + BALL_SIZE;
    }

    public int getMaxY() {
        return getY() + BALL_SIZE;
    }

}
