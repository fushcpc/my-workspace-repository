package com.j2se.vedio.itcast.jdbc.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Class.forName("oracle.jdbc.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin::1521:orcl", "scott", "tiger");
        // Connection conn =
        // DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
        // "scott", "tiger");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from emp");
        while (rs.next()) {
            System.out.println(rs.getObject(1) + "\t" + rs.getObject(2) + "\t" + rs.getObject(3));
        }
        rs.close();
        st.close();
        conn.close();
    }
}
