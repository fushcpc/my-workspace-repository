package com.j2se.book.crazyseries.project.calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.david.swing.InitFrame;
import com.david.swing.MyFrameType;

public class CalculatorFrame extends InitFrame {
    private final static int        FRAME_WIDTH  = 400;
    private final static int        FRAME_HEIGHT = 300;
    private final static String     TITLE_NAME   = "Calculator";

    private final static CalService service      = new CalService();

    private final JTextField        textField    = new JTextField();

    private final String[]          saveOp       = new String[] { "MC", "MR", "MS", "M+" };

    private final String[]          resultOp     = new String[] { "Back", "CE", "C" };

    private final String[]          nOp          = { "7", "8", "9", "/", "sqrt", "4", "5", "6", "*", "%", "1", "2", "3", "-", "1/x", "0", "+/-", ".", "+", "=" };

    public CalculatorFrame() {
        super(FRAME_WIDTH, FRAME_HEIGHT, MyFrameType.CENTER);
        this.setTitle(TITLE_NAME);
        this.setLayout(new BorderLayout());
        this.add(getTextField(), BorderLayout.NORTH);
        this.add(getSavePanel(), BorderLayout.WEST);
        this.add(getMainPanel(), BorderLayout.CENTER);
        this.pack();
    }

    private Component getTextField() {
        textField.setEditable(Boolean.FALSE);
        textField.setBackground(Color.WHITE);
        return textField;
    }

    private JPanel getSavePanel() {
        JPanel operPanel = new JPanel();
        // use Grid layout to set the components keep vertical
        operPanel.setLayout(new GridLayout(4, 1, 5, 5));
        for (String op : saveOp) {
            JButton btn = new JButton(op);
            btn.addActionListener(getActionListener());
            operPanel.add(btn);
        }
        return operPanel;
    }

    private JPanel getResultPanel() {
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(1, 3, 10, 10));
        for (String op : resultOp) {
            JButton btn = new JButton(op);
            btn.addActionListener(getActionListener());
            resultPanel.add(btn);
        }
        return resultPanel;
    }

    private JPanel getNPanel() {
        JPanel nPanel = new JPanel();
        nPanel.setLayout(new GridLayout(4, 5, 10, 10));
        for (String op : nOp) {
            JButton btn = new JButton(op);
            btn.addActionListener(getActionListener());
            nPanel.add(btn);
        }
        return nPanel;
    }

    private JPanel getMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(getResultPanel(), BorderLayout.NORTH);
        mainPanel.add(getNPanel(), BorderLayout.CENTER);
        return mainPanel;
    }

    public ActionListener getActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                String result = service.calMethod(cmd, textField.getText());
                textField.setText(result);
            }
        };
    }
}
