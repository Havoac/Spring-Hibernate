package com.States;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.Certificate;
import com.spring.hibernate.Student;

public class StateDemo {

	public static void main(String[] args) {
		// transient
		// persistent
		// detached
		// removed

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student student = new Student();
		student.setId(11);
		student.setName("Arya");
		student.setCity("Gurgaon");
		student.setCerti(new Certificate("MERN", "4 months"));
		// student : Transient

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		// student : persistent
		student.setName("harry"); // data gets updated in database
		tx.commit();

		session.close();

		// student : Detached
		student.setName("John"); // value will not be updated in the database. The value goes before commiting
		System.out.println(student); // the value in object gets updated locally
		factory.close();
	}

}
