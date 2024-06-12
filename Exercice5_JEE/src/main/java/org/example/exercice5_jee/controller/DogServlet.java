package org.example.exercice5_jee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice5_jee.model.Dog;
import org.example.exercice5_jee.model.DogModel;
import org.example.exercice5_jee.service.DogService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

//@WebServlet(name = "DogServlet", urlPatterns = {"/dogs", "/dogs/new"})
@WebServlet(name = "dogServlet", value = "/dog/*")
public class DogServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }
    private DogService dogService = new DogService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/dogs/new".equals(path)) {
            request.getRequestDispatcher("/WEB-INF/dogs/add.jsp").forward(request, response);
        } else {
            List<Dog> dogs = dogService.findAll();
            List<Dog> dogModels = dogs.stream()
                    .map(dog -> new Dog(dog.getId(), dog.getName(), dog.getBreed(), dog.getBirthDate()))
                    .collect(Collectors.toList());
            request.setAttribute("dogs", dogModels);
            request.getRequestDispatcher("/WEB-INF/dogs/list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String breed = request.getParameter("breed");
        LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"));

        Dog dog = new Dog();
        dog.setName(name);
        dog.setBreed(breed);
        dog.setBirthDate(birthDate);

        dogService.save(dog);

        response.sendRedirect(request.getContextPath() + "/dogs");
    }

}
