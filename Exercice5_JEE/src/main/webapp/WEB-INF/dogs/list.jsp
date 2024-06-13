<%--
  Created by IntelliJ IDEA.
  User: User1
  Date: 12/06/2024
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dogs" type="java.util.List<org.example.exercice5.model.Dog>" scope="request" />

<html>
<head>

    <title>Dogs List</title>
    <%@ include file="/WEB-INF/bootstrapimports.html" %>
</head>

<body>
<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 text-bg-dark rounded p-3">
            <h1 class="fw-light">-Dogs List -</h1>
            <hr>
            <!-- Condition if dogs list is not empty -->
            <c:if test="${not empty dogs}">
                <table class="table table-dark text-center align-middle">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Breed</th>
                        <th>Birth date</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="dog" items="${dogs}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${dog.name}</td>
                            <td>${dog.breed}</td>
                            <td>${dog.birthDate}</td>
                            <td>
                                <a href="dog/detail?id=${dog.id}" class="btn btn-info">Details</a>
                                <a href="dog/editForm?id=${dog.id}" class="btn btn-warning">Edit</a>
                                <a href="dog/delete?id=${dog.id}" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <!-- Condition else (when dogs list is empty) -->
            <c:if test="${empty dogs}">
                <div class="alert alert-warning text-center" role="alert">
                    There is no dog in the database yet!

                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Add dog
                        </button>
                </div>
            </c:if>
        </div>
    </div>
</main>


</body>
</html>
