package teste;

import dao.Services;
import model.Employee;

import java.util.List;

public class Teste {

    public static void main(String[] args){

        // load services
        Services services = new Services();

        //Add Employee
        //Employee employee1 = new Employee("Employee_1","employee_1@gmail.com","0611122233","Maths","Professeur");
        //services.addEmployee(employee1);

        // get Employee
        //Employee employee = services.getEmployee(1);
        //System.out.println(employee.toString());

        //delete Employee
        //services.deleteEmployee(1);

        //getAll Employee
        List<Employee> listEmployes = services.getAllEmployes();
        displayEmployeeTable(listEmployes);
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
