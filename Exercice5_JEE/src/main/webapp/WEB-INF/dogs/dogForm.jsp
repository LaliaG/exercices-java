<%--
  Created by IntelliJ IDEA.
  User: User1
  Date: 12/06/2024
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/bootstrapimports.html"%>
    <title>Add a new dog</title>
</head>
<body>
<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 text-bg-dark rounded p-3">
            <h1 class="fw-light">- Add a dog -</h1>
            <hr>
            <form method="post" action="${pageContext.request.contextPath}/dogs">
                <div class="mb-3">
                    <label for="name" class="form-label">Name :</label>
                    <input type="text" class="form-control" name="name" id="name" required>
                </div>
                <div class="mb-3">
                    <label for="breed" class="form-label">Breed :</label>
                    <input type="text" class="form-control" name="breed" id="breed" required>
                </div>
                <div class="mb-3">
                    <label for="birthDate" class="form-label">Birth date :</label>
                    <input type="date" class="form-control" name="birthDate" id="birthDate" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Add dog
                    </button>
                </div>
            </form>
        </div>
    </div>
</main>

</body>
</html>
