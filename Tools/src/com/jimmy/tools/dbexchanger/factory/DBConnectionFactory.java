package com.jimmy.tools.dbexchanger.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.jimmy.tools.dbexchanger.dbtype.DBType;

public class DBConnectionFactory {
    private final static String ORACLE_USERNAME = "forum";
    private final static String ORACLE_PASSWORD = "forum";
    private final static String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private final static String ORACLE_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";

    private final static String SQLSERVER_USERNAME = "sa";
    private final static String SQLSERVER_PASSWORD = "sa";
    // private final static String SQLSERVER_URL =
    // "jdbc:sqlserver://LENOVO-282D43B3\\SQLEXPRESS;databaseName=forum";
    private final static String SQLSERVER_URL = "jdbc:sqlserver://WIN-EQIR2DGDDU2\\SQLEXPRESS;databaseName=forum";
    private final static String SQLSERVER_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private static Map<DBType, Connection> connMap = new HashMap<DBType, Connection>();

    private DBConnectionFactory() {
    }

    public static Connection getConnection(DBType type) {
        if (connMap.containsKey(type)) {
            return connMap.get(type);
        }
        Connection conn = null;
        if (DBType.ORACLE.equals(type)) {
            conn = buildConn(ORACLE_DRIVER_CLASS, ORACLE_USERNAME, ORACLE_PASSWORD, ORACLE_URL);
        } else if (DBType.SQL_SERVER.equals(type)) {
            conn = buildConn(SQLSERVER_DRIVER_CLASS, SQLSERVER_USERNAME, SQLSERVER_PASSWORD, SQLSERVER_URL);
        }
        connMap.put(type, conn);
        return conn;
    }

    public static Connection buildConn(String driverClassName, String username, String password, String url) {
        try {
            Class.forName(driverClassName);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
