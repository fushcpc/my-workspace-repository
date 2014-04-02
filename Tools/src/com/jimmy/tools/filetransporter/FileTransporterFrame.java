package com.jimmy.tools.filetransporter;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

import com.david.swing.utility.IOUtility;
import com.david.swing.utility.SwingUtility;

public class FileTransporterFrame extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;
    private static final String TITLE = "FileTransporter V1";
    private PathPanel srcPathPanel;
    private PathPanel distPathPanel;
    private JTextArea ta;
    private File srcPath;
    private File distPath;
    private JButton transportBtn;
    private static final Set<String> invalidFolderNames;
    private static final Set<String> ignoreFileTypes;
    static {
        Set<String> folderNames = new HashSet<String>();

        folderNames.add(".svn");
        folderNames.add(".metadata");
        //        folderNames.add(".settings");
        folderNames.add("bin");
        invalidFolderNames = Collections.unmodifiableSet(folderNames);
        Set<String> fileTypes = new HashSet<String>();
        //        fileNames.add(".classpath");
        fileTypes.add(".project");
        fileTypes.add(".GDS");
        fileTypes.add(".asta");
        fileTypes.add(".bak");
        fileTypes.add(".class");
        ignoreFileTypes = Collections.unmodifiableSet(fileTypes);
    }

    public FileTransporterFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle(TITLE);
        this.srcPathPanel = this.getSrcPathPanel();
        this.distPathPanel = this.getDistPathPanel();
        this.setLayout(new BorderLayout());
        this.add(srcPathPanel, BorderLayout.NORTH);
        this.add(distPathPanel, BorderLayout.CENTER);
        this.add(getSouthPanel(), BorderLayout.SOUTH);
        SwingUtility.setDefaultBehavior(this);
        SwingUtility.setInCenterCorner(this);
        SwingUtility.initGlobalFontForMSYH();
        this.pack();
    }

    private Component getSouthPanel() {
        ta = new JTextArea(10, 50);
        ta.setAutoscrolls(true);
        JScrollPane scrollPane = new JScrollPane(ta);
        transportBtn = new JButton("Transport");
        transportBtn.addActionListener(new TransportbtnListener(transportBtn, ta));
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.add(scrollPane, BorderLayout.NORTH);
        southPanel.add(transportBtn);
        return southPanel;
    }

    private FileFilter getPathFilter() {
        return new FileFilter() {
            @Override
            public String getDescription() {
                return "Only directory";
            }

            @Override
            public boolean accept(File f) {
                if (f != null && f.isDirectory()) {
                    return true;
                }
                return false;
            }
        };
    }

    private PathPanel getDistPathPanel() {
        return new PathPanel("Target Path:", "Choose Target Folder", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                distPath = getSelectPath();
                if (distPath != null) {
                    distPathPanel.getSrcPathField().setText(distPath.getAbsolutePath());
                }
            }
        });
    }

    private PathPanel getSrcPathPanel() {
        return new PathPanel("Source Path:", "Choose Source Folder", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                srcPath = getSelectPath();
                if (srcPath != null) {
                    srcPathPanel.getSrcPathField().setText(srcPath.getAbsolutePath());
                }
            }
        });
    }

    private File getSelectPath() {
        JFileChooser pathChooser = new JFileChooser();
        pathChooser.setFileFilter(getPathFilter());
        pathChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (JFileChooser.APPROVE_OPTION == pathChooser.showOpenDialog(null)) {
            return pathChooser.getSelectedFile();
        }
        return null;
    }

    private class TransportbtnListener implements ActionListener {
        private JButton transportBtn;
        private JTextArea ta;

        public TransportbtnListener(JButton transportBtn, JTextArea ta) {
            this.transportBtn = transportBtn;
            this.ta = ta;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (distPath == null || srcPath == null) {
                return;
            }
            moveFile(srcPath);
            JOptionPane.showMessageDialog(null, "Transport jobs are done!");
        }

        private void moveFile(File srcPath) {
            transportBtn.setEnabled(false);
            File[] files = srcPath.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    if (invalidFolderNames.contains(file.getName())) {
                        ta.append(ta.getText() + "Invalid folder found :" + file.getName() + "\n");
                        ta.paintImmediately(ta.getBounds());
                        continue;
                    }
                    moveFile(file);
                } else {
                    if (ignoreFileTypes.contains(IOUtility.getFileExtention(file))) {
                        ta.append(ta.getText() + "Invalid file type found:" + file.getName() + "\n");
                        ta.paintImmediately(ta.getBounds());
                        continue;
                    }
                    copyTheFile(file);
                }
            }
            transportBtn.setEnabled(true);
        }

        private void copyTheFile(File fileToBeCopied) {
            String srcAbsolutePath = fileToBeCopied.getAbsolutePath();
            String apendPath = srcAbsolutePath.substring(srcPath.getAbsolutePath().length());
            File outputDir = new File(distPath.getAbsolutePath() + apendPath.substring(0, apendPath.lastIndexOf(File.separator)));
            outputDir.mkdirs();
            FileOutputStream writer = null;
            FileInputStream fis = null;
            try {
                writer = new FileOutputStream(distPath.getAbsolutePath() + apendPath);
                fis = new FileInputStream(fileToBeCopied);
                byte[] buffer = new byte[1024];
                for (int length = 0; (length = fis.read(buffer)) != -1;) {
                    writer.write(buffer, 0, length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ta.append("Copy file [" + srcAbsolutePath + "] to [" + outputDir.getAbsolutePath() + "] done!\n");
            ta.paintImmediately(ta.getBounds());
        }
    }
}
