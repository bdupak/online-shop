package com.epam;

import com.epam.dao.*;
import com.epam.entity.*;
import com.epam.service.UserService;
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
//        new Main().listUsers();
//        System.out.println(new UserDao(factory, User.class).getById(1));
//        System.out.println(new OrderDao(factory, Order.class).getAll());
//        System.out.println(new OrderDao(factory, Order.class).getById(1));
//        System.out.println(new ProductDao(factory, Product.class).getAll());
//        System.out.println(new AddressDao(factory, Address.class).getAll());
//        System.out.println(new ProductFeedbackDao(factory, ProductFeedback.class).getAll());
//        System.out.println(new CategoryDao(factory, Category.class).getAll());
//        System.out.println(new RoleDao(factory, Role.class).getAll());
        UserService service = new UserService();
        System.out.println(service.getAll());
        System.out.println(service.getUserById(1));
    }

    public void listUsers() {
        Session session = factory.openSession();
//        Transaction tx = null;

        try {
//            tx = session.beginTransaction();
            List users = session.createQuery("FROM Order").list();
            for (Iterator iterator = users.iterator(); iterator.hasNext(); ) {
                Order user = (Order) iterator.next();
                System.out.println("Out " + user);
            }
//            tx.commit();
        } catch (HibernateException e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
