package ru.netology.moneytransferservice.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class MoneyInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private double value;
    private String currency;
    private double fee;

}
