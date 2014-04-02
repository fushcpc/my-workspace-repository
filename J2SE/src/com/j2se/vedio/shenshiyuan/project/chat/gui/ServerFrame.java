package com.j2se.vedio.shenshiyuan.project.chat.gui;

import javax.swing.JOptionPane;

import com.david.swing.utility.StringUtility;
import com.david.swing.utility.SwingUtility;
import com.j2se.vedio.shenshiyuan.project.chat.domain.Server;
import com.j2se.vedio.shenshiyuan.project.chat.service.ServerService;

public class ServerFrame extends javax.swing.JFrame {
    private Server server;

    public ServerFrame(Server server) {
        initComponents();
        this.server = server;
        setupTestData();
    }

    private void setupTestData() {
        serverPortTxf.setText("20000");
    }

    public javax.swing.JLabel getServerStatusLable() {
        return serverStatusLable;
    }

    public javax.swing.JButton getServerBtn() {
        return serverBtn;
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        serverStatusLable = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        serverPortTxf = new javax.swing.JTextField();
        serverBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTxa = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("服务器");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "服务器信息", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("微软雅黑", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jLabel1.setText("服务器状态");

        serverStatusLable.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        serverStatusLable.setText("未启动");
        serverStatusLable.setName("serverStatusLable");

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jLabel3.setText("端口号");

        serverPortTxf.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        serverPortTxf.setName("serverIpTxf");
        serverPortTxf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverIpTxfActionPerformed(evt);
            }
        });

        serverBtn.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        serverBtn.setText("启动服务器");
        serverBtn.setName("serverBtn");
        serverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        jPanel1Layout.createSequentialGroup().addGap(41, 41, 41).addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(serverStatusLable).addGap(95, 95, 95))
                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(
                        jPanel1Layout.createSequentialGroup().addGap(43, 43, 43).addComponent(jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(serverPortTxf, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
                                .addComponent(serverBtn).addContainerGap(35, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel1Layout
                        .createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(serverStatusLable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(
                                jPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(serverPortTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(serverBtn)).addContainerGap(36, Short.MAX_VALUE)));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "在线用户列表", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("微软雅黑", 0, 12))); // NOI18N

        usersTxa.setName("usersTxa");
        jScrollPane1.setViewportView(usersTxa);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel2Layout.createSequentialGroup().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE).addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(22, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup().addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));

        pack();
        setResizable(false);
        SwingUtility.setInCenterCorner(this);
    }// </editor-fold>

    private void serverIpTxfActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void serverBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String port = this.serverPortTxf.getText().trim();
        if (!StringUtility.isDigits(port)) {
            JOptionPane.showMessageDialog(this, "端口必须为数字！");
            return;
        }
        try {
            ServerService.startServer(Integer.parseInt(port), server);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private javax.swing.JLabel      jLabel1;
    private javax.swing.JLabel      jLabel3;
    private javax.swing.JPanel      jPanel1;
    private javax.swing.JPanel      jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator  jSeparator1;
    private javax.swing.JButton     serverBtn;
    private javax.swing.JTextField  serverPortTxf;
    private javax.swing.JLabel      serverStatusLable;
    private javax.swing.JList       usersTxa;
    // End of variables declaration
}
