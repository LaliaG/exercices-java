<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.exercice3" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.exercice3.Personne" %>
<html>
<head>
    <title>Liste des Personnes</title>
    <!-- Ajouter le CSS de Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Liste des Personnes</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Prénom</th>
            <th>Nom</th>
            <th>Âge</th>
        </tr>
        </thead>
        <tbody>
        <%
            // Récupérer la liste des personnes depuis l'attribut de requête
            List<Personne> personnes = (List<Personne>) request.getAttribute("personnes");
            for (Personne personne : personnes) {
        %>
        <tr>
            <td><%= personne.getPrenom() %></td>
            <td><%= personne.getNom() %></td>
            <td><%= personne.getAge() %></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<!-- Ajouter le JS de Bootstrap et ses dépendances -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
