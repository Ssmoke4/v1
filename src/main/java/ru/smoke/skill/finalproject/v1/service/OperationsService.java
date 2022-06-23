package ru.smoke.skill.finalproject.v1.service;

import ru.smoke.skill.finalproject.v1.model.Operation;

import java.time.LocalDate;
import java.util.List;


public interface OperationsService {

    void Saveoperation(Operation oper);
//    List<Operations> getOperationsByDate(Date start, Date end);
    List<Operation> findSubscriberById(int id, LocalDate dateFrom, LocalDate dateTo);

}
