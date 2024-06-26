package org.example.exercice6_jee.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.exercice6.model.User;
import org.example.exercice6.service.UserService;

import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = {"/user", "/register", "/login"})
public class UserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        try {
            switch (action) {
                case "/register":
                    showRegisterForm(req, resp);
                    break;
                case "/login":
                    showLoginForm(req, resp);
                    break;
                default:
                    showLoginForm(req, resp);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        try {
            switch (action) {
                case "/register":
                    register(req, resp);
                    break;
                case "/login":
                    login(req, resp);
                    break;
                default:
                    showLoginForm(req, resp);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void showLoginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/users/logForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void showRegisterForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/users/registerForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(name, email, password);
        boolean userCreated = userService.create(user);

        if (userCreated) {
            HttpSession session = req.getSession();
            session.setAttribute("isLogged", true);
            session.setAttribute("user", user);
            resp.sendRedirect("products");
        } else {
            resp.sendRedirect("register");
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = userService.findByEmailAndPassword(email, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("isLogged", true);
            session.setAttribute("user", user);
            resp.sendRedirect("products");
        } else {
            resp.sendRedirect("login");
        }
    }
}
