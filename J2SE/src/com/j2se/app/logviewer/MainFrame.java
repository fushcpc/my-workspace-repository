package com.j2se.app.logviewer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.david.swing.utility.SwingUtility;

public class MainFrame extends JFrame {
    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;
    private static final int ROW = 30;
    private static final int COLUMN = 20;
    protected static final String DEFAULT_LOG_DIR = "C:\\";

    private JButton openFileBtn;
    private JTextArea logArea;
    private String logFilePath;

    public MainFrame() {
        this.setLayout(new BorderLayout());
        this.setSize(WIDTH, HEIGHT);
        SwingUtility.setInCenterCorner(this);
        SwingUtility.initGlobalFontForMSYH();
        this.setTitle("Log Viewer V0.1  By 大块头");
        JToolBar toolBar = new JToolBar("Tool Bar", JToolBar.HORIZONTAL);
        openFileBtn = new JButton("Open");
        toolBar.add(openFileBtn);
        this.add(toolBar, BorderLayout.NORTH);
        logArea = new JTextArea(ROW, COLUMN);
        JScrollPane areaScrollPane = new JScrollPane(logArea);
        this.add(areaScrollPane);
        initListener();
        SwingUtility.setSystemLookAndFeel();
        SwingUtility.setDefaultBehavior(this);
    }

    private void initListener() {
        initOpenButton();
    }

    private void initOpenButton() {
        openFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = getFileChooser();
                if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(null)) {
                    logFilePath = fileChooser.getSelectedFile().getPath();
                    try {
                        showLog(logFilePath);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "Exception thrown when reade log file!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private void showLog(String logFilePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(logFilePath));
        StringBuilder logBuilder = new StringBuilder();
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            logBuilder.append(line).append("\n");
        }
        this.logArea.setText(logBuilder.toString());
    }

    private JFileChooser getFileChooser() {
        JFileChooser fileChooser = new JFileChooser(DEFAULT_LOG_DIR);
        fileChooser.setFileFilter(new FileNameExtensionFilter("log file", "txt", "log"));
        return fileChooser;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
