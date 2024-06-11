<%--
  Created by IntelliJ IDEA.
  User: User1
  Date: 11/06/2024
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <title>Add a Cat</title>
</head>
<body>
<div class="container">
    <h1>Add a Cat</h1>
    <form method="post" action="cats">
        <div class="form-group">
            <label for="name">Name :</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="race">Race :</label>
            <input type="text" class="form-control" id="race" name="race" required>
        </div>
        <div class="form-group">
            <label for="favouriteMeal">Favourite Meal :</label>
            <input type="text" class="form-control" id="favouriteMeal" name="favouriteMeal" required>
        </div>
        <div class="form-group">
            <label for="dateOfBirth">Date of Birth :</label>
            <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" required>
        </div>
        <% if (mode.equals("modif")) { %>
        <button>Edit</button>
        <%  } else { %>
        <button>Add</button>
        <% } %>

    </form>
</div>

</body>
</html>
