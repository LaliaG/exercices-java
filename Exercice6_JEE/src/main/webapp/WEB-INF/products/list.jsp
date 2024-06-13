<%@ page import="org.example.exercice5.model.Dog" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/06/2024
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="dogs" type="java.util.ArrayList<org.example.exercice5.model.Dog>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapimports.html" %>
    <title>Dogs List</title>
</head>
<body>
<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 rounded text-bg-dark p-3">
            <h1 class="fw-light">- Dogs List -</h1>
            <hr>
            <% if (!dogs.isEmpty()) { %>
            <table class="table table-dark align-middle table-striped text-center">
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
                <% for (Dog d : dogs) {%>
                <tr>
                    <td><%= d.getId() %></td>
                    <td><%= d.getName() %></td>
                    <td><%= d.getBreed() %></td>
                    <td><%= d.getBirthDate().toString() %></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/dog/detail?id=<%= d.getId() %>"
                           class="btn btn-outline-info"><i class="bi bi-eye"></i> Details</a>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
            <%  } else { %>
            <p>There is no dog in the database yet!</p>
            <%  }  %>
            <hr>
            <div class="text-end">
                <a href="${pageContext.request.contextPath}/dog/addForm" class="btn btn-outline-success"><i
                        class="bi bi-plus-circle"></i> Add a Dog</a>
            </div>
        </div>
    </div>
</main>
</body>
</html>
