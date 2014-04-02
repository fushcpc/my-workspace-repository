package com.jimmy.tools.dbexchanger.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.jimmy.tools.dbexchanger.dbtype.DBType;
import com.jimmy.tools.dbexchanger.factory.DBConnectionFactory;

public class ExchangeHelper {

    public static void exchange(List<String> fromTables, Map<String, String> tableNameMap, DBType fromDB, DBType toDB) {

        for (String fromTable : fromTables) {
            String toTable = tableNameMap.get(fromTable);
            exchange(fromTable, toTable, fromDB, toDB);
        }
    }

    private static void exchange(String fromTable, String toTable, DBType fromDB, DBType toDB) {
        Connection fromConn = DBConnectionFactory.getConnection(fromDB);
        Connection toConn = DBConnectionFactory.buildConn("oracle.jdbc.driver.OracleDriver", "forum", "forum", "jdbc:oracle:thin:@192.168.1.101:1521:orcl");
        try {
            ResultSet rs = getTableResultSet(fromTable, fromConn);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            StringBuffer insertSql = new StringBuffer();
            insertSql.append("insert into ").append(toTable).append(" values(");
            for (int i = 0; i < columnCount; i++) {
                insertSql.append("?,");
            }
            insertSql.deleteCharAt(insertSql.lastIndexOf(","));
            insertSql.append(")");
            String sql = insertSql.toString();
            System.out.println(sql);
            while (rs.next()) {
                Object[] objs = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    objs[i] = rs.getObject(i + 1);
                }
                executeUpdate(sql, objs, toConn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ResultSet getTableResultSet(String tableName, Connection conn) {
        String sql = "select * from " + tableName;
        System.out.println(sql);
        return executeQuery(sql, conn);
    }

    private static ResultSet executeQuery(String sql, Connection conn) {
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private static void executeUpdate(String sql, Object[] objs, Connection conn) {
        System.out.println(sql);
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                pst.setObject(i + 1, objs[i]);
            }
            int i = pst.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
