package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.Answer;
import com.mapping.Question;

public class CascadeExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Question q1 = new Question();
		q1.setQuestionId(3241);
		q1.setQuestion("what is cascading ? ");

		Answer a1 = new Answer(12314, "In hibernate, it is important concept");
		Answer a2 = new Answer(1213, "second ans");
		Answer a3 = new Answer(121, "third ans");

		List<Answer> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);

		q1.setAnswers(list);

		Transaction tx = session.beginTransaction();

		session.save(q1);
		// we need to save answers as well to update it in the database.
		// But if we use cascade, the related entity of the main entity gets saved
		// automatically.
//        session.save(a1);
//        session.save(a2);
//        session.save(a3);
//        
		tx.commit();
		session.close();
		factory.close();
	}

}
