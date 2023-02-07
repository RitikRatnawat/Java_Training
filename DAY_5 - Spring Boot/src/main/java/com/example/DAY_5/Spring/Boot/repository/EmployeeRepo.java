package com.example.DAY_5.Spring.Boot.repository;

import com.example.DAY_5.Spring.Boot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>
{
    public List<Employee> findByDesignation(String designation);

    @Query(value = "SELECT * FROM EMPLOYEE e WHERE e.salary >= 50000", nativeQuery = true)
    public List<Employee> findAllEmployeesHavingGoodSalary();
}
