package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Person p = new Person(1, "ram", "delhi", "12");
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(p);
        
        tx.commit();
        session.close();
        factory.close();
	}

}
