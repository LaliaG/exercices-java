package org.example.exercice5_jee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice5_jee.model.Dog;
import org.example.exercice5_jee.service.DogService;
import org.example.exercice5_jee.util.HibernateSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

//import static jdk.internal.editor.external.ExternalEditor.edit;

//@WebServlet(name = "DogServlet", urlPatterns = {"/dogs", "/dogs/new"})
@WebServlet(name = "dogServlet", value = "/dog/*")
public class DogServlet extends HttpServlet {
    private DogService dogService;

    @Override
    public void init() throws ServletException {
        dogService = new DogService(HibernateSession.getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo().substring(1);
        switch (action){
            case "list":
                showAll(req,resp);
                break;
            case "addForm":
                showForm(req,resp);
                break;
            case "add":
                add(req,resp);
                break;
            case "detail":
                showDetails(req,resp);
                break;
            case "editForm":
                showEditForm(req, resp);
                break;
            case "edit":
                edit(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    protected void showAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("dogs",dogService.getDogs());
        request.getRequestDispatcher("/WEB-INF/dogs/list.jsp").forward(request,response);
    }

    protected void showForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        Dog dogToAdd = new Dog("","",LocalDate.now());
        request.setAttribute("dog",dogToAdd);
        request.setAttribute("mode","add");
        request.getRequestDispatcher("/WEB-INF/dogs/dogForm.jsp").forward(request,response);
    }

    protected void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String breed = request.getParameter("breed");
        LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"));
        dogService.createDog(name,breed,birthDate);
        response.sendRedirect("list");
    }

    protected void showDetails(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        int dogId = Integer.parseInt(request.getParameter("id"));
        Dog dog = dogService.getDog(dogId);
        request.setAttribute("dog",dog);
        request.setAttribute("mode","view");
        request.getRequestDispatcher("/WEB-INF/dogs/dogForm.jsp").forward(request,response);
    }

    protected void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dogId = Integer.parseInt(request.getParameter("id"));
        Dog dog = dogService.getDog(dogId);
        request.setAttribute("dog", dog);
        request.setAttribute("mode", "edit");
        request.getRequestDispatcher("/WEB-INF/dogs/dogForm.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String breed = request.getParameter("breed");
        LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"));
        dogService.updateDog(id, name, breed, birthDate);
        response.sendRedirect("list");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dogService.deleteDog(id);
        response.sendRedirect("list");
    }






}
