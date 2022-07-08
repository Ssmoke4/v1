package ru.smoke.skill.finalproject.v1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smoke.skill.finalproject.v1.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
public List<Employee> findAllBy();
public Employee getById(Long id);
}
