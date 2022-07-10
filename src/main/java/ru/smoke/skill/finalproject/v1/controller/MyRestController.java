package ru.smoke.skill.finalproject.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.smoke.skill.finalproject.v1.model.Employee;
import ru.smoke.skill.finalproject.v1.model.Operation;
import ru.smoke.skill.finalproject.v1.model.Transfer;
import ru.smoke.skill.finalproject.v1.service.EmployeeService;
import ru.smoke.skill.finalproject.v1.service.OperationsService;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
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
    public String getBalance(@PathVariable Long id){
        System.out.println(id);
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
        BigDecimal Balance = BigDecimal.valueOf(0);
        try {Balance = employeeService.getBalance(employee.getId());
        } catch(EntityNotFoundException e)
        {
            return "0 { Абонента с таким ID не найден }";
        }
        catch (Exception e){
            return "ошибка 0 "+ "{"+ e +"}";
        }
        BigDecimal TakeMoney = employee.getBalance();
        if (TakeMoney.compareTo(BigDecimal.ZERO)<=0){
            return "0 {Не корректная сумма}";
        }
        if(Balance.compareTo(TakeMoney)==1){
            employee.setBalance(Balance.subtract(TakeMoney));
            employeeService.saveEmployee(employee);
            saveOperation(employee.getId(), 1,employee.getBalance());
            return "Успешно";
        }return "Ошибка 0 {Недостаточно средств}";
    }
    @PostMapping("/putmoney")
    @ResponseStatus(HttpStatus.CREATED)
    public String putMoney(@RequestBody Employee employee){
        BigDecimal Balance = BigDecimal.valueOf(0);
        try {
            Balance = employeeService.getBalance(employee.getId());
        } catch(EntityNotFoundException e)
        {
            return "ошибка 0 { Абонента с таким ID не найден }";
        }
        catch (Exception e){
            return "ошибка 0"+ "{ " + e +" }";
        }
        BigDecimal PutMoney = employee.getBalance();
        if (PutMoney.compareTo(BigDecimal.ZERO)<=0){
            return "0 Не корректная сумма вклада";
        }
            employee.setBalance(Balance.add(PutMoney));
            employeeService.saveEmployee(employee);
            saveOperation(employee.getId(), 2,employee.getBalance());

        return "1 Успешно";
    }


    public void saveOperation(Long id, int type, BigDecimal balance){
        LocalDate operation_date = LocalDate.now();
        Operation operations = new Operation(id,type,balance, operation_date);
        operationsService.Saveoperation(operations);
    }
    @GetMapping("/getoperations/{id}/date")
    public List<Operation> test(@PathVariable long id,
                                 @RequestParam (value = "dateFrom", required = false) LocalDate dateFrom,
                                 @RequestParam (value = "dateTo", required = false) LocalDate dateTo){
        return operationsService.findSubscriberById(id, dateFrom, dateTo);
    }

    @PostMapping("/transfermoney")
    void transferMoney(@RequestBody Transfer transfer){
        Long senderId = transfer.getSenderId();
        Long recieverId = transfer.getRecieverId();
        BigDecimal Money = transfer.getMoney();
        employeeService.transferMoney(recieverId, senderId,Money);

    }


}
