package dao;

import model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {

    /**
     * Adds a new employee to the database.
     *
     * @param employee the employee to be added
     */
    void addEmployee(Employee employee);

    /**
     * Retrieves an employee by their ID.
     *
     * @param idEmployee the ID of the employee to retrieve
     * @return an Optional containing the employee if found, or an empty Optional if not found
     */
    Optional<Employee> getEmployee(Integer idEmployee);

    /**
     * Retrieves all employees from the database.
     *
     * @return a list of all employees
     */
    List<Employee> getAllEmployes();

    /**
     * Deletes an employee by their ID.
     *
     * @param idEmployee the ID of the employee to delete
     */
    void deleteEmployee(Integer idEmployee);
}
