package ru.smoke.skill.finalproject.v1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smoke.skill.finalproject.v1.model.Operations;

@Repository
public interface OperationRepo extends JpaRepository<Operations, Integer> {
}
