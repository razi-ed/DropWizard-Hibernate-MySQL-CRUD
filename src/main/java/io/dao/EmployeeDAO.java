package io.dao;

import io.core.Employee;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class EmployeeDAO extends AbstractDAO<Employee> {

    public EmployeeDAO(SessionFactory factory) {
        super(factory);
    }

    public List<Employee> getAll() {
        return (List<Employee>) currentSession().createCriteria(Employee.class).list();
    }


    public Employee findById(int id) {
        return (Employee) currentSession().get(Employee.class, id);
    }

    public void delete(Employee employee) {
        currentSession().delete(employee);
    }

    public void update(Employee employee) {
        currentSession().saveOrUpdate(employee);
    }

    public Employee insert(Employee employee) {
        System.out.println(employee);
        return persist(employee);
    }
}
