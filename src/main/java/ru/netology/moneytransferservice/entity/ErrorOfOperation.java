package ru.netology.moneytransferservice.entity;

import lombok.Data;

@Data
public class ErrorOfOperation {

    private String message;
    private int id;
}
