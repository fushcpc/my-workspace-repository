package com.j2se.book.crazyseries.project.photoviewer.handler;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.j2se.book.crazyseries.project.photoviewer.ViewerFrame;

public class DeleteHandler implements ViewHandler {

    @Override
    public void handle(ViewerFrame frame) {
        File file = frame.getCurrentFile();
        if (file == null) {
            return;
        }
        int result = JOptionPane.showConfirmDialog(frame, "你确定要删除当前文件吗？");
        if (result == JOptionPane.YES_OPTION) {
            file.delete();
            frame.getCurrenFiles().clear();
            int index = frame.getCurrentFileIndex();
            File currentDir = file.getParentFile();
            List<File> currentFiles = Arrays.asList(currentDir.listFiles());
            JFileChooser fChooser = frame.getFileChooser();
            for (File cFile : currentFiles) {
                if (fChooser.accept(cFile)) {
                    frame.getCurrenFiles().add(cFile);
                }
            }
            if (index + 1 > frame.getCurrenFiles().size()) {
                frame.setCurrentFileIndex(frame.getCurrenFiles().size() - 1);
            }

            frame.resetPhoto(frame.getCurrentFile());
        }
    }

}
