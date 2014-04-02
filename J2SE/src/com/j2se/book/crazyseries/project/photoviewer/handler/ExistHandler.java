package com.j2se.book.crazyseries.project.photoviewer.handler;

import com.j2se.book.crazyseries.project.photoviewer.ViewerFrame;

public class ExistHandler implements ViewHandler {

    @Override
    public void handle(ViewerFrame frame) {
        System.exit(0);
    }

}
