package com.j2se.vedio.shenshiyuan.project.chat.service;

import java.net.Socket;

import com.j2se.vedio.shenshiyuan.project.chat.domain.Client;

public class ClientService {

    public static void startClient(String usernameStr, Client client, Socket socket) {
        client.setName(usernameStr);
        client.setSocket(socket);
        // client.getChatFrame().get
        client.getLoginFrame().setVisible(false);
        client.getChatFrame().setVisible(true);
    }
}
