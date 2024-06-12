package org.example.exercice5_jee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice5_jee.entity.Dog;
import org.example.exercice5_jee.model.DogModel;
import org.example.exercice5_jee.service.DogServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "DogServlet", urlPatterns = {"/dogs", "/dogs/new"})
public class DogServlet extends HttpServlet {
    private DogServiceImpl dogService = new DogServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/dogs/new".equals(path)) {
            request.getRequestDispatcher("/WEB-INF/dogs/add.jsp").forward(request, response);
        } else {
            List<Dog> dogs = dogService.findAll();
            List<DogModel> dogModels = dogs.stream()
                    .map(dog -> new DogModel(dog.getId(), dog.getName(), dog.getBreed(), dog.getBirthDate()))
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
