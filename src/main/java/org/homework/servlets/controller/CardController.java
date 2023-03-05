package org.homework.servlets.controller;

import com.google.gson.Gson;
import org.hibernate.SessionFactory;
import org.homework.servlets.dbconnection.HibernateSession;
import org.homework.servlets.model.Card;
import org.homework.servlets.repository.CardRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class CardController extends HttpServlet {

    private CardRepository cardRepository;
    private Gson gson;

    public CardController(){
        SessionFactory sessionFactory = HibernateSession.getInstance().getSessionFactory();
        cardRepository = new CardRepository(sessionFactory);
        gson = new Gson();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();

        List<Card> cards  = cardRepository.getAll();
        String cardsAsJson = gson.toJson(cards);

        printWriter.println(cardsAsJson);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
