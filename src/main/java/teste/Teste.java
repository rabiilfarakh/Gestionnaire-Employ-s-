package teste;

import dao.Services;
import model.Employee;

public class Teste {

    public static void main(String[] args){

        Services services = new Services();
        Employee employee = new Employee("Employee_1","employee_1@gmail.com","0611223344","Informatique","Developpeur");
        services.addEmployee(employee);
    }
}
