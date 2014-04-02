package com.j2se.book.crazyseries.project.photoviewer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

import com.david.swing.InitFrame;
import com.david.swing.MyFrameType;
import com.david.swing.utility.CollectionUtility;
import com.j2se.book.crazyseries.project.photoviewer.action.ViewAction;

public class ViewerFrame extends InitFrame {
    private final static int          WIDTH                   = 1000;
    private final static int          HEIGHT                  = 700;

    private final static String       TITLE                   = "Photo Viewer";

    private final static String       MENU_FILE               = "文件(F)";
    public final static String        MENU_ITEM_FILE_OPEN     = "打开(O)";
    public final static String        MENU_ITEM_FILE_EXIST    = "退出(X)";
    private final static String       MENU_TOOL               = "工具(T)";
    public final static String        MENU_ITEM_TOOL_ZOOM_OUT = "放大(M)";
    public final static String        MENU_ITEM_TOOL_ZOOM_IN  = "缩小(O)";
    public final static String        MENU_ITEM_TOOL_PREV     = "上一个(X)";
    public final static String        MENU_ITEM_TOOL_NEXT     = "下一个(P)";
    public final static String        MENU_ITEM_TOOL_DELETE   = "删除(D)";
    private final static String       MENU_HELP               = "帮助(H)";
    private final static String       MENU_ITEM_HELP_MANUAL   = "帮助主题";
    private final static String       MENU_ITEM_HELP_ABOUT    = "关于";

    private final static String       IMG_ROOT_PATH           = "Images/PhotoViewer/";                                                                                              // TODO:mark.
                                                                                                                                                                                     // can
                                                                                                                                                                                     // not
                                                                                                                                                                                     // be
                                                                                                                                                                                     // like
                                                                                                                                                                                     // "/Images/...."

    private final static String       FILE_FILTER_DESC        = "Only image type";

    private final JLabel              photoLabel              = new JLabel();

    private int                       CURRENT_FILE_INDEX      = -1;

    private final static String[]     MENU_ARRAY              = new String[] { MENU_FILE, MENU_TOOL, MENU_HELP };
    private final static String[][]   MENU_ITEM_ARRAY         = new String[][] { { MENU_ITEM_FILE_OPEN, MENU_ITEM_FILE_EXIST },
            { MENU_ITEM_TOOL_ZOOM_OUT, MENU_ITEM_TOOL_ZOOM_IN, MENU_ITEM_TOOL_PREV, MENU_ITEM_TOOL_NEXT, MENU_ITEM_TOOL_DELETE }, { MENU_ITEM_HELP_MANUAL, MENU_ITEM_HELP_ABOUT } };

    private final static String[]     TOOL_BAR_ARRAY          = new String[] { MENU_ITEM_FILE_OPEN, MENU_ITEM_TOOL_ZOOM_OUT, MENU_ITEM_TOOL_ZOOM_IN, MENU_ITEM_TOOL_PREV,
            MENU_ITEM_TOOL_NEXT, MENU_ITEM_TOOL_DELETE       };

    private final static List<String> ALLOW_IMAGE_TYPE;

    private File                      currentFile;
    private File                      currentDir;
    private List<File>                currenFiles             = new ArrayList<File>();

    static {
        List<String> list = new ArrayList<String>();
        list.add(".jpg");
        list.add(".bmp");
        list.add(".gif");
        list.add(".png");
        list.add(".ico");
        list.add(".tif");
        ALLOW_IMAGE_TYPE = Collections.unmodifiableList(list);
    }

    public ViewerFrame() {
        super(WIDTH, HEIGHT, MyFrameType.CENTER);
        this.setJMenuBar(createJMenuBar());
        this.setLayout(new BorderLayout());
        this.add(getToolPanel(), BorderLayout.NORTH);
        this.add(getPhotoPanel(), BorderLayout.CENTER);
        this.setResizable(Boolean.TRUE);
        this.setTitle("Photo Viewer");
        this.pack();
    }

