package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;

import com.spring.hibernate.Student;

public class HQLExample {
	public static void main(String []args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        
        Session session = factory.openSession();
        
        // HQL
        // Syntax
        String query = "from Student where city=:x";		// Entity name-Student (Class name), city is the variable name in the Student Class
        
        Query q1 = session.createQuery(query);
        q1.setParameter("x", "Gurgaon");
        
        // single - (Unique)
        // multiple-list
        List<Student>list = q1.list();
        
        for(Student student:list)
        	System.out.println(student.getName());
        
        System.out.println("-----------------------------------------");
        
        Transaction tx = session.beginTransaction();
        
        // delete query
//        Query q2 = session.createQuery("delete from Student s where s.city='Hyderabad'");
//        System.out.println("No of rows deleted : " + q2.executeUpdate());
        
        // update query
        Query q3 = session.createQuery("update Student set city='Hyderabad'");
        System.out.println("Rows updated : " + q3.executeUpdate());
        
        Query q4 = session.createQuery("select q.question, q.questionId, a.answer from Question as q INNER JOIN q.answers as a");
        List<Object []>list4 = q4.getResultList();
        
        for(Object[] obj:list4)
        	System.out.println(Arrays.toString(obj));
        
        tx.commit();
        session.close();
        factory.close();
	}
}
