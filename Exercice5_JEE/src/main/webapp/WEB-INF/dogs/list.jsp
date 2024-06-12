<%--
  Created by IntelliJ IDEA.
  User: User1
  Date: 12/06/2024
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <c:choose>
                <c:when test="${not empty chiens}">
                    <table class="table table-dark text-center align-middle">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Nom</th>
                            <th>Race</th>
                            <th>Date de Naissance</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="chien" items="${chiens}" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td>${chien.nom}</td>
                                <td>${chien.race}</td>
                                <td>${chien.dateNaissance}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <p>Vous n'avez aucun chien !!!!</p>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="col-8 offset-2 rounded text-bg-dark p-3 text-center">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/chiens/new">Ajouter un Chien</a>
    </div>
</main>


</body>
</html>
