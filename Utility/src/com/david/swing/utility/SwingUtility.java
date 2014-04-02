package com.david.swing.utility;

import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Enumeration;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class SwingUtility {
    public static final Toolkit toolkit = Toolkit.getDefaultToolkit();
    public static final int     SCREEN_WIDTH;
    public static final int     SCREEN_HEIGHT;

    static {
        SCREEN_WIDTH = (int) (toolkit.getScreenSize().getWidth());
        SCREEN_HEIGHT = (int) (toolkit.getScreenSize().getHeight());
    }

    public static Point getCenterPoint(int parentWidth, int componentWidth, int parentHeight, int componentHeight) {
        int x = (parentWidth - componentWidth) / 2;
        int y = parentHeight - componentHeight;
        return new Point(x, y);
    }

    public static void setSubstanceOfficeBlue2007LookAndFeel() {
        try {
            UIManager.setLookAndFeel(new org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel());
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            initGlobalFontSetting(new Font("微软雅黑", Font.PLAIN, 12));
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger("ClassName").log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void setSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            java.util.logging.Logger.getLogger("ClassName").log(java.util.logging.Level.SEVERE, null, e);
        }
    }

    public static void initGlobalFontForMSYH() {
        initGlobalFontSetting(new Font("微软雅黑", Font.PLAIN, 12));
    }

    public static void initGlobalFontSetting(Font fnt) {
        FontUIResource fontRes = new FontUIResource(fnt);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource)
                UIManager.put(key, fontRes);
        }
    }

    public static void setDefaultBehavior(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * this method must be called after pack() method, as the pack() method
     * hasn't been called, the frame height and frame width will be 0s
     * 
     * @param frame
     */
    public static void setInCenterCorner(JFrame frame) {
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();
        Point point = new Point((SCREEN_WIDTH - frameWidth) / 2, (SCREEN_HEIGHT - frameHeight) / 2);
        frame.setLocation(point);
    }
}
