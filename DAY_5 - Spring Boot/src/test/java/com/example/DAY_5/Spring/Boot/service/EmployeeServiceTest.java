package com.example.DAY_5.Spring.Boot.service;

import com.example.DAY_5.Spring.Boot.repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceTest
{
    @Mock
    private EmployeeRepo employeeRepo;
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testCreateEmployee()
    {
        
    }
}
