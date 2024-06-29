package com.sqlQuery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		String q = "select *from student";

		NativeQuery nq = session.createNativeQuery(q);
		List<Object[]> list = nq.list();

		for (Object[] obj : list)
			System.out.println(Arrays.deepToString(obj));

		session.close();
		factory.close();
	}
}
