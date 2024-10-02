package controller;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;

    @Override
    public void init() throws ServletException {
        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeDAO.getAllEmployes();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String poste = req.getParameter("poste");
        String phone = req.getParameter("phone");
        String departement = req.getParameter("departement");

        Employee employee = new Employee(name,email,poste,phone,departement);
        employeeDAO.addEmployee(employee);

        resp.sendRedirect("index.jsp");
    }
}
