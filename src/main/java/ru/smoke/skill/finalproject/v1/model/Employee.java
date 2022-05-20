package ru.smoke.skill.finalproject.v1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "subscribers")
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private int balance;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
//    private List<Operations> operationsList;
//
//   public void AddOperationsToEmployee(Operations oper){
//       if (operationsList == null){
//           operationsList = new ArrayList<>();
//       }
//       operationsList.add(oper);
//   }
}
