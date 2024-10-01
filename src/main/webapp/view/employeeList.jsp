<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/styles.css">
    <title>Liste des Employés</title>
</head>
<body>
    <h2>Liste des Employés</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Department</th>
            <th>Post</th>
            <th>Actions</th>
        </tr>
        <%
            HttpSession session = request.getSession();
            List<Employee> employees = (List<Employee>) session.getAttribute("employeeList");
            if (employees == null) {
                employees = new ArrayList<>(); // Initialiser une liste vide si aucune donnée n'est trouvée
            }
            for (int i = 0; i < employees.size(); i++) {
                Employee emp = employees.get(i);
        %>
            <tr>
                <td><%= emp.getName() %></td>
                <td><%= emp.getEmail() %></td>
                <td><%= emp.getPhone() %></td>
                <td><%= emp.getDepartement() %></td>
                <td><%= emp.getPoste() %></td>
                <td>
                    <a href="editEmployee.jsp?index=<%= i %>">Éditer</a>
                    <form action="employee" method="post" style="display:inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="index" value="<%= i %>">
                        <input type="submit" value="Supprimer">
                    </form>
                </td>
            </tr>
        <%
            }
        %>
    </table>
    <a href="addEmployee.jsp">Ajouter un Employé</a>
</body>
</html>
