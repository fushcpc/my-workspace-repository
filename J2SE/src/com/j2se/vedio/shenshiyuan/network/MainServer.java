package com.j2se.vedio.shenshiyuan.network;

import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4000);
        while (true) {
            Socket socket = server.accept();
            new ServerInputThread(socket).start();
            new ServerOutputThread(socket).start();
        }
    }
}
