package com.j2se.vedio.shenshiyuan.project.chat.gui;

import java.net.Socket;

import javax.swing.JOptionPane;

import com.david.swing.utility.StringUtility;
import com.david.swing.utility.SwingUtility;
import com.j2se.vedio.shenshiyuan.project.chat.domain.Client;
import com.j2se.vedio.shenshiyuan.project.chat.service.ClientService;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 * @author Administrator
 */
public class LoginFrame extends javax.swing.JFrame {
    private Client client;

    public LoginFrame(Client client) {
        initComponents();
        this.client = client;
        setupTestData();
    }

    private void setupTestData() {
        userName.setText("david");
        portTxf.setText("20000");
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        IpTxf = new javax.swing.JTextField();
        portTxf = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("用户登陆");
        setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "用户登陆", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("微软雅黑", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jLabel1.setText("用户名");

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jLabel2.setText("服务器地址");

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jLabel3.setText("端口号");

        userName.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        userName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        userName.setName("userName");

        IpTxf.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        IpTxf.setText("127.0.0.1");

        portTxf.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        portTxf.setName("portTxf");

        loginBtn.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        loginBtn.setText("登陆");
        loginBtn.setName("loginBtn");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        resetBtn.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        resetBtn.setText("重置");
        resetBtn.setName("resetBtn");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel1Layout
                        .createSequentialGroup()
                        .addGroup(
                                jPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(
                                                jPanel1Layout
                                                        .createSequentialGroup()
                                                        .addGap(24, 24, 24)
                                                        .addGroup(
                                                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1)
                                                                        .addComponent(jLabel2).addComponent(jLabel3))
                                                        .addGap(50, 50, 50)
                                                        .addGroup(
                                                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(IpTxf, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE).addComponent(userName)
                                                                        .addComponent(portTxf)))
                                        .addGroup(jPanel1Layout.createSequentialGroup().addGap(50, 50, 50).addComponent(loginBtn).addGap(76, 76, 76).addComponent(resetBtn)))
                        .addContainerGap(40, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        jPanel1Layout
                                .createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(
                                        jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(IpTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(
                                        jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel3)
                                                .addComponent(portTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(loginBtn).addComponent(resetBtn))
                                .addContainerGap(20, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup().addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup().addGap(25, 25, 25)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(39, Short.MAX_VALUE)));

        pack();
        setResizable(false);
        SwingUtility.setInCenterCorner(this);
    }// </editor-fold>

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.userName.setText("");
        this.IpTxf.setText("");
        this.portTxf.setText("");
    }

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String host = IpTxf.getText();
        String portStr = portTxf.getText();
        if (!StringUtility.isIpPattern(host)) {
            JOptionPane.showMessageDialog(this, "IP格式不对！", "IP格式不对", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!StringUtility.isDigits(portStr)) {
            JOptionPane.showMessageDialog(this, "端口必须为数字！", "端口必须为数字", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String usernameStr = userName.getText();
        if (StringUtility.isNullOrEmpty(usernameStr)) {
            JOptionPane.showMessageDialog(this, "请先填入用户名！", "请先填入用户名", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int port = Integer.parseInt(portStr);
        try {
            Socket socket = new Socket(host, port);
            ClientService.startClient(usernameStr, client, socket);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "未知的主机和端口，请检查你的输入！", "未知的主机和端口", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private javax.swing.JTextField IpTxf;
    private javax.swing.JLabel     jLabel1;
    private javax.swing.JLabel     jLabel2;
    private javax.swing.JLabel     jLabel3;
    private javax.swing.JPanel     jPanel1;
    private javax.swing.JButton    loginBtn;
    private javax.swing.JTextField portTxf;
    private javax.swing.JButton    resetBtn;
    private javax.swing.JTextField userName;
    // End of variables declaration
}
