package com.example.DAY_5.Spring.Boot.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Employee
{
    @Id
    private Integer employeeID;
    private String employeeName;
    private String designation;
    private Double salary;

    @Transient
    private String companyName = "ConsultAdd Inc.";

    public Employee(Integer employeeID, String employeeName, String designation, Double salary) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.designation = designation;
        this.salary = salary;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
