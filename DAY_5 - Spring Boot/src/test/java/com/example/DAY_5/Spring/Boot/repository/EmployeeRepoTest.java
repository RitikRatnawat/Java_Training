package com.example.DAY_5.Spring.Boot.repository;

import com.example.DAY_5.Spring.Boot.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepoTest
{
    @Autowired
    private EmployeeRepo employeeRepo;
    private Employee employee;

    @BeforeEach
    public void setUp()
    {
        this.employee = new Employee(2, "Aman Jain", "Manager", 80000.00);
    }

    @Test
    public void testSaveEmployee()
    {
        Employee employee = new Employee(1, "Ritik Ratnawat", "SDE", 60000.00);
        Employee savedEmployee = employeeRepo.save(employee);

        Assertions.assertNotNull(savedEmployee);
        Assertions.assertEquals(savedEmployee.getEmployeeID(), employee.getEmployeeID());
    }

    @Test
    public void testFindById()
    {
        Employee employee = new Employee(1, "Ritik Ratnawat", "SDE", 60000.00);
        employeeRepo.save(employee);

        Employee employeebyId = employeeRepo.findById(employee.getEmployeeID()).get();

        Assertions.assertNotNull(employeebyId);
    }

    @Test
    public void testFindByDesignation()
    {
        Employee employee = new Employee(1, "Ritik Ratnawat", "SDE", 60000.00);
        employeeRepo.save(employee);
        employeeRepo.save(this.employee);

        List<Employee> employeeByDesignation = employeeRepo.findByDesignation("SDE");

        Assertions.assertNotNull(employeeByDesignation);
        Assertions.assertTrue(employeeByDesignation.size() > 0);
    }

    @Test
    public void testFindAllEmployeesHaveGoodSalary()
    {
        Employee employee = new Employee(1, "Ritik Ratnawat", "SDE", 40000.00);
        employeeRepo.save(employee);
        employeeRepo.save(this.employee);

        List<Employee> goodSalaryEmployees = employeeRepo.findAllEmployeesHavingGoodSalary();

        Assertions.assertNotNull(goodSalaryEmployees);
        Assertions.assertTrue(goodSalaryEmployees.size() > 0);
    }

    @Test
    public void testFindAll()
    {
        Employee employee = new Employee(1, "Ritik Ratnawat", "SDE", 40000.00);
        employeeRepo.save(employee);
        employeeRepo.save(this.employee);

        List<Employee> allEmployess = employeeRepo.findAll();

        Assertions.assertNotNull(allEmployess);
        Assertions.assertTrue(allEmployess.size() > 0);
    }

    @Test
    public void testDeleteById()
    {
        Employee employee = new Employee(1, "Ritik Ratnawat", "SDE", 40000.00);
        employeeRepo.save(employee);

        employeeRepo.deleteById(employee.getEmployeeID());

        Optional<Employee> deletedEmployee = employeeRepo.findById(employee.getEmployeeID());

        Assertions.assertFalse(deletedEmployee.isPresent());
    }
}
