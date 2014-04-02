package com.j2se.book.crazyseries.project.ball.bean;

import com.david.swing.InitFrame;
import com.david.swing.MyFrameType;
import com.j2se.book.crazyseries.project.ball.Constants;

public class BallGameFrame extends InitFrame {
    private BallPanel ballPanel;

    public BallGameFrame() {
        super(Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT, MyFrameType.CENTER);
        ballPanel = new BallPanel();
        this.add(ballPanel);
        this.setTitle("BallGame");
        this.pack();
    }

}
