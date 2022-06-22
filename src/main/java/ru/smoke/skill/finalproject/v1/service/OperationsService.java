package ru.smoke.skill.finalproject.v1.service;

import ru.smoke.skill.finalproject.v1.model.Operations;

import java.time.LocalDate;
import java.util.List;


public interface OperationsService {

    void Saveoperation(Operations oper);
//    List<Operations> getOperationsByDate(Date start, Date end);
    List<Operations> findSubscriberById(int id, LocalDate dateFrom, LocalDate dateTo);

}
