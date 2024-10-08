package dao;

import dao.EmployeeDAO;
import model.Employee;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.List;
import java.util.Optional;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Optional<Employee> getEmployee(Integer idEmployee) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Employee employee = session.get(Employee.class, idEmployee);
            session.getTransaction().commit();
            return Optional.ofNullable(employee);
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<Employee> getAllEmployes() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            List<Employee> employees = session.createQuery("FROM Employee", Employee.class).list();
            session.getTransaction().commit();
            return employees;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<String> getDistinctDepartments() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            List<String> departments = session.createQuery("SELECT DISTINCT e.departement FROM Employee e", String.class).list();
            session.getTransaction().commit();
            return departments;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void deleteEmployee(Integer idEmployee) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Employee employee = session.get(Employee.class, idEmployee);
            if (employee != null) {
                session.delete(employee);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void updateEmployee(Integer idEmployee, Employee newEmployee) {
        if (newEmployee == null) {
            throw new IllegalArgumentException("New Employee cannot be null");
        }

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            Employee existingEmployee = session.get(Employee.class, idEmployee);
            if (existingEmployee != null) {
                existingEmployee.setName(newEmployee.getName());
                existingEmployee.setEmail(newEmployee.getEmail());
                existingEmployee.setPhone(newEmployee.getPhone());
                existingEmployee.setDepartement(newEmployee.getDepartement());
                existingEmployee.setPoste(newEmployee.getPoste());

                session.update(existingEmployee);
            } else {
                throw new IllegalArgumentException("Employee with ID " + idEmployee + " does not exist");
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }


    @Override
    public List<Employee> searchEmployees(String value) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            // Requête HQL pour rechercher dans plusieurs champs (nom, email, département, poste)
            String hql = "FROM Employee WHERE name LIKE :value OR email LIKE :value OR phone LIKE :value OR departement LIKE :value OR poste LIKE :value";
            var query = session.createQuery(hql, Employee.class);
            query.setParameter("value", "%" + value + "%");

            List<Employee> employees = query.list();
            session.getTransaction().commit();

            return employees;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<Employee> filterEmployees(String department) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            String hql = "FROM Employee WHERE departement LIKE :value";
            var query = session.createQuery(hql,Employee.class);
            query.setParameter("value", "%" + department + "%");

            List<Employee> employees = query.list();
            session.getTransaction().commit();

                return employees;
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
    }


}
