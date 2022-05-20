package ru.smoke.skill.finalproject.v1.service;

import ru.smoke.skill.finalproject.v1.model.Employee;
import ru.smoke.skill.finalproject.v1.model.Operations;

import java.sql.Date;
import java.util.List;


public interface OperationsService {

    void Saveoperation(Operations oper);
    List<Operations> getOperationList(Date start, Date end);


}
