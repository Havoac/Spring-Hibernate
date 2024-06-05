package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.Student;

public class FirstCachceDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Session session = factory.openSession();
    
        Student s1 = session.get(Student.class, 2);
        System.out.println(s1);
        
        // the select query get's fired only once 
        Student s2 = session.get(Student.class, 2);
        System.out.println(s2);
        
        session.close();
        factory.close();	
	}

}
