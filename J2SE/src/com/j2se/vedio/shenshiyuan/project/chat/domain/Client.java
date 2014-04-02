package com.j2se.vedio.shenshiyuan.project.chat.domain;

import java.awt.EventQueue;
import java.net.Socket;

import com.david.swing.utility.SwingUtility;
import com.j2se.vedio.shenshiyuan.project.chat.gui.ChatFrame;
import com.j2se.vedio.shenshiyuan.project.chat.gui.LoginFrame;

public class Client {
    private LoginFrame loginFrame = new LoginFrame(this);
    private ChatFrame  chatFrame  = new ChatFrame(this);
    private Socket     socket;
    private String     name;

    public LoginFrame getLoginFrame() {
        return loginFrame;
    }

    public void setLoginFrame(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
    }

    public ChatFrame getChatFrame() {
        return chatFrame;
    }

    public void setChatFrame(ChatFrame chatFrame) {
        this.chatFrame = chatFrame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingUtility.setSubstanceOfficeBlue2007LookAndFeel();
                new Client().getLoginFrame().setVisible(true);
            }
        });
    }
}
