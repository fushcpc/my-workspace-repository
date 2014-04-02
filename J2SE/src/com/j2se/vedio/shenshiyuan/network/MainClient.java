package com.j2se.vedio.shenshiyuan.network;

import java.net.Socket;

public class MainClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 4000);
        new ClientInputThread(socket).start();
        new ClientOutputThread(socket).start();
    }
}
