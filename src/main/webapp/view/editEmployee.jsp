<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controller.EmployeeServlet" %>
<%@ page import="model.Employee" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/styles.css">
    <title>Éditer un Employé</title>
</head>
<body>
    <h2>Éditer un Employé</h2>
    <%
        int index = Integer.parseInt(request.getParameter("index"));
        EmployeeServlet employeeServlet = new EmployeeServlet();
        Employee emp = employeeServlet.getEmployeeList().get(index);
    %>
    <form action="employee" method="post">
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="index" value="<%= index %>">
        Name: <input type="text" name="name" value="<%= emp.getName() %>"><br>
        Email: <input type="text" name="email" value="<%= emp.getEmail() %>"><br>
        Phone: <input type="text" name="phone" value="<%= emp.getPhone() %>"><br>
        Department: <input type="text" name="departement" value="<%= emp.getDepartement() %>"><br>
        Post: <input type="text" name="post" value="<%= emp.getPoste() %>"><br>
        <input type="submit" value="Mettre à jour">
    </form>
    <a href="employeeList.jsp">Retour à la liste</a>
</body>
</html>
