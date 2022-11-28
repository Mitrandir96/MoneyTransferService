package ru.netology.moneytransferservice.entity;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cardFromNumber;
    private String cardFromValidTill;
    private String cardFromCVV;
    private String cardToNumber;
    private MoneyInfo amount;
    private String operationId;
    private LocalDateTime dateTime;
    private String result;

}
