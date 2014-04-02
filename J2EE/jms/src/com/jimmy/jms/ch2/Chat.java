package com.jimmy.jms.ch2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;

public class Chat implements MessageListener {
    private TopicSession pubSession;
    private TopicPublisher publisher;
    private TopicConnection connection;
    private String username;

    public Chat(String topicFactory, String topicName, String username) throws Exception {
        InitialContext ctx = new InitialContext();
        TopicConnectionFactory conFactory = (TopicConnectionFactory) ctx.lookup(topicFactory);
        connection = conFactory.createTopicConnection();
        pubSession = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        TopicSession subSession = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic chatTopic = (Topic) ctx.lookup(topicName);
        publisher = pubSession.createPublisher(chatTopic);
        TopicSubscriber subScriber = subSession.createSubscriber(chatTopic, null, true);
        subScriber.setMessageListener(this);
        this.username = username;
        connection.start();
    }

    @Override
    public void onMessage(Message msg) {
        TextMessage txtMsg = (TextMessage) msg;
        try {
            System.out.println(txtMsg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println("Factory, Topic, or username missing");
        }
        Chat chat = new Chat(args[0], args[1], args[2]);
        BufferedReader commandLine = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = commandLine.readLine();
            if ("exist".equalsIgnoreCase(s)) {
                chat.close();
                System.exit(0);
            } else {
                chat.writeMessage(s);
            }
        }
    }

    private void close() throws JMSException {
        connection.close();
    }

    private void writeMessage(String s) throws JMSException {
        TextMessage msg = pubSession.createTextMessage();
        msg.setText(username + ":" + s);
        publisher.publish(msg);
    }
}
