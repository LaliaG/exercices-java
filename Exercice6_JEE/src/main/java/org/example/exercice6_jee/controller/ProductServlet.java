package org.example.exercice6_jee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice6_jee.model.Product;
import org.example.exercice6_jee.service.ProductService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "products", value = "/products/*")
public class ProductServlet extends HttpServlet {
    private ProductService productService;
    private Product product;

    public ProductServlet(Product product) {
        this.product = product;
    }

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if (action == null) {
            action = "/";
        }

        switch (action) {
            case "/add":
                showAddForm(req, resp);
                break;
            case "/details":
                showDetails(req, resp);
                break;
            case "/delete":
                deleteProduct(req, resp);
                break;
            case "/":
            default:
                listProducts(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if (action == null) {
            action = "/";
        }

        switch (action) {
            case "/add":
                addProduct(req, resp);
                break;
            default:
                listProducts(req, resp);
                break;
        }
    }

    private void listProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        req.setAttribute("products", productList);
        req.getRequestDispatcher("/WEB-INF/products/list.jsp").forward(req, resp);
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/products/addForm.jsp").forward(req, resp);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String brand = request.getParameter("brand");
        String reference = request.getParameter("reference");
        LocalDate purchaseDate = LocalDate.parse(request.getParameter("purchaseDate"));
        double price = Double.valueOf(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        Product produit = new Product(brand, reference, purchaseDate, price, stock);
        productService.create(produit);
        resp.sendRedirect(request.getContextPath() + "/products");
    }

    private void showDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/WEB-INF/products/details.jsp").forward(req, resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        productService.delete(product);
        resp.sendRedirect(req.getContextPath() + "/products");
    }
}
