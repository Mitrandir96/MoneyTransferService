package ru.netology.moneytransferservice.inegrationTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import ru.netology.moneytransferservice.dto.PostResponse;
import ru.netology.moneytransferservice.entity.MoneyInfo;
import ru.netology.moneytransferservice.entity.Operation;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;


    private static final GenericContainer<?> devApp = new GenericContainer<>("apptests")
            .withExposedPorts(8080);


    @BeforeAll
    public static void setUp() {
        devApp.start();
    }

    @Test
    void postTransfer() throws URISyntaxException {
        var firstAppPort = devApp.getMappedPort(8080);

        final var cardFromNumber = "1111111111111111";
        final var cardToNumber = "2222222222222222";

        var url = "http://localhost:" + firstAppPort + "/transfer";
        var uri = new URI(url);

        var operation = new Operation();
        var amount = new MoneyInfo();
        operation.setAmount(amount);
        operation.setCardFromNumber(cardFromNumber);
        operation.setCardToNumber(cardToNumber);
        operation.setCardFromCVV("123");
        operation.setCardFromValidTill("1234");
        amount.setCurrency("RUR");
        amount.setValue(1000);
        var request = new HttpEntity<>(operation);
        var expected = new PostResponse();
        expected.setOperationId("1");

        var entityFromFirst = restTemplate.postForEntity(uri, request, PostResponse.class);

        Assertions.assertEquals(expected, entityFromFirst.getBody());
    }

    @Test
    void testConfirmOperation() throws URISyntaxException {
        var firstAppPort = devApp.getMappedPort(8080);
        var url = "http://localhost:" + firstAppPort + "/confirmOperation";
        var uri = new URI(url);
        var operation = new Operation();
        operation.setOperationId("1");
        operation.setCode("123");

        var request = new HttpEntity<>(operation);
        var expected = new PostResponse();
        expected.setOperationId("1");

        var entityFromFirst = restTemplate.postForEntity(uri, request, PostResponse.class);

        Assertions.assertEquals(expected, entityFromFirst.getBody());


    }
}