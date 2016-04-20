package com.geosoftware.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Created by gis on 19.04.16.
 */
public class HibernateTest {
    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        UserDetails user2 = new UserDetails();
        //user.setUserID(1);
        user.setUserName("First User");
        user.setAdddress("address for first user");
        user.setJoinedDate(new Date());
        user.setDescription("description for first user");

        user2.setUserName("User 2");

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        session.save(user);
        session.save(user2);
        session.getTransaction().commit();
        session.close();

/*        user = null;

        session = sf.openSession();
        session.beginTransaction();
        user = (UserDetails) session.get(UserDetails.class, 1);
        System.out.println("User name retrieved=" + user.getUserName());*/


    }
}
