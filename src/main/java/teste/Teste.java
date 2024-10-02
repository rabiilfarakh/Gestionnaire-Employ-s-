package teste;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

import java.util.List;

public class Teste {

    public static void main(String[] args) {

        // Instancier l'implémentation via l'interface
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        // Ajouter des employés pour tester (vous pouvez commenter cela si les employés existent déjà)
        // Employee employee1 = new Employee("John Doe", "john.doe@gmail.com", "0611122233", "Maths", "Professeur");
        // employeeDAO.addEmployee(employee1);
        // Employee employee2 = new Employee("Jane Smith", "jane.smith@gmail.com", "0611122234", "Informatique", "Ingenieur");
        // employeeDAO.addEmployee(employee2);

        // update
        Employee employee = new Employee("mohamed", "mohamed@gmail.com", "0611122233", "GEOLOGIE", "Enseinant");
        employeeDAO.updateEmployee(52,employee);

        // Obtenir la liste de tous les employés
//        List<Employee> listEmployees = employeeDAO.getAllEmployes();
//        System.out.println("Tous les employés :");
//        displayEmployeeTable(listEmployees);

        // Test de la méthode searchEmployees (recherche par nom, email, département, poste)
//        System.out.println("\nRecherche d'employés");
//        List<Employee> searchedEmployees = employeeDAO.searchEmployees("Employee_3");
//        displayEmployeeTable(searchedEmployees);

        //Test de la méthode filterEmployees (filtrer par département et poste)
//        System.out.println("\nFiltrer les employés par département");
//        List<Employee> filteredEmployees = employeeDAO.filterEmployees("Physique");
//        displayEmployeeTable(filteredEmployees);

    }

    public static void displayEmployeeTable(List<Employee> employees) {
        // Titre du tableau
        System.out.printf("%-10s %-20s %-30s %-15s %-15s %-15s%n",
                "ID", "Name", "Email", "Phone", "Department", "Position");
        System.out.println("--------------------------------------------------------------------------");

        // Afficher les données des employés
        if (employees != null && !employees.isEmpty()) {
            for (Employee employee : employees) {
                System.out.printf("%-10d %-20s %-30s %-15s %-15s %-15s%n",
                        employee.getIdEmployee(),
                        employee.getName(),
                        employee.getEmail(),
                        employee.getPhone(),
                        employee.getDepartement(),
                        employee.getPoste());
            }
        } else {
            System.out.println("Aucun employé trouvé.");
        }
    }
}
