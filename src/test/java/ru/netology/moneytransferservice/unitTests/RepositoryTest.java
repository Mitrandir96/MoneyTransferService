package ru.netology.moneytransferservice.unitTests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.netology.moneytransferservice.entity.Operation;
import ru.netology.moneytransferservice.repository.Repository;

import java.util.HashMap;
import java.util.Map;

public class RepositoryTest {

    private final String cardFromNumber = "1111111111111111";
    private final String cardToNumber = "2222222222222222";

    @Test
    void test_getAmountofId() {
        var repository = new Repository();
        var actual = repository.getAmountOfId();
        var expected = 0;

        Assert.assertEquals(expected, actual);
    }
}