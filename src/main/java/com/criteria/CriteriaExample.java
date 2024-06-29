package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.spring.hibernate.Student;

public class CriteriaExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Criteria c = session.createCriteria(Student.class);
		c.add(Restrictions.eq("certi.course", "Java")); // to filter student (student with course java)

		List<Student> students = c.list(); // returns all the students (all the columns)

		factory.close();
	}

}
