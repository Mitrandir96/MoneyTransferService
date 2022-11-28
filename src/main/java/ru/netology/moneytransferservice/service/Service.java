package ru.netology.moneytransferservice.service;


import ru.netology.moneytransferservice.entity.Operation;
import ru.netology.moneytransferservice.repository.Repository;

import java.io.File;

@org.springframework.stereotype.Service
public class Service {
    Repository repository;


    public Service (Repository repository) {
        this.repository = repository;
    }

    public String postTransfer(Operation operation) {
        double fee = operation.getAmount().getValue() * 0.1;
        operation.getAmount().setFee(fee);
        operation.setOperationId(String.valueOf(repository.getAmountOfId() + 1));
        repository.createOperation(operation);
        repository.serializeOperations();
        return operation.getOperationId();
    }


    public String postConfirmOperation(Operation operation) {
        repository.addDateAndResult(operation);
        repository.serializeOperations();
        return operation.getOperationId();
    }
}
