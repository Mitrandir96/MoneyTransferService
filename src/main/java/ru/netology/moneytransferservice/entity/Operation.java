package ru.netology.moneytransferservice.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cardFromNumber;
    private String cardFromValidTill;
    private String cardFromCVV;
    private String cardToNumber;
    private MoneyInfo amount;
    private String operationId;

}
