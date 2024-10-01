<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/styles.css">
    <title>Ajouter un Employé</title>
</head>
<body>
    <h2>Ajouter un Employé</h2>
    <form action="employee" method="post">
        <input type="hidden" name="action" value="add">
        Name: <input type="text" name="name"><br>
        Email: <input type="text" name="email"><br>
        Phone: <input type="text" name="phone"><br>
        Department: <input type="text" name="departement"><br>
        Post: <input type="text" name="post"><br>
        <input type="submit" value="Ajouter">
    </form>
    <a href="employeeList.jsp">Retour à la liste</a>
</body>
</html>
