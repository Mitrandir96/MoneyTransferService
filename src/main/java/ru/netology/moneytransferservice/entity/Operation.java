package ru.netology.moneytransferservice.entity;

import lombok.Data;

@Data
public class Operation {

    private String cardFromNumber;
    private String cardFromValidTill;
    private String cardFromCVV;
    private String cardToNumber;
    private MoneyInfo amount;
    private String operationId;

}
