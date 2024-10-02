package services;

import dao.EmployeeDAO;
import model.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;


    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    public Employee getEmployee(Integer idEmployee) {
        Optional<Employee> employeeOpt = employeeDAO.getEmployee(idEmployee);
        return employeeOpt.orElse(null);
    }

    @Override
    public List<Employee> getAllEmployes() {
        return employeeDAO.getAllEmployes();
    }

    @Override
    public void deleteEmployee(Integer idEmployee) {
        employeeDAO.deleteEmployee(idEmployee);
    }

    @Override
    public void updateEmployee(Employee employee){
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public List<Employee> searchEmployees(String value) {
        return employeeDAO.searchEmployees(value);
    }

    @Override
    public List<Employee> filterEmployees(String department) {
        return employeeDAO.filterEmployees(department);
    }
}
