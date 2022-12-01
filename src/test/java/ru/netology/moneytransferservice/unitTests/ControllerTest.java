package ru.netology.moneytransferservice.unitTests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.moneytransferservice.controller.Controller;
import ru.netology.moneytransferservice.entity.MoneyInfo;
import ru.netology.moneytransferservice.entity.Operation;
import ru.netology.moneytransferservice.repository.Repository;
import ru.netology.moneytransferservice.service.Service;

public class ControllerTest {
    private final String cardFromNumber = "1111111111111111";
    private final String cardToNumber = "2222222222222222";


    @Test
    void test_transfer() {
        var service = Mockito.mock(Service.class);
        var amount = new MoneyInfo();
        var operation = new Operation();

        Mockito.when(service.postTransfer(operation)).thenReturn("5");

        amount.setValue(100);
        amount.setCurrency("RUR");

        operation.setCardFromCVV("123");
        operation.setCardFromNumber(cardFromNumber);
        operation.setCardToNumber(cardToNumber);
        operation.setCardFromValidTill("1234");
        operation.setAmount(amount);

        var controller = new Controller(service);

        var actual = controller.postTransfer(operation);
        var expected = "5";

        Assert.assertEquals(expected, actual);

        Mockito.verify(service, Mockito.times(1)).postTransfer(operation);

    }
}
