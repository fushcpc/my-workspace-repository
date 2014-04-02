package com.j2se.vedio.shenshiyuan.project.chat.thread;

import java.io.OutputStream;

import com.j2se.vedio.shenshiyuan.project.chat.domain.Client;

@SuppressWarnings("unused")
public class ClientOutputThread implements Runnable {
    private Client       client;
    private OutputStream out;

    public ClientOutputThread(Client client, OutputStream out) {
        this.client = client;
        this.out = out;
    }

    @Override
    public void run() {
        while (true) {

        }
    }
}
