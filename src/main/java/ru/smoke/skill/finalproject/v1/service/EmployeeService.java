package ru.smoke.skill.finalproject.v1.service;

import ru.smoke.skill.finalproject.v1.model.Employee;

import java.math.BigDecimal;
import java.util.List;


public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public BigDecimal getBalance(Long id);
    public void saveEmployee(Employee employee);
}
