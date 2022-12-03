package ru.netology.moneytransferservice.repository;

import au.com.bytecode.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Value;
import ru.netology.moneytransferservice.entity.Operation;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Repository
public class Repository {

    private Map<String, Operation> operations = new HashMap<>();


    private String pathToFile = ("C:" + File.separator + "Users" + File.separator + "i.grachev" + File.separator
            + "IdeaProjects" + File.separator + "GIT projects" + File.separator + "MoneyTransferService" + File.separator + "operations.dat");



//    final static String prefix = ("C:" + File.separator + "Users" + File.separator + "i.grachev" + File.separator
//            + "IdeaProjects" + File.separator + "GIT projects" + File.separator + "MoneyTransferService" + File.separator);

    public Repository() {
        File file = new File(pathToFile);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(pathToFile);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
                operations = (Map<String, Operation>) ois.readObject();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void createOperation(Operation operation) {

        operations.put(operation.getOperationId(), operation);

    }

    public void serializeOperations() {
        try (FileOutputStream fos = new FileOutputStream(pathToFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(operations);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public int getAmountOfId() {
        return operations.size();
    }

    public void addDateAndResult(Operation operation) {
        Operation savedOperation = operations.get(operation.getOperationId());
        savedOperation.setResult("Операция выполнена");
        savedOperation.setDateTime(LocalDateTime.now());
    }
}
