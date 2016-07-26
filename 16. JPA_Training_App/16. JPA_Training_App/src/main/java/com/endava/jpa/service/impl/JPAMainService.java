package com.endava.jpa.service.impl;

import com.endava.jpa.model.Department;
import com.endava.jpa.model.Employee;
import com.endava.jpa.service.DepartmentService;
import com.endava.jpa.service.EmployeeService;
import com.endava.jpa.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAMainService {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;

    //-------------------------------------- Department -----------------------------/

    public Department findDepartment(int id) {
        Department department = departmentService.find(id);
        System.out.println(department);
        return department;
    }

    public void findDepartmentByName() {
        List<Department> departments = departmentService.find("Prj");
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    /**
     * Define a new department entity and insert it into the corresponding table
     */
    public void insertDepartment(Department department) {
        departmentService.save(department);
    }

    /**
     * Search for an existing department, update its name and save it using the new name
     */
    public void updateDepartment(int id) {
        Department department = findDepartment(id);
        department.setName("Human Resources");
        departmentService.update(department);
    }

    /**
     * Delete an existing department from the database
     */
    public void deleteDepartment(int id) {
        Department department = findDepartment(1);
        departmentService.remove(department);
    }

    //-------------------------------------- Employee -----------------------------/

    /**
     * Create a new employee entity and save it into the corresponding table
     */
    public void insertEmployee(Employee employee) {
        employeeService.save(employee);
    }

    public Employee findEmployeeById(int id) {
        return employeeService.find(id);
    }


    /**
     * Print to stdout all the employees from 'Bucharest', which belong to the department with id = 1.
     * Make sure that there are more than two employees in Bucharest which belong to the department with id=1 when populating the DB.
     * ! Use a join query.
     */
    public void getEmployeesFromCity(String cityName) {
        List<Employee> employees = employeeService.getEmployeesFromBucharest(cityName);
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    /**
     * Give a salary raise(+10%) for all employees that work in the 'Endava' project (project name = 'Endava').
     * ! Use a join query.
     */
    public void giveSalaryRaise(int id) {
        Employee employee = findEmployeeById(id);
        employee.setSalary(2500.0);
        employeeService.update(employee);
    }


    //-------------------------------------- Project -----------------------------/

    /**
     * Add a new employee to the 'Endava' project. (project name = 'Endava')
     */
    public void addEmployee() {
    }

    /**
     * Remove an employee from a project which has 'John Doe' as project manager.
     */
    public void deleteEmployee(int id) {
        Employee employee = findEmployeeById(id);
        employeeService.remove(employee);
    }

}
