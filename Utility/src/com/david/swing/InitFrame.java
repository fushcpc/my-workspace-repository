package com.david.swing;

import javax.swing.JFrame;

public class InitFrame extends JFrame {

    private static final long serialVersionUID = -2532506588987592196L;

    public InitFrame(int width, int height, MyFrameType type) {
        if (MyFrameType.CENTER.equals(type)) {
            this.setBounds((SwingConstant.SCREEN_WIDTH - width) / 2, (SwingConstant.SCREEN_HEIGHT - height) / 3, width, height);
            this.setResizable(Boolean.FALSE);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }
    }
}
