package com.endava.jpa.main;

import com.endava.jpa.model.Department;
import com.endava.jpa.model.Employee;
import com.endava.jpa.service.impl.JPAMainService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        JPAMainService jpaMainService = (JPAMainService) context.getBean("JPAMainService");

        /**
         * Comment unneeded method invocations.
         */
        jpaMainService.findDepartment(1);
        jpaMainService.findDepartmentByName();


        jpaMainService.insertDepartment(new Department());

        jpaMainService.updateDepartment(1);
        jpaMainService.findDepartment(1);
        Department department = new Department("Development");
        jpaMainService.insertDepartment(department);

        jpaMainService.deleteDepartment(1);

        //Employee employee = new Employee("Gogu", 2000, "Barca", "Bucuresti", "Romania", "593837", data, department);
        Employee employee2 = new Employee("Ion", 3000, "Ravna", "Cluj", "Romania", "12321", new Date(), department);
        jpaMainService.insertEmployee(employee2);

        jpaMainService.getEmployeesFromCity("Bucuresti");

        jpaMainService.giveSalaryRaise(3);
        jpaMainService.deleteEmployee(4);


    }
}
