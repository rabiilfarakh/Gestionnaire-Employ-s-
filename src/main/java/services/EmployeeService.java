package services;

import model.Employee;

import java.util.List;

public interface EmployeeService {
    public void addEmployee(Employee employee);
    public Employee getEmployee(Integer idEmployee);
    public List<Employee> getAllEmployes();
    public void deleteEmployee(Integer idEmployee);
}
