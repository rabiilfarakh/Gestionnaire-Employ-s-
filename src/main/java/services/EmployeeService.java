package services;

import model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void addEmployee(Employee employee);

    Employee getEmployee(Integer idEmployee);

    List<Employee> getAllEmployes();

    List<String> getDistinctDepartments();

    void deleteEmployee(Integer idEmployee);

    void updateEmployee(Integer idEmployee, Employee employee);

    List<Employee> searchEmployees(String value);

    List<Employee> filterEmployees(String department);
}
