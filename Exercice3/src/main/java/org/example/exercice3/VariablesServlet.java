package org.example.exercice3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "variableServlet", value = "/variables")
public class VariablesServlet extends HttpServlet {
    private List<Personne> personnes;

    @Override
    public void init() throws ServletException {
        // Initialiser la liste des personnes
        personnes = new ArrayList<>();
        personnes.add(new Personne("Aissatou", "SY", 50));
        personnes.add(new Personne("Malick", "NIANG", 30));
        personnes.add(new Personne("Almamy", "DIALLO", 54));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        // Définir la liste des personnes comme attribut de la requête
        req.setAttribute("personnes", personnes);
        // Transférer la requête à la page JSP
        getServletContext().getRequestDispatcher("/variables.jsp").forward(req, resp);
    }
}
