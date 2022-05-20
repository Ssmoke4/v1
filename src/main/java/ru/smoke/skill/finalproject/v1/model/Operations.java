package ru.smoke.skill.finalproject.v1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "operation")
@Data
@NoArgsConstructor
public class Operations {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int subscriber_id;

    @Column
    private int type_operation;

    @Column
    private int sum_operation;

//    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
//    @Column
//    private int operation_date;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "subscriber_id")
//    private Employee employee;

    public Operations(int subscriber_id, int type_operation, int sum_operation) {
        this.subscriber_id = subscriber_id;
        this.type_operation = type_operation;
        this.sum_operation = sum_operation;
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
