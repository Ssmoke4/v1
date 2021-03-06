package ru.smoke.skill.finalproject.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smoke.skill.finalproject.v1.model.Operation;
import ru.smoke.skill.finalproject.v1.repo.OperationRepo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class OperationsServiceImpl implements OperationsService{
    @Autowired
    OperationRepo operationRepo;


    @Override
    public void Saveoperation(Operation oper) {
        operationRepo.save(oper);

    }


    @Override
    public List<Operation> findSubscriberById(long id, LocalDate dateFrom, LocalDate dateTo) {
        List<Operation> result = operationRepo.findSubscriberById(id, dateFrom, dateTo);
        return result;
    }
}
