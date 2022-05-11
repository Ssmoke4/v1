package ru.smoke.skill.finalproject.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smoke.skill.finalproject.v1.model.Employee;
import ru.smoke.skill.finalproject.v1.repo.EmployeeRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        System.out.println(employees);
        return employees;
    }

    public Integer getBalance(Integer id) {
        Employee employee = employeeRepo.getById(id);
        return employee.getBalance();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepo.save(employee);
    }


}
