package org.homework.servlets.dbconnection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.homework.servlets.model.Card;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSession {
    private static HibernateSession instance = null;

    private SessionFactory sessionFactory;

    private HibernateSession(){
        try{
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Card.class);

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());

        }catch(Exception e){
            System.out.println("HibernateSession init error:" + e);
        }
    }

    public static HibernateSession getInstance(){
        if(instance==null){
            instance = new HibernateSession();
        }
        return instance;
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
