package com.j2se.book.crazyseries.project.photoviewer.handler;

import java.io.File;

import com.j2se.book.crazyseries.project.photoviewer.ViewerFrame;

public class NavigateHandler implements ViewHandler {

    private final boolean isNextNavigate;

    public NavigateHandler(boolean isNextNavigate) {
        this.isNextNavigate = isNextNavigate;
    }

    @Override
    public void handle(ViewerFrame frame) {
        File navigateFile;
        if (isNextNavigate) {
            navigateFile = frame.getNextFile();
        } else {
            navigateFile = frame.getPrevFile();
        }
        frame.resetPhoto(navigateFile);
    }
}
