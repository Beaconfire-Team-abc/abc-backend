package com.beaconfireabc.profile.dao.impl;

import com.beaconfireabc.profile.dao.AbstractHibernateDAO;
import com.beaconfireabc.profile.dao.EmployeeDAO;
import com.beaconfireabc.profile.entity.Employee;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository("employeeDao")
public class EmployeeDAOImpl extends AbstractHibernateDAO<Employee> implements EmployeeDAO {

    public EmployeeDAOImpl() { setClazz(Employee.class); }

    @Override
    public Employee getEmployeeById(int id) {
        return findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return findAll();
    }

    @Override
    public Employee setEmployee(Employee employee) {
        return save(employee);
    }
}
