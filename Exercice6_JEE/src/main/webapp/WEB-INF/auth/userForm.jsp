<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" type="org.example.exercice6_jee.model.User" scope="request" />
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapimports.html" %>
    <title>Edit User</title>
</head>
<body>
<div class="container">
    <h2>Edit User</h2>
    <form action="updateUser" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${user.name}" required>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="${user.email}" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" value="${user.password}" required>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
    <form action="deleteUser" method="post" style="margin-top: 10px;">
        <button type="submit" class="btn btn-danger">Delete Account</button>
    </form>
    <% if (request.getAttribute("error") != null) { %>
    <div class="alert alert-danger mt-3">
        <%= request.getAttribute("error") %>
    </div>
    <% } %>
</div>
</body>
</html>
