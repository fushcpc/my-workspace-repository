package com.david.swing.utility;

import java.io.File;

public final class IOUtility {
    private IOUtility() {
    }

    public static String getFileExtention(File file) {
        if (file.isDirectory()) {
            return Constants.EMPTY_STRING;
        }
        return getFileExtention(file.getName());
    }

    public static String getFileExtention(String filename) {
        if (StringUtility.isNullOrEmpty(filename) || !filename.contains(Constants.DOT)) {
            return Constants.EMPTY_STRING;
        }
        int dotIndex = filename.lastIndexOf(Constants.DOT);
        return filename.substring(dotIndex);
    }
}
