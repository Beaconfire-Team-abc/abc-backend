package com.beaconfireabc.profile.dao;


import com.beaconfireabc.profile.entity.Employee;


import java.util.List;


public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    Employee setEmployee(Employee employee);


}