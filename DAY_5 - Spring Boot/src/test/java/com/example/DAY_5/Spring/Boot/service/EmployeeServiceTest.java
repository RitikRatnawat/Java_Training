package com.example.DAY_5.Spring.Boot.service;

import com.example.DAY_5.Spring.Boot.model.Employee;
import com.example.DAY_5.Spring.Boot.repository.EmployeeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepo employeeRepo;
    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    public void setUp() {
        this.employee = new Employee(2, "Aman Jain", "SDE", 80000.00);
    }

    @Test
    public void testSuccessfulCreateEmployee() {
        Employee employee = new Employee(1, "Ritik Ratnawat", "SDE", 60000.00);

        when(employeeRepo.existsById(employee.getEmployeeID())).thenReturn(false);

        String result = employeeService.createEmployee(employee);
        System.out.println(result);

        Assertions.assertEquals(result, "Employee Details Added");
    }

    @Test
    public void testUnsuccessfulCreateEmployee() {
        Employee employee = new Employee(1, "Ritik Ratnawat", "SDE", 60000.00);

        when(employeeRepo.existsById(employee.getEmployeeID())).thenReturn(true);

        String result = employeeService.createEmployee(employee);
        System.out.println(result);

        Assertions.assertEquals(result, "Employee already present");
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = new Employee(1, "Ritik Ratnawat", "SDE", 60000.00);

        Assertions.assertThrows(NullPointerException.class, () -> {
            employeeService.getEmployeeById(employee.getEmployeeID());
        });
    }

    @Test
    public void testGetEmployeeByDesignation()
    {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee(1, "Ritik Ratnawat", "SDE", 60000.00);

        employees.add(employee);
        employees.add(this.employee);

        when(employeeRepo.findByDesignation("SDE")).thenReturn(employees);

        List<Employee> employeesByDesignation = employeeService.getEmployeeByDesignation("SDE");

        Assertions.assertNotNull(employeesByDesignation);
        Assertions.assertTrue(employeesByDesignation.size() > 0);
    }

    @Test
    public void testGetEmployeesHaveGoodSalary()
    {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee(1, "Ritik Ratnawat", "SDE", 60000.00);

        employees.add(employee);
        employees.add(this.employee);

        when(employeeRepo.findAllEmployeesHavingGoodSalary()).thenReturn(employees);

        List<Employee> goodSalaryEmployees = employeeService.getEmployeesHaveGoodSalary();

        Assertions.assertNotNull(goodSalaryEmployees);
        Assertions.assertTrue(goodSalaryEmployees.size() > 0);
    }

    @Test
    public void testGetAllEmployees()
    {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee(1, "Ritik Ratnawat", "SDE", 60000.00);

        employees.add(employee);
        employees.add(this.employee);

        when(employeeRepo.findAll()).thenReturn(employees);

        List<Employee> allEmployees = employeeService.getAllEmployees();

        Assertions.assertNotNull(allEmployees);
        Assertions.assertTrue(allEmployees.size() > 0);
    }

    @Test
    public void testSuccessfulUpdateEmployee()
    {
        Optional<Employee> employee = Optional.of(this.employee);
        Employee emp = new Employee(1, "Ritik Ratnawat", "SDE", 60000.00);

        when(employeeRepo.findById(this.employee.getEmployeeID())).thenReturn(employee);

        String result = employeeService.updateEmployee(emp, this.employee.getEmployeeID());
        System.out.println(result);

        Assertions.assertEquals(result, "Employee details updated");
    }

    @Test
    public void testUnsuccessfulUpdateEmployee()
    {
        when(employeeRepo.findById(this.employee.getEmployeeID())).thenReturn(Optional.empty());

        String result = employeeService.updateEmployee(this.employee, this.employee.getEmployeeID());
        System.out.println(result);

        Assertions.assertEquals(result, "Employee not found");
    }

     @Test
     public void testSuccessfulDeleteEmployee()
     {
         when(employeeRepo.existsById(this.employee.getEmployeeID())).thenReturn(true);

         String result = employeeService.deleteEmployee(this.employee.getEmployeeID());
         System.out.println(result);

         Assertions.assertEquals(result, "Employee deleted successfully");
     }

    @Test
    public void testUnsuccessfulDeleteEmployee()
    {
        when(employeeRepo.existsById(this.employee.getEmployeeID())).thenReturn(false);

        String result = employeeService.deleteEmployee(this.employee.getEmployeeID());
        System.out.println(result);

        Assertions.assertEquals(result, "Employee Not Found");
    }
}
