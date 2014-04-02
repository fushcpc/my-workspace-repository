package com.test.ejb.fourth;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyTopicMessageBeanClient {
    public static void main(String[] args) throws NamingException, JMSException {
        for (int i = 0; i < 10; i++) {
            sendMsg();
        }
    }

    private static void sendMsg() throws NamingException, JMSException {
        InitialContext cxt = new InitialContext();
        TopicConnectionFactory factory = (TopicConnectionFactory) cxt.lookup("ConnectionFactory");
        TopicConnection conn = factory.createTopicConnection();
        TopicSession session = conn.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);

        Topic topic = (Topic) cxt.lookup("topic/mytopic");

        TextMessage txtMsg = session.createTextMessage("Text msg from topic client!");

        TopicPublisher publisher = session.createPublisher(topic);

        publisher.publish(txtMsg);

        session.close();
        conn.close();

    }

}
