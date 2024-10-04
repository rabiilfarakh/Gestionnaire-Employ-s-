<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/addEmployee.css">
    <script src="../js/validation.js"></script>

    <title>Ajouter un Employé</title>

</head>
<body>
    <h2>Ajouter un Employé</h2>
    <form name="employeeForm" action="employees" method="post" onsubmit="return validateForm()">
        <input type="hidden" name="action" value="add">
        Nom: <input type="text" id="name" name="name"><br>
        E-mail: <input type="text" id="email" name="email"><br>
        Téléphone: <input type="text" id="phone" name="phone"><br>
        Département: <input type="text" id="departement" name="departement"><br>
        Poste: <input type="text" id="poste" name="poste"><br>
        <input type="submit" value="Ajouter">
    </form>
    <a href="employees">Retour à la liste</a>
</body>
</html>
