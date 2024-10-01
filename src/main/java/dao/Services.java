package dao;

import model.Employee;
import org.hibernate.Session;
import util.HibernateUtil;

public class Services {

    public void addEmployee(Employee employee){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
    }
}
