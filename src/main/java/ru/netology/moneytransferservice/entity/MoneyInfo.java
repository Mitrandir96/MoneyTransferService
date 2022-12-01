package ru.netology.moneytransferservice.entity;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
public class MoneyInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Positive(message = "Сумма перевода должна быть больше 0")
    private double value;

    private String currency;

    private double fee;

}
