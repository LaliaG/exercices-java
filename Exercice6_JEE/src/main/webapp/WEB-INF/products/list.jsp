<%@ page import="org.example.exercice6_jee.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/06/2024
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="products" type="java.util.ArrayList<org.example.exercice6_jee.model.Product>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapimports.html" %>
    <title>Products List</title>
</head>
<body>
<main class="container">
    <div class="row my-3">

        <div class="col-8 offset-2 rounded text-bg-dark p-3">
            <h1 class="fw-light">- Products List -</h1>
            <hr>
            <% if (!products.isEmpty()) { %>
            <table class="table table-dark align-middle table-striped text-center">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Brand</th>
                    <th>Reference</th>
                    <th>PurchaseDate</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <% for (Product p : products) {%>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getBrand() %></td>
                    <td><%= p.getReference() %></td>
                    <td><%= p.getPurchaseDate().toString() %></td>
                    <td><%= p.getPrice() %></td>
                    <td><%= p.getStock() %></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/product/detail?id=<%= p.getId() %>"
                           class="btn btn-outline-info"><i class="bi bi-eye"></i> Details</a>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
            <%  } else { %>
            <p>There is no product in the database yet!</p>
            <%  }  %>
            <hr>
            <div class="text-end">
                <a href="${pageContext.request.contextPath}/product/addForm" class="btn btn-outline-success"><i
                        class="bi bi-plus-circle"></i> Add a Product</a>
            </div>
        </div>
    </div>
</main>
</body>
</html>
