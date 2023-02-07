package com.example.DAY_5.Spring.Boot.service;

import com.example.DAY_5.Spring.Boot.model.Employee;
import com.example.DAY_5.Spring.Boot.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepo employeeRepo;

    public String createEmployee(Employee employee)
    {
        if(this.employeeRepo.existsById(employee.getEmployeeID()))
        {
            return "Employee already present";
        }
        else
        {
            this.employeeRepo.save(employee);
            return "Employee Details Added";
        }
    }

    public Employee getEmployeeById(Integer id)
    {
        return this.employeeRepo.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<Employee> getEmployeeByDesignation(String designation)
    {
        return this.employeeRepo.findByDesignation(designation);
    }

    public List<Employee> getEmployeesHaveGoodSalary()
    {
        return this.employeeRepo.findAllEmployeesHavingGoodSalary();
    }

    public List<Employee> getAllEmployees()
    {
        return this.employeeRepo.findAll();
    }

    public String updateEmployee(Employee employee, Integer id)
    {
        Optional<Employee> employeeData = this.employeeRepo.findById(id);

        if(employeeData.isPresent())
        {
            Employee e = employeeData.get();
            e.setEmployeeName(employee.getEmployeeName());
            e.setDesignation(employee.getDesignation());
            e.setSalary(employee.getSalary());
            this.employeeRepo.save(e);

            return "Employee details updated";
        }

        return "Employee not found";
    }

    public String deleteEmployee(Integer id)
    {
        if(this.employeeRepo.existsById(id))
        {
            this.employeeRepo.deleteById(id);
            return "Employee deleted successfully";
        }

        return "Employee Not Found";
    }
}
