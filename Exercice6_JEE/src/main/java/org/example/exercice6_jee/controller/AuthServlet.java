package org.example.exercice6_jee.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.exercice6_jee.model.Product;
import org.example.exercice6_jee.model.User;
import org.example.exercice6_jee.service.ProductService;
import org.example.exercice6_jee.service.UserService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "AuthServlet", urlPatterns = {"/auth", "/addProduct", "/listProducts"})
public class AuthServlet extends HttpServlet {
    private UserService userService;
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
        productService = new ProductService();
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
                case "/addProduct":
                    showAddProductForm(req, resp);
                    break;
                case "/listProducts":
                    listProducts(req, resp);
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
                case "/addProduct":
                    addProduct(req, resp);
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
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/auth/authForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void showRegisterForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/auth/authForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void showAddProductForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode", "add");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/products/productForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void listProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productService.getAllProducts();
        req.setAttribute("products", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/products/listProducts.jsp");
        dispatcher.forward(req, resp);
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(name, email, password);
        if (userService.create(user)) {
            HttpSession session = req.getSession();
            session.setAttribute("isLogged", true);
            resp.sendRedirect("listProducts");
        } else {
            resp.sendRedirect("auth?mode=register");
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = userService.findByEmailAndPassword(email, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("isLogged", true);
            resp.sendRedirect("listProducts");
        } else {
            resp.sendRedirect("auth?mode=login");
        }
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String reference = req.getParameter("reference");
        LocalDate purchaseDate = LocalDate.parse(req.getParameter("purchaseDate"));
        double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));

        Product product = new Product(brand, reference, purchaseDate, price, stock);
        productService.createProduct(product);
        resp.sendRedirect("listProducts");
    }
}

