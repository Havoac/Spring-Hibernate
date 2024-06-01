package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Question q1 = new Question();
        q1.setQuestionId(1);
        q1.setQuestion("What is Java");

        Answer ans1 = new Answer();
        ans1.setAnswerId(11);
        ans1.setAnswer("Java is a programming language");
        ans1.setQ(q1);
        
        q1.setAnswer(ans1);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(q1);
        session.save(ans1);

        tx.commit();
        
        // fetching
        Question q = (Question)session.get(Question.class, 1);
        System.out.println(q.getQuestion());
        System.out.println(q.getAnswer().getAnswer());
        
        session.close();
        factory.close();
    }
}
