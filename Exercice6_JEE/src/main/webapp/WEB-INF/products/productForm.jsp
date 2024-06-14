<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/06/2024
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<jsp:useBean id="product" type="org.example.exercice6_jee.model.Product" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapimports.html" %>
    <title><%= mode.substring(0,1).toUpperCase()+mode.substring(1).toLowerCase() %> a Product</title>
</head>
<body>
<main class="container">
    <div class="my-3 row">
        <div class="col-8 offset-2 p-3 rounded text-bg-dark">
            <h1 class="fw-light">-<%= mode.substring(0, 1).toUpperCase() + mode.substring(1).toLowerCase() %> a Product-</h1>
            <hr>
            <form action="<%= mode.equals("add") ? "add" : "" %>" method="post">
                <input type="number" class="d-none" name="id" readonly>
                <div class="mb-3">
                    <label for="brand" class="form-label">Brand:</label>
                    <input type="text" name="brand" id="brand" class="form-control" value="<%= product.getBrand() %>" <% if (mode.equals("add")) { %> required <% } else { %> readonly <% } %>>
                </div>
                <div class="mb-3">
                    <label for="reference" class="form-label">Reference:</label>
                    <input type="text" name="reference" id="reference" class="form-control" value="<%= product.getReference() %>" <% if (mode.equals("add")) { %> required <% } else { %> readonly <% } %>>
                </div>
                <div class="mb-3">
                    <label for="purchaseDate" class="form-label">Purchase Date:</label>
                    <input type="date" name="purchaseDate" id="purchaseDate" class="form-control" value="<%= product.getPurchaseDate() %>" <% if (mode.equals("add")) { %> required <% } else { %> readonly <% } %>>
                </div>
                <div class="mb-3">
                    <label for="price" class="form-label">Price:</label>
                    <input type="number" name="price" id="price" step="0.01" class="form-control" value="<%= product.getPrice() %>" <% if (mode.equals("add")) { %> required <% } else { %> readonly <% } %>>
                </div>
                <div class="mb-3">
                    <label for="stock" class="form-label">Stock:</label>
                    <input type="number" name="stock" id="stock" class="form-control" value="<%= product.getStock() %>" <% if (mode.equals("add")) { %> required <% } else { %> readonly <% } %>>
                </div>

                <hr>
                <div class="text-end">
                    <% if (mode.equals("add")) { %>
                    <button class="btn btn-outline-success"><i class="bi bi-plus-circle"></i> Add Product</button>
                    <% } else { %>
                    <a href="${pageContext.request.contextPath}/products/list" class="btn btn-outline-secondary"><i
                            class="bi bi-arrow-counterclockwise"></i>
                        Return</a>
                    <% }  %>
                </div>
            </form>
        </div>
    </div>
</main>
</body>
</html>
