<%--
  Created by IntelliJ IDEA.
  User: User1
  Date: 11/06/2024
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="cats" type="java.util.ArrayList<org.example.exercice4.model.Cat>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <title>List of Cats</title>

</head>
<body>
<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 text-bg-dark rounded p-3">
            <h1 class="fw-light">- List of Cats -</h1>
            <hr>
            <table class="table table-dark text-center align-middle">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Race</th>
                    <th>FavouriteMeal</th>
                    <th>DateOfBirth</th>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < cats.size();i++) { %>
                <tr>
                    <td><%= i+1 %></td>
                    <td><%= cats.get(i).getName() %></td>
                    <td><%= cats.get(i).getRace() %></td>
                    <td><%= cats.get(i).getFavouriteMeal() %></td>
                    <td><%= cats.get(i).getDateOfBirth() %></td>
                </tr>
                <% } %>
                </tbody>
            </table>
            <a href="addCat.jsp" class="btn btn-primary">Add a Cat</a>
        </div>
    </div>
</main>

</body>
</html>
