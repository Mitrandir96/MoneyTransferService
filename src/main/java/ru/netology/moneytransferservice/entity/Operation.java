package ru.netology.moneytransferservice.entity;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Size(min = 16, message = "Номер карты меньше 16 символов")
    private String cardFromNumber;

    @Size(min = 4, message = "Укажите в формате ММ/ГГ")
    private String cardFromValidTill;

    @Size(min = 3, message = "CVV код должен быть минимум 3 знака")
    private String cardFromCVV;

    @Size(min = 16, message = "Номер карты меньше 16 символов")
    private String cardToNumber;

    @Valid
    private MoneyInfo amount;

    private String operationId;

    private LocalDateTime dateTime;

    private String result;


}
