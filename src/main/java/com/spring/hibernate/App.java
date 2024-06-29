package com.spring.hibernate;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("Started");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating object of Student class
		Student st = new Student();
		st.setId(1);
		st.setName("Aman");
		st.setCity("Banglore");
		System.out.println(st);

		// creating object of Address class
		Address address = new Address();
		address.setStreet("street1");
		address.setCity("NOIDA");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(1.1);

		// reading image
		try {
			File file = new File("src/main/java/pic.png");
			if (!file.exists()) {
				System.err.println("File does not exist ");
				System.err.println("Absolute Path: " + file.getAbsolutePath());
			}

			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
			byte[] data = new byte[fis.available()];
			fis.read(data);
			System.out.println(data);

			try {
				address.setImage(data);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(address);
		tx.commit();

		session.close(); // if we had used "hibernate.current_session_context_class". There was no need to manually close the session.

		System.out.println(factory);
		System.out.println(factory.isClosed());
	}
}
