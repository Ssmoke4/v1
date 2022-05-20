package ru.smoke.skill.finalproject.v1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smoke.skill.finalproject.v1.model.Operations;

import java.awt.print.Pageable;
import java.sql.Date;
import java.util.List;

@Repository
public interface OperationRepo extends JpaRepository<Operations, Integer> {
public List<Operations> findByDateBetween(Date start, Date end);
}
