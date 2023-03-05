package org.homework.servlets.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.homework.servlets.model.Card;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardRepository {
    private SessionFactory sessionFactory;

    public CardRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public List<Card> getAll() throws ServletException {
        return (List<Card>) sessionFactory.openSession().createQuery("FROM Card ORDER BY id").list();
    }

}
