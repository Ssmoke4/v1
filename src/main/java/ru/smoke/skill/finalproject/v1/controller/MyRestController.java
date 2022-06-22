package ru.smoke.skill.finalproject.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.smoke.skill.finalproject.v1.model.Employee;
import ru.smoke.skill.finalproject.v1.model.Operations;
import ru.smoke.skill.finalproject.v1.service.EmployeeService;
import ru.smoke.skill.finalproject.v1.service.OperationsService;

import javax.persistence.EntityNotFoundException;
import javax.xml.bind.SchemaOutputResolver;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OperationsService operationsService;

    @GetMapping("/employees")
    public List<Employee> AllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping ("/getbalance/{id}")
    public String getBalance(@PathVariable int id){
        try {
            saveOperation(id,0,employeeService.getBalance(id));
            return ("Баланс абонента: "+employeeService.getBalance(id));

        }
        catch (Exception e){
            return "Ошибка "+ -1 + " "+ "{" + e + "}";
        }
    }
    @PostMapping("/takemoney")
    public String takeMoney(@RequestBody Employee employee){
        int Balance = 0;
        try {Balance = employeeService.getBalance(employee.getId());
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
            saveOperation(employee.getId(), 1,employee.getBalance());
            return "Успешно";
        }return "Ошибка 0 {Недостаточно средств}";
    }
    @PostMapping("/putmoney")
    @ResponseStatus(HttpStatus.CREATED)
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
            saveOperation(employee.getId(), 2,employee.getBalance());

        return "1 Успешно";
    }


    public void saveOperation(int id,int type,int balance){
        Operations operations = new Operations(id,type,balance);
        operationsService.Saveoperation(operations);
    }
    @GetMapping("/getoperations/{id}/date")
    public List<Operations> test(@PathVariable int id,
                                 @RequestParam ("dateFrom") LocalDate dateFrom,
                                 @RequestParam ("dateTo") LocalDate dateTo){
        return operationsService.findSubscriberById(id, dateFrom, dateTo);
    }


}
