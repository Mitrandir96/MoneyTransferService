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
        int id = 1;
        repository.createStringOfTransaction(operation);
        return String.valueOf(id);
    }

}
