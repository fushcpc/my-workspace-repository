package com.j2se.book.crazyseries.project.ball.bean;

import com.david.swing.ImageComponent;
import com.j2se.book.crazyseries.project.ball.Constants;

public abstract class Stick extends ImageComponent {

    private final static int MOVE_SIZE = 10;

    public Stick(int x, int y, String imageFileName) {
        super(x, y, imageFileName);
    }

    public void moveToRight() {
        int stickImgLen = getImage().getWidth(null);
        if (getX() + stickImgLen + MOVE_SIZE >= Constants.PANEL_WIDTH) {
            setX(Constants.PANEL_WIDTH - stickImgLen);
        } else {
            setX(getX() + MOVE_SIZE);
        }
    }

    public void moveToLeft() {
        if (getX() - MOVE_SIZE <= 0) {
            setX(0);
        } else {
            setX(getX() - MOVE_SIZE);
        }
    }

}
