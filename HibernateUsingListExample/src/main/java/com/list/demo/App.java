package com.list.demo;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("java is a programming language");
		list1.add("java is a platform");

		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("servlet is a intetface");
		list2.add("servlet is a Api");

		Question question1 = new Question();
		question1.setName("what is a java");
		question1.setAnswer(list1);

		Question question2 = new Question();
		question2.setName("what is a servlet");
		question2.setAnswer(list2);

		Serializable save = session.save(question1);
		System.out.println(save);

		Serializable save2 = session.save(question2);
		System.out.println(save2);

		transaction.commit();

		System.out.println("Hello World!");

		session.close();
		factory.close();
	}
}
