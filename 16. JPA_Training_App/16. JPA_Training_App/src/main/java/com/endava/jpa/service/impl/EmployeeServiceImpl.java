package com.endava.jpa.service.impl;

import com.endava.jpa.dao.EmployeeDao;
import com.endava.jpa.model.Employee;
import com.endava.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee find(long id) {
        return employeeDao.find(id);
    }

    public List<Employee> find(String employeeName) {
        return null;
    }

    public void save(Employee toBeSaved) {
        employeeDao.save(toBeSaved);
    }

    public void update(Employee toBeUpdated) {
        employeeDao.update(toBeUpdated);
    }

    public void remove(Employee toBeRemoved) {
        employeeDao.remove(toBeRemoved);
    }

    public List<Employee> getEmployeesFromBucharest(String cityName) {
        return employeeDao.getEmployeesFromBucharest(cityName);
    }
}
