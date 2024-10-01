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

}
