package ru.smoke.skill.finalproject.v1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.smoke.skill.finalproject.v1.model.Operations;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface OperationRepo extends JpaRepository<Operations, Integer> {

    @Query("from Operations o where o.subscriber_id=:id and o.operation_date>=:dateFrom and o.operation_date< :dateTo")
    List<Operations> findSubscriberById(@Param("id") Integer id,
                                        @Param("dateFrom")Date dateFrom,
                                        @Param("dateTo")Date dateTo);
}
