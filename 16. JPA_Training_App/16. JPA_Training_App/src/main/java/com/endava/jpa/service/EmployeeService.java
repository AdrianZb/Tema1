package com.endava.jpa.service;

import com.endava.jpa.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee find(long id);

    public List<Employee> find(String employeeName);

    public void save(Employee toBeSaved);

    public void update(Employee toBeUpdated);

    public void remove(Employee toBeRemoved);

    public List<Employee> getEmployeesFromBucharest(String cityName);

}
