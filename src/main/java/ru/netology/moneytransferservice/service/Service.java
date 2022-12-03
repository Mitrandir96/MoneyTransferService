package ru.netology.moneytransferservice.service;


import ru.netology.moneytransferservice.dto.PostResponse;
import ru.netology.moneytransferservice.entity.Operation;
import ru.netology.moneytransferservice.repository.Repository;

@org.springframework.stereotype.Service
public class Service {
    Repository repository;


    public Service (Repository repository) {
        this.repository = repository;
    }

    public PostResponse postTransfer(Operation operation) {
        var res = new PostResponse();
        double fee = operation.getAmount().getValue() * 0.1;
        operation.getAmount().setFee(fee);
        res.setOperationId(String.valueOf(repository.getAmountOfId() + 1));
        operation.setOperationId(res.getOperationId());
        repository.createOperation(operation);
        repository.serializeOperations();
        return res;
    }


    public PostResponse postConfirmOperation(Operation operation) {
        var res = new PostResponse();
        res.setOperationId(operation.getOperationId());
        repository.addDateAndResult(operation);
        repository.serializeOperations();
        return res;
    }
}
