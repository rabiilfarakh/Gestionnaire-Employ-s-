package dao;

import model.Employee;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class Services {

    public void addEmployee(Employee employee){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
    }

    public Employee getEmployee(Integer idEmployee){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Employee employee = (Employee) session.load(Employee.class, idEmployee);

        return employee;
    }

    public List<Employee> getAllEmployes() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Employee> employes = session.createQuery("FROM Employee", Employee.class).list();
        session.getTransaction().commit();
        return employes;
    }

    public void deleteEmployee(Integer idEmployee) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(session.get(Employee.class, idEmployee));
        session.getTransaction().commit();
    }

}
