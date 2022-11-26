package ru.netology.moneytransferservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.moneytransferservice.entity.Operation;
import ru.netology.moneytransferservice.service.Service;


@RestController
public class Controller {

    Service service;

    public Controller (Service service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public String postTransfer(@RequestBody Operation operation) {
        return service.postTransfer(operation);
    }


}
