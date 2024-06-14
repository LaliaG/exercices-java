<%--
  Created by IntelliJ IDEA.
  User: User1
  Date: 14/06/2024
  Time: 04:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<%
    if (mode == null) {
        mode = "login";
    }
%>
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapimports.html" %>
    <title><%= mode.equals("login") ? "Login" : "Sign Up" %></title>
</head>
<body>
<div class="container">
    <h2><%= mode.equals("login") ? "Login" : "Sign Up" %></h2>
    <form action="auth" method="post">
        <input type="hidden" name="mode" value="<%= mode %>">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary"><%= mode.equals("login") ? "Login" : "Sign Up" %></button>
    </form>
    <button class="btn btn-link" onclick="window.location.href='authForm.jsp?mode=<%= mode.equals("login") ? "signup" : "login" %>'">
        <%= mode.equals("login") ? "Sign Up" : "Login" %>
    </button>
    <% if (session.getAttribute("isLogged") != null && (Boolean) session.getAttribute("isLogged")) { %>
    <button class="btn btn-link" onclick="window.location.href='editUser'">Edit Profile</button>
    <% } %>
    <% if (request.getAttribute("error") != null) { %>
    <div class="alert alert-danger mt-3">
        <%= request.getAttribute("error") %>
    </div>
    <% } %>
</div>

</body>
</html>
