package com.j2se.vedio.shenshiyuan.project.chat.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import com.j2se.vedio.shenshiyuan.project.chat.domain.Server;

public class ServerInputThread implements Runnable {
    private InputStream input;
    private Server      server;

    public ServerInputThread(Socket socket, Server server) throws Exception {
        this.input = socket.getInputStream();
        this.server = server;
    }

    @Override
    public void run() {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            try {
                StringBuilder msgBuilder = new StringBuilder(200);
                for (String line = reader.readLine(); line != null;) {
                    msgBuilder.append(line).append("\r\n");
                }
                for (Socket socket : server.getSocketList()) {
                    OutputStream out = socket.getOutputStream();
                    out.write(msgBuilder.toString().getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
