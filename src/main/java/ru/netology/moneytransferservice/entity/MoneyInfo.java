package ru.netology.moneytransferservice.entity;

import lombok.Data;

@Data
public class MoneyInfo {

    private double value;
    private String currency;
    private double fee;

}
