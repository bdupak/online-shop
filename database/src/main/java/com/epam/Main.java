package com.epam;

import com.epam.entity.Order;
import com.epam.entity.Product;
import com.epam.entity.ProductFeedback;
import com.epam.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class Main {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        new Main().listUsers();
    }

    public void listUsers() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM Order").list();
            System.out.println(users);
            for (Iterator iterator = users.iterator(); iterator.hasNext(); ) {
                Order user = (Order) iterator.next();
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
