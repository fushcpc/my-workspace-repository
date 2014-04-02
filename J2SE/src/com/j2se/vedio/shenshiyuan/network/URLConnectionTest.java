package com.j2se.vedio.shenshiyuan.network;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class URLConnectionTest {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.qq.com");
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream("c:\\qq.html");
        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = is.read(buffer, 0, buffer.length)) != -1) {
            os.write(buffer, 0, length);
        }
        is.close();
        os.close();
    }
}
