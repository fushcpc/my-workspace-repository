package com.j2se.vedio.shenshiyuan.project.chat.service;

import java.net.ServerSocket;
import java.net.Socket;

import com.j2se.vedio.shenshiyuan.project.chat.domain.Server;
import com.j2se.vedio.shenshiyuan.project.chat.gui.ServerFrame;
import com.j2se.vedio.shenshiyuan.project.chat.thread.ServerInputThread;

public class ServerService {

    public static void startServer(int port, Server server) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        new Thread(new ServerInputThread(socket, server)).start();
        server.getSocketList().add(socket);
        ServerService.updateServerStatus(server.getFrame(), "Server is running");
        server.getFrame().getServerBtn().setText("停止服务器");
    }

    public static void updateServerStatus(ServerFrame frame, String newStatus) {
        frame.getServerStatusLable().setText(newStatus);
    }
}
