package org.example.exercice4.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice4.model.Cat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "chatServlet", value = "/chats")
public class CatServlet extends HttpServlet {
    private List<Cat> cats;

    @Override
    public void init() throws ServletException {
        cats = new ArrayList<>();
        // Ajout de quelques chats par défaut
        cats.add(new Cat("Misty", "Siamois", "Fish", "01/01/2020"));
        cats.add(new Cat("Shadow", "Persan", "Chicken", "05/05/2019"));
        cats.add(new Cat("Luna", "Bengal", "Kibbles", "10/10/2021"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cats", cats);
        getServletContext().getRequestDispatcher("/WEB-INF/cats.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String race = req.getParameter("race");
        String favouriteMeal = req.getParameter("favourite meal");
        String dateOfBirth = req.getParameter("dateOfBirth");

        cats.add(new Cat(name, race, favouriteMeal, dateOfBirth));

        req.setAttribute("cats", cats);
        getServletContext().getRequestDispatcher("/WEB-INF/cat/cats.jsp").forward(req, resp);
    }
}
