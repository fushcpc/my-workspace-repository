package com.happycoding.utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.forum.bean.Topic;


/**
 * @author DavidChen(陈基明) Email: cjmiou@gmail.com
 * @version 2010-5-5  下午04:33:41
 */
public class CreatTable {
	public static void main(String[] args) {
		Configuration conf = new Configuration().configure();
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
//		Transaction ts = session.beginTransaction();
//		
//		Topic topic = new Topic();
//		topic.setSubject("hello");
//		
//		session.save(topic);
//		ts.commit();
//		session.close();
	}
}
