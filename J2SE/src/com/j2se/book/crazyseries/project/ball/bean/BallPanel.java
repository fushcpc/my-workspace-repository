package com.j2se.book.crazyseries.project.ball.bean;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import com.david.swing.InitPanel;
import com.j2se.book.crazyseries.project.ball.Constants;
import com.j2se.book.crazyseries.project.ball.service.Service;

public class BallPanel extends InitPanel {

    private final static int  REPAINT_INTERVAL = 200;

    private List<List<Brick>> bricks           = new ArrayList<List<Brick>>();
    private Stick             stick;
    private Ball              ball;
    private Timer             timer;
    @SuppressWarnings("unused")
    private GameState         gameState;

    public BallPanel() {
        super(Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT);
        initialize();
        this.setFocusable(true);// TODO:使用这个方法，以便可以让jpanel的keyListener起作用。
    }

    private void initialize() {
        for (int i = 0; i < 5; i++) {
            List<Brick> brickList = new ArrayList<Brick>();
            for (int j = 0; j < 10; j++) {
                Brick brick = null;
                if (Service.isBrickRequired()) {
                    brick = new Brick(j * 28, i * 28);
                }
                brickList.add(brick);
            }
            bricks.add(brickList);
        }
        stick = new ShortStick(Constants.STICK_INIT_X, Constants.STICK_INIT_Y);
        ball = new Ball();
        this.addKeyListener(getKeyListener());
        if (timer == null) {
            timer = new Timer(REPAINT_INTERVAL, getRepainActionListener());
            timer.start();
            gameState = GameState.PLAYING;
        }
    }

    private KeyListener getKeyListener() {
        return new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_RIGHT) {
                    stick.moveToRight();
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    stick.moveToLeft();
                }
            }
        };
    }

    private ActionListener getRepainActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                GameState moveResult = ball.move(bricks, stick);
                handleGameState(moveResult);
            }

            private void handleGameState(GameState moveResult) {
                if (GameState.PLAYING.equals(moveResult)) {
                    return;
                }
                if (GameState.LOSE.equals(moveResult)) {
                    timer.stop();
                }
                if (GameState.WIN.equals(moveResult)) {
                    timer.stop();
                }
            }
        };
    }

    @Override
    public void paint(Graphics g) {
        // TODO: must clear before repaint those components
        // or invoke the parent class paint method first.
        // g.clearRect(0, 0, this.getWidth(), this.getHeight());
        super.paint(g);
        for (List<Brick> brickList : bricks) {
            for (Brick brick : brickList) {
                if (brick.isEnabled()) {
                    brick.draw(g, this);
                }
            }
        }
        stick.draw(g, this);
        ball.draw(g, this);
    }

}
