package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student student = new Student();
		student.setId(2);
		student.setName("Devesh");
		student.setCity("hyderabad");

		Certificate certi = new Certificate();
		certi.setCourse("Spring");
		certi.setDuration("2 months");
		student.setCerti(certi);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);

		for (int i = 10; i < 100; i++) {
			Student tempStudent = new Student();
			tempStudent.setId(i);
			tempStudent.setName("Devesh");
			tempStudent.setCity("hyderabad");

			Certificate tempCerti = new Certificate();
			tempCerti.setCourse("java Course");
			tempCerti.setDuration("2 months");
			tempStudent.setCerti(tempCerti);

			session.save(tempStudent);
		}

		tx.commit();
		session.close();
		factory.close();
	}

}
