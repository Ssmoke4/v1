package ru.smoke.skill.finalproject.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smoke.skill.finalproject.v1.model.Operations;
import ru.smoke.skill.finalproject.v1.repo.OperationRepo;

import java.sql.Date;
import java.util.List;

@Service
public class OperationsServiceImpl implements OperationsService{
    @Autowired
    OperationRepo operationRepo;

//    @Override
//    public List<Operations> getAllOperations(Integer id) {
//        List<Operations> operations = operationRepo.findBySubscriber_id(id);
//        return operations;
//    }

    @Override
    public void Saveoperation(Operations oper) {
        operationRepo.save(oper);

    }

    @Override
    public List<Operations> getOperationList(Date start, Date end) {
        List <Operations> operations = operationRepo.findByDateBetween(start,end);
        return operations;
    }
}
