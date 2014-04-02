package com.j2se.vedio.itcast.jdbc.first;

public class JDBCUtilSingle {
    private static JDBCUtilSingle INSTANCE;

    private JDBCUtilSingle() {
    }

    public static JDBCUtilSingle getInstance() {
        if (INSTANCE == null) {
            synchronized (JDBCUtilSingle.class) {
                if (INSTANCE == null) {// 双重检查
                    INSTANCE = new JDBCUtilSingle();
                }
            }
        }
        return INSTANCE;
    }
}
