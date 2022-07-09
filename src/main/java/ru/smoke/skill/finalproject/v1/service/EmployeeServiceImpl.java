package ru.smoke.skill.finalproject.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smoke.skill.finalproject.v1.model.Employee;
import ru.smoke.skill.finalproject.v1.repo.EmployeeRepo;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employees;
    }

    public BigDecimal getBalance(Long id) {
        Employee employee = employeeRepo.getById(id);
        return employee.getBalance();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void transferMoney(Long recieverId, Long senderId, BigDecimal Money) {
        Employee senderEmployee = employeeRepo.getById(senderId);
        Employee recieverEmployee = employeeRepo.getById(recieverId);
        recieverEmployee.setBalance(recieverEmployee.getBalance().add(Money));
        senderEmployee.setBalance(senderEmployee.getBalance().subtract(Money));
        System.out.println("Успешно");
    }


}