    private JPanel getToolPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT)); // TODO: MARK
        JToolBar toolBar = new JToolBar();
        for (int i = 0; i < TOOL_BAR_ARRAY.length; i++) {
            toolBar.add(new JButton(getViewAction(TOOL_BAR_ARRAY[i], IMG_ROOT_PATH + (i + 1) + ".gif")));
        }
        toolBar.setFloatable(Boolean.FALSE);
        panel.add(toolBar);
        return panel;
    }

    private JScrollPane getPhotoPanel() {
        JScrollPane panel = new JScrollPane(photoLabel); // TODO:mark
        return panel;
    }

    private JMenuBar createJMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        for (int i = 0; i < MENU_ARRAY.length; i++) {
            JMenu menu = new JMenu(MENU_ARRAY[i]);
            for (int j = 0; j < MENU_ITEM_ARRAY[i].length; j++) {
                JMenuItem item = new JMenuItem(getViewAction(MENU_ITEM_ARRAY[i][j]));
                menu.add(item);
            }
            menuBar.add(menu);
        }
        return menuBar;
    }

    private ViewAction getViewAction(String name) {
        return new ViewAction(name, this);
    }

    private ViewAction getViewAction(String name, String iconPath) {
        Icon icon = new ImageIcon(iconPath);
        return new ViewAction(name, icon, this);
    }

    public JFileChooser getFileChooser() {
        JFileChooser fChooser = new JFileChooser();
        fChooser.setFileFilter(new FileFilter() {

            @Override
            public String getDescription() {
                return FILE_FILTER_DESC;
            }

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return Boolean.FALSE;
                }
                String filename = f.getName().toLowerCase();
                for (String imgType : ALLOW_IMAGE_TYPE) {
                    if (filename.endsWith(imgType)) {
                        return Boolean.TRUE;
                    }
                }
                return Boolean.FALSE;
            }
        });
        return fChooser;
    }

    public File getCurrentFile() {
        if (CollectionUtility.isNullOrEmpty(getCurrenFiles())) {
            return null;
        }
        return getCurrenFiles().get(CURRENT_FILE_INDEX);
    }

    // public void setCurrentFile(File currentFile) {
    // this.currentFile = currentFile;
    // }

    public File getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(File currentDir) {
        this.currentDir = currentDir;
    }

    public List<File> getCurrenFiles() {
        return currenFiles;
    }

    public void setCurrenFiles(List<File> currenFiles) {
        this.currenFiles = currenFiles;
    }

    public JLabel getPhotoLabel() {
        return photoLabel;
    }

    public File getNextFile() {
        if (CURRENT_FILE_INDEX + 1 >= currenFiles.size()) {
            return getCurrentFile();
        }
        CURRENT_FILE_INDEX = CURRENT_FILE_INDEX + 1;
        currentFile = currenFiles.get(CURRENT_FILE_INDEX);
        return currentFile;
    }

    public File getPrevFile() {
        if (CURRENT_FILE_INDEX - 1 < 0) {
            return getCurrentFile();
        }
        CURRENT_FILE_INDEX = CURRENT_FILE_INDEX - 1;
        currentFile = currenFiles.get(CURRENT_FILE_INDEX);
        return currentFile;
    }

    public void setCurrentFileIndex(int index) {
        CURRENT_FILE_INDEX = index;
    }

    public void resetPhoto(File photoFile) {
        if (photoFile == null) {
            getPhotoLabel().setIcon(null);
            return;
        }
        ImageIcon photoIcon = new ImageIcon(photoFile.getPath());
        resetTitle(photoFile.getName());
        getPhotoLabel().setIcon(photoIcon);
    }

    private void resetTitle(String filename) {
        this.setTitle(TITLE + "  (" + filename + ")");
    }

    public int getCurrentFileIndex() {
        return CURRENT_FILE_INDEX;
    }

}
