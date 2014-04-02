package com.j2se.vedio.itcast.jdbc.second;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.j2se.vedio.itcast.jdbc.JDBCUtils;

public class BigFileTest {
    public static void main(String[] args) throws Exception {
        // write();
        readBlob();
    }

    @SuppressWarnings("unused")
    private static void writeBlob() throws SQLException, FileNotFoundException {
        PreparedStatement ps = JDBCUtils.getPreparedStatement("insert into cx_blob values(?)");
        ps.setBinaryStream(1, new FileInputStream(new File("F:\\Photo\\20090528173054730.jpg")));
        ps.execute();
        JDBCUtils.closeAll(ps);
    }

    private static void readBlob() throws SQLException, IOException {
        Statement st = JDBCUtils.getStatement();
        ResultSet rs = st.executeQuery("select * from cx_blob");
        while (rs.next()) {
            InputStream is = rs.getBinaryStream(1);
            OutputStream os = new FileOutputStream(new File("C:\\laughing.jpg"));
            byte[] buffer = new byte[1024];
            for (int len = 0; (len = is.read(buffer)) > 0;) {
                os.write(buffer, 0, len);
            }
            os.close();
            is.close();
        }
        JDBCUtils.classAll(rs, st);
    }

    @SuppressWarnings("unused")
    private static void writeClob() throws Exception {
        PreparedStatement ps = JDBCUtils.getPreparedStatement("insert into cx_clob values(?,?)");
        ps.setInt(1, 1);
        ps.setCharacterStream(2, new BufferedReader(new FileReader(new File("src\\com\\j2se\\vedio\\itcast\\jdbc\\first\\Base.java"))));
        ps.execute();
        JDBCUtils.closeAll(ps);
    }

    @SuppressWarnings("unused")
    private static void readClob() throws SQLException, IOException {
        Statement st = JDBCUtils.getStatement();
        ResultSet rs = st.executeQuery("select * from cx_clob");
        while (rs.next()) {
            BufferedReader reader = new BufferedReader(rs.getCharacterStream(2));
            // BufferedReader anotherReader = new
            // BufferedReader(rs.getClob(2).getCharacterStream());
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }
        }
        JDBCUtils.classAll(rs, st);
    }
}
