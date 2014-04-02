package com.david.swing;

import java.awt.Toolkit;

public final class SwingConstant {
    private SwingConstant(){
        
    }
    
    public static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;

}
