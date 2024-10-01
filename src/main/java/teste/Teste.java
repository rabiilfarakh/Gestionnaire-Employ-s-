package test;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

import java.util.List;

public class Teste {

    public static void main(String[] args) {

        // Instancier l'implémentation via l'interface
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        // Ajouter un employé (
        // Employee employee1 = new Employee("Employee_11", "employee_11@gmail.com", "0611122233", "Maths", "Professeur");
        // employeeDAO.addEmployee(employee1);

        // Obtenir un employé par son ID
        // Employee employee = employeeDAO.getEmployee(52);
        // System.out.println(employee.toString());

        // Supprimer un employé par son ID
        // employeeDAO.deleteEmployee(1);

        // Obtenir la liste de tous les employés
        List<Employee> listEmployees = employeeDAO.getAllEmployes();
        displayEmployeeTable(listEmployees);
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
