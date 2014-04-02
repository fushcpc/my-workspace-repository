package com.jimmy.tools.filetransporter;

import java.awt.EventQueue;

public class Lancher {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileTransporterFrame().setVisible(true);
            }
        });
    }
}
