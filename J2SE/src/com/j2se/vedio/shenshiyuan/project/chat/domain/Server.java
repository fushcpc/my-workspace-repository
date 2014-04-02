package com.j2se.vedio.shenshiyuan.project.chat.domain;

import java.awt.EventQueue;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.david.swing.utility.SwingUtility;
import com.j2se.vedio.shenshiyuan.project.chat.gui.ServerFrame;

public class Server {
    private List<Socket> socketList = new ArrayList<Socket>();
    private ServerFrame  frame      = new ServerFrame(this);

    public ServerFrame getFrame() {
        return frame;
    }

    public void setFrame(ServerFrame frame) {
        this.frame = frame;
    }

    public List<Socket> getSocketList() {
        return socketList;
    }

    public void setSocketList(List<Socket> socketList) {
        this.socketList = socketList;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingUtility.setSubstanceOfficeBlue2007LookAndFeel();
                new Server().getFrame().setVisible(true);
            }
        });
    }
}
