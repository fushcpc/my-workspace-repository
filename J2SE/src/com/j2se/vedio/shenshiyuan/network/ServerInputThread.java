package com.j2se.vedio.shenshiyuan.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerInputThread extends Thread {
    private Socket socket;

    public ServerInputThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            while (true) {
                byte[] buffer = new byte[1024];
                int length = input.read(buffer);
                System.out.println(new String(buffer, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
