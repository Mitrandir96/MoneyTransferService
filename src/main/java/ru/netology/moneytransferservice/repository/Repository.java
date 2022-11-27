package ru.netology.moneytransferservice.repository;

import au.com.bytecode.opencsv.CSVWriter;
import ru.netology.moneytransferservice.entity.Operation;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Repository
public class Repository {

    private Map<String, Operation> operations = new HashMap<>();

    final static String prefix = ("C:" + File.separator + "Users" + File.separator + "i.grachev" + File.separator
            + "IdeaProjects" + File.separator + "GIT projects" + File.separator + "MoneyTransferService" + File.separator);


    public void createOperation(Operation operation) {

        operations.put(operation.getOperationId(), operation);
        serializeOperations();
    }

    private void serializeOperations() {
        try (FileOutputStream fos = new FileOutputStream(prefix + "operations.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(operations);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public int getAmountOfId() {
        return operations.size();
    }
}
