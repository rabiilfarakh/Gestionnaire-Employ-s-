<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Employee" %>
<%@ page import="dao.EmployeeDAOImpl" %>
<%
    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
    List<Employee> employees = employeeDAO.getAllEmployes();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Employés</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script>
        function filterDepartment() {
            const filterValue = document.getElementById("departmentFilter").value;
            // Logique de filtrage à ajouter ici
        }

        function searchEmployees() {
            const searchValue = document.getElementById("searchInput").value;
            // Logique de recherche à ajouter ici
        }

        function confirmDelete(id) {
            if (confirm("Êtes-vous sûr de vouloir supprimer cet employé ?")) {
                // Logique de suppression à ajouter ici
                window.location.href = 'deleteEmployee.jsp?id=' + id; // Redirige vers la page de suppression
            }
        }
    </script>
</head>
<body>
    <h1>Liste des Employés</h1>

    <div class="controls">
        <input type="text" id="searchInput" placeholder="Rechercher un employé..." onkeyup="searchEmployees()">
        <select id="departmentFilter" onchange="filterDepartment()">
            <option value="">Filtrer par Département</option>
            <option value="HR">Ressources Humaines</option>
            <option value="IT">Informatique</option>
            <option value="Finance">Finance</option>
        </select>
    </div>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Email</th>
            <th>Téléphone</th>
            <th>Département</th>
            <th>Poste</th>
            <th>Actions</th> <!-- Nouvelle colonne pour les actions -->
        </tr>
        <%
            for (Employee employee : employees) {
        %>
        <tr>
            <td><%= employee.getIdEmployee() %></td>
            <td><%= employee.getName() %></td>
            <td><%= employee.getEmail() %></td>
            <td><%= employee.getPhone() %></td>
            <td><%= employee.getDepartement() %></td>
            <td><%= employee.getPoste() %></td>
            <td>
                <button onclick="window.location.href='updateEmployee.jsp?id=<%= employee.getIdEmployee() %>'">Mettre à Jour</button>
                <button onclick="confirmDelete(<%= employee.getIdEmployee() %>)">Supprimer</button>
            </td>
        </tr>
        <%
            }
        %>
    </table><br>

    <button onclick="window.location.href='addEmployee.jsp'">Ajouter un Employé</button>
</body>
</html>
