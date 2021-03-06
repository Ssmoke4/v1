package ru.smoke.skill.finalproject.v1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.smoke.skill.finalproject.v1.model.Operation;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface OperationRepo extends JpaRepository<Operation, Integer> {

    @Query("from Operation o where o.subscriber_id=:id and o.operation_date>=:dateFrom and o.operation_date< :dateTo")
    List<Operation> findSubscriberById(@Param("id") long id,
                                        @Param("dateFrom")LocalDate dateFrom,
                                        @Param("dateTo")LocalDate dateTo);
}
