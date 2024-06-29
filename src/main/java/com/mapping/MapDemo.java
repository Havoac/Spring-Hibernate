package com.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Question q1 = new Question();
		q1.setQuestionId(1);
		q1.setQuestion("What is Java");

		Answer ans1 = new Answer();
		ans1.setAnswerId(11);
		ans1.setAnswer("Java is a programming language");
		ans1.setQ(q1);

		Answer ans2 = new Answer();
		ans2.setAnswerId(111);
		ans2.setAnswer("with help of java we can learn spring");
		ans2.setQ(q1);

		List<Answer> list = new ArrayList<Answer>();
		list.add(ans1);
		list.add(ans2);

		q1.setAnswers(list);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(q1);
		session.save(ans1);
		session.save(ans2);

		tx.commit();

		// fetching
		Question q = (Question) session.get(Question.class, 1);

		session.close();
		factory.close();
	}
}
