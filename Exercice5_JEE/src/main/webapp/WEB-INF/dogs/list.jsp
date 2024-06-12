<%--
  Created by IntelliJ IDEA.
  User: User1
  Date: 12/06/2024
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <title>Dogs List</title>
</head>

<body>
<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 text-bg-dark rounded p-3">
            <h1 class="fw-light">- Liste des Chiens -</h1>
            <hr>
            <% if (!dogs.isEmpty()) { %>
            <table class="table table-dark text-center align-middle">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Race</th>
                    <th>Date de Naissance</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < dogs.size(); i++) { %>
                <tr>
                    <td><%= i+1 %></td>
                    <td><%= dogs.get(i).getName() %></td>
                    <td><%= dogs.get(i).getBreed() %></td>
                    <td><%= dogs.get(i).getBirthDate() %></td>
                    <td><a href="dogDetails.jsp?id=<%= dogs.get(i).getId() %>">Voir Détails</a></td>
                </tr>
                <% } %>
                </tbody>
            </table>
            <% } else { %>
            <p>Aucun chien n'est disponible.</p>
            <% }  %>
        </div>
    </div>
</main>


</body>
</html>
