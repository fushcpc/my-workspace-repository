package com.j2se.vedio.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER_NAME = "scott";
    private static final String PASSWORD = "tiger";
    private static Connection conn;

    static {
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private JDBCUtils() {
    }

    public static Connection getConnection() {
        return conn;
    }

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    public static Statement getStatement() throws SQLException {
        return conn.createStatement();
    }

    public static void closeAll(Statement statement) throws SQLException {
        try {
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    public static void classAll(ResultSet rs, Statement st) throws SQLException {
        try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(st);
        }
    }
}
