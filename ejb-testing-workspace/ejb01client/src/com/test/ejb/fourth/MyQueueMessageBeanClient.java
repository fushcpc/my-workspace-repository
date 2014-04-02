package com.test.ejb.fourth;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyQueueMessageBeanClient {
    public static void main(String[] args) throws NamingException, JMSException {
        for (int i = 0; i < 100; i++) {
            sendMsg();
        }

    }

    private static void sendMsg() throws NamingException, JMSException {
        InitialContext cxt = new InitialContext();
        QueueConnectionFactory factory = (QueueConnectionFactory) cxt.lookup("ConnectionFactory");
        QueueConnection conn = factory.createQueueConnection();
        QueueSession session = conn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);

        Queue queue = (Queue) cxt.lookup("queue/myqueue");

        TextMessage textMsg = session.createTextMessage("Here is the message from client!");

        QueueSender sender = session.createSender(queue);

        sender.send(textMsg);

        session.close();
        conn.close();
        System.out.println("Message send successfully from client!");
    }

}
