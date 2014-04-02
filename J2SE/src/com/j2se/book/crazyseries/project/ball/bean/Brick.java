package com.j2se.book.crazyseries.project.ball.bean;

import com.david.swing.ImageComponent;

public class Brick extends ImageComponent {
    private static final String IMAGE_FILE_PATH = "Images/Ball/brick.gif";

    public Brick(int x, int y) {
        super(x, y, IMAGE_FILE_PATH);
    }
}
