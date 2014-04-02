package com.david.swing;

import java.awt.Dimension;

import javax.swing.JPanel;

public class InitPanel extends JPanel {
    private static final long serialVersionUID = 1376626882036321970L;

    public InitPanel(int width, int height) {
        //        this.setSize(width, height);
        this.setPreferredSize(new Dimension(width, height));
    }
}
