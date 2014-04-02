package com.j2se.book.crazyseries.project.photoviewer;

import java.awt.EventQueue;

public class PhotoViewerLancher {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewerFrame();
            }
        });
    }
}
