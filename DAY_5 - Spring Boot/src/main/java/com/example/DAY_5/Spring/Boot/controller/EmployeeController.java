package com.example.DAY_5.Spring.Boot.controller;
import com.example.DAY_5.Spring.Boot.model.Employee;
import com.example.DAY_5.Spring.Boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all-employees")
    private List<Employee> getAllEmployees()
    {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    private ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id)
    {
        try{
            return new ResponseEntity<>(this.employeeService.getEmployeeById(id), HttpStatus.OK);
        }
        catch (NullPointerException e)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employee/designation")
    private ResponseEntity<List<Employee>> getEmployeeByDesignation(@RequestParam String designation)
    {
        List<Employee> employees = this.employeeService.getEmployeeByDesignation(designation);

        if(employees.size() == 0)
            return new ResponseEntity<>(employees, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employee/salary")
    private ResponseEntity<List<Employee>> getEmployeesHaveGoodSalary()
    {
        List<Employee> employees = this.employeeService.getEmployeesHaveGoodSalary();

        if(employees.size() == 0)
            return new ResponseEntity<>(employees, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/create-employee")
    private ResponseEntity<String> createEmployeeData(@RequestBody Employee employee)
    {
        String result = this.employeeService.createEmployee(employee);

        if(result.equals("Employee already present"))
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update-employee/{id}")
    private ResponseEntity<String> updateEmployeeData(@RequestBody Employee employee, @PathVariable("id") Integer id)
    {
        String result = this.employeeService.updateEmployee(employee, id);

        if(result.equals("Employee details updated"))
            return new ResponseEntity<>(result, HttpStatus.OK);

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete-employee")
    private ResponseEntity<String> deleteEmployeeData(@RequestParam Integer id)
    {
        String result = this.employeeService.deleteEmployee(id);

        if(result.equals("Employee deleted successfully"))
            return new ResponseEntity<>(result, HttpStatus.OK);

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
