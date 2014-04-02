package com.jimmy.tools.filetransporter;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PathPanel extends JPanel {
    private JTextField srcPathField;

    public PathPanel(String label, String btnLabel, ActionListener listener) {
        srcPathField = new JTextField(40);
        this.add(new JLabel(label));
        srcPathField.setEditable(false);
        this.add(srcPathField);
        JButton srcPathChooserBtn = new JButton(btnLabel);
        srcPathChooserBtn.addActionListener(listener);
        this.add(srcPathChooserBtn);
    }

    public JTextField getSrcPathField() {
        return srcPathField;
    }

    public void setSrcPathField(JTextField srcPathField) {
        this.srcPathField = srcPathField;
    }

}
