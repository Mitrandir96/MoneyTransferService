package ru.netology.moneytransferservice.unitTests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.moneytransferservice.dto.PostResponse;
import ru.netology.moneytransferservice.entity.MoneyInfo;
import ru.netology.moneytransferservice.entity.Operation;
import ru.netology.moneytransferservice.repository.Repository;
import ru.netology.moneytransferservice.service.Service;

public class ServiceTest {

    private final String cardFromNumber = "1111111111111111";
    private final String cardToNumber = "2222222222222222";


    @Test
    void test_transfer() {
        var repository = Mockito.mock(Repository.class);
        var amount = new MoneyInfo();
        var operation = new Operation();

        Mockito.when(repository.getAmountOfId()).thenReturn(5);

        amount.setValue(100);
        amount.setCurrency("RUR");

        operation.setCardFromCVV("123");
        operation.setCardFromNumber(cardFromNumber);
        operation.setCardToNumber(cardToNumber);
        operation.setCardFromValidTill("1234");
        operation.setAmount(amount);

        var service = new Service(repository);

        var res = new PostResponse();
        res.setOperationId("6");

        var actual = service.postTransfer(operation);
        var expected = res;

        Assert.assertEquals(expected, actual);

        Mockito.verify(repository, Mockito.times(1)).getAmountOfId();
        Mockito.verify(repository, Mockito.times(1)).createOperation(Mockito.any());
        Mockito.verify(repository, Mockito.times(1)).serializeOperations();
    }

}
