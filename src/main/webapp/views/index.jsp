<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des Employés</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

</head>
<body>

<h1>Liste des Employés</h1>

<div class="controls">

    <form action="employees" method="get">
        <input type="hidden" name="action" value="search">
        <input type="text" name="searchInput" placeholder="Rechercher un employé...">

            <select id="departmentFilter" onchange="filterDepartment()">
                <option value="">Filtrer par Département</option>
                <option value="HR">Ressources Humaines</option>
                <option value="IT">Informatique</option>
                <option value="Finance">Finance</option>
            </select>
    </form>

</div>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Email</th>
        <th>Téléphone</th>
        <th>Département</th>
        <th>Poste</th>
        <th>Actions</th>
    </tr>
    <c:if test="${empty employees}">
        <tr>
            <td colspan="7">Aucun employé trouvé.</td>
        </tr>
    </c:if>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.idEmployee}</td>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>${employee.phone}</td>
            <td>${employee.departement}</td>
            <td>${employee.poste}</td>
            <td>
                <button onclick="window.location.href='employees?action=edit&id=${employee.idEmployee}'">Mettre à Jour</button>

                <button onclick="window.location.href='employees?action=delete&id=${employee.idEmployee}'">Supprimer</button>
            </td>
        </tr>
    </c:forEach>
</table><br>

<button onclick="window.location.href='addEmployee.jsp'">Ajouter un Employé</button>

<script>
    function filterDepartment() {
        const filterValue = document.getElementById("departmentFilter").value;
        // Logique de filtrage à ajouter ici
    }

    function confirmDelete(id) {
        if (confirm("Êtes-vous sûr de vouloir supprimer cet employé ?")) {
            window.location.href = 'employees?action=delete&id=' + id;
        }
    }
</script>
</body>
</html>
