package com.j2se.book.crazyseries.project.photoviewer.handler;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;

import com.david.swing.utility.CollectionUtility;
import com.j2se.book.crazyseries.project.photoviewer.ViewerFrame;

public class OpenHandler implements ViewHandler {

    @Override
    public void handle(ViewerFrame frame) {
        JFileChooser fChooser = frame.getFileChooser();
        if (JFileChooser.APPROVE_OPTION == fChooser.showOpenDialog(frame)) {
            File currentFile = fChooser.getSelectedFile();
            File currentDir = fChooser.getCurrentDirectory();
            if (frame.getCurrentDir() == null || currentDir != frame.getCurrentDir()) {
                setCurrentFiles(frame, currentDir, currentFile);
            }
            frame.resetPhoto(currentFile);
        }
    }

    private void setCurrentFiles(ViewerFrame frame, File currentDir, File currentFile) {
        frame.getCurrenFiles().clear();
        List<File> currentFiles = Arrays.asList(currentDir.listFiles());
        JFileChooser fChooser = frame.getFileChooser();
        for (File file : currentFiles) {
            if (fChooser.accept(file)) {
                frame.getCurrenFiles().add(file);
            }
        }
        if (!CollectionUtility.isNullOrEmpty(frame.getCurrenFiles())) {
            int currentFileIndex = frame.getCurrenFiles().indexOf(currentFile);
            frame.setCurrentFileIndex(currentFileIndex);
            // frame.setCurrentFile(currentFile);
        }
    }

}
