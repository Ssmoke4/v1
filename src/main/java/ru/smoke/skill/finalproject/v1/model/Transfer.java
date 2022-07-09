package ru.smoke.skill.finalproject.v1.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Transfer {
    private Long senderId;
    private Long recieverId;
    BigDecimal Money;



}
