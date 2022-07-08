package ru.smoke.skill.finalproject.v1.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "operation")
@Data
@NoArgsConstructor
public class Operation {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long subscriber_id;

    @Column
    private int type_operation;

    @Column
    private BigDecimal sum_operation;

    @Column
    private LocalDate operation_date;


    public Operation(Long subscriber_id, int type_operation, BigDecimal sum_operation, LocalDate operation_date) {
        this.subscriber_id = subscriber_id;
        this.type_operation = type_operation;
        this.sum_operation = sum_operation;
        this.operation_date = operation_date;

    }

    @Override
    public String toString() {
        return "Operations{" +
                "subscriber_id=" + subscriber_id +
                ", type_operation=" + type_operation +
                ", sum_operation=" + sum_operation +
                '}';
    }
}
