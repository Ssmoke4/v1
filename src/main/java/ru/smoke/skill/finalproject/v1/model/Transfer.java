package ru.smoke.skill.finalproject.v1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Transfer {
    private Long senderId;
    private Long recieverId;
    private BigDecimal Money;
}
