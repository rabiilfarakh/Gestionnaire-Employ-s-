package controller;

import dao.EmployeeDAOImpl;
import model.Employee;
import services.EmployeeService;
import services.EmployeeServiceImpl;
import util.Validation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeServiceImpl(new EmployeeDAOImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Employee employee = employeeService.getEmployee(id);
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("/view/editEmployee.jsp").forward(request, response);
        } else {
            List<Employee> employees = employeeService.getAllEmployes();
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("/view/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("add".equals(action)) {
            addEmployee(req, resp);
        } else if ("update".equals(action)) {
            updateEmployee(req, resp);
        } else if ("delete".equals(action)) {
            deleteEmployee(req, resp);
        }
    }

    private void addEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String poste = req.getParameter("poste");
        String phone = req.getParameter("phone");
        String departement = req.getParameter("departement");


        Employee employee = new Employee(name, email, poste, phone, departement);
        employeeService.addEmployee(employee);

        resp.sendRedirect("employees");
    }

    private void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String poste = req.getParameter("poste");
        String phone = req.getParameter("phone");
        String departement = req.getParameter("departement");

        // Validation des champs
        if (!Validation.isNameValid(name)) {
            req.setAttribute("error", "Le nom est requis.");
            req.getRequestDispatcher("view/editEmployee.jsp").forward(req, resp);
            return;
        }
        if (!Validation.isEmailValid(email)) {
            req.setAttribute("error", "Email invalide.");
            req.getRequestDispatcher("view/editEmployee.jsp").forward(req, resp);
            return;
        }
        if (!Validation.isPhoneValid(phone)) {
            req.setAttribute("error", "Numéro de téléphone invalide.");
            req.getRequestDispatcher("view/editEmployee.jsp").forward(req, resp);
            return;
        }
        if (!Validation.isDepartmentValid(departement)) {
            req.setAttribute("error", "Le département est requis.");
            req.getRequestDispatcher("view/editEmployee.jsp").forward(req, resp);
            return;
        }
        if (!Validation.isPostValid(poste)) {
            req.setAttribute("error", "Le poste est requis.");
            req.getRequestDispatcher("view/editEmployee.jsp").forward(req, resp);
            return;
        }

        // Mettre à jour l'employé
        Employee employee = new Employee(id, name, email, poste, phone, departement);
        employeeService.updateEmployee(id, employee);

        resp.sendRedirect("index.jsp");
    }

    private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        employeeService.deleteEmployee(id);
        resp.sendRedirect("employees");
    }
}
