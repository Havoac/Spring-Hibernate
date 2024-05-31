package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Started" );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        // creating Student
        Student st = new Student();
        st.setId(2);
        st.setName("Aman");
        st.setCity("Banglore");
        
        System.out.println(st);
        
        Session session = factory.getCurrentSession();
        
        Transaction tx = session.beginTransaction();
        session.save(st);
        tx.commit();
        
        session.close();
        
        System.out.println(factory);
        System.out.println(factory.isClosed());
    }
}
