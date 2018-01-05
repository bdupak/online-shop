package com.epam;

import com.epam.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.Iterator;
import java.util.List;

public class Main {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new AnnotationConfiguration().
                    configure().
                    addPackage("com.epam.entity"). //add package if used.
                            addAnnotatedClass(User.class).
                            buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        new Main().listUsers();
    }

    public void listUsers( ) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM user").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext(); ) {
                User user = (User) iterator.next();
                System.out.println(user);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
