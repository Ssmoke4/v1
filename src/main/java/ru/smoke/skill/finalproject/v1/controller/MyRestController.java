package ru.smoke.skill.finalproject.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.smoke.skill.finalproject.v1.model.Employee;
import ru.smoke.skill.finalproject.v1.service.EmployeeService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/Employees")
    public List<Employee> AllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }

    @GetMapping ("/getBalance/{id}")
    public String getBalance(@PathVariable int id){
        try {
            return ("Баланс абонента: "+employeeService.getBalance(id));
        }
        catch (Exception e){
            return "Ошибка "+ -1 + " "+ "{" + e + "}";
        }
    }
    @PostMapping("/takeMoney")
    public String takeMoney(@RequestBody Employee employee){
        int Balance = 0;
        try {
            Balance = employeeService.getBalance(employee.getId());
        } catch(EntityNotFoundException e)
        {
            return "0 { Абонента с таким ID не найден }";
        }
        catch (Exception e){
            return "ошибка 0 "+ "{"+ e +"}";
        }
        int TakeMoney = employee.getBalance();
        if (TakeMoney<=0){
            return "0 {Не корректная сумма}";
        }
        if(Balance>=TakeMoney){
            employee.setBalance(Balance-TakeMoney);
            employeeService.saveEmployee(employee);
            return "Успешно";
        }return "Ошибка 0 {Недостаточно средств}";
    }
    @PostMapping("/putMoney")
    public String putMoney(@RequestBody Employee employee){
        int Balance = 0;
        try {
            Balance = employeeService.getBalance(employee.getId());
        } catch(EntityNotFoundException e)
        {
            return "ошибка 0 { Абонента с таким ID не найден }";
        }
        catch (Exception e){
            return "ошибка 0"+ "{ " + e +" }";
        }
        int PutMoney = employee.getBalance();
        if (PutMoney<=0){
            return "0 Не корректная сумма вклада";
        }
            employee.setBalance(Balance+PutMoney);
            employeeService.saveEmployee(employee);
            return "1 Успешно";
    }

}
