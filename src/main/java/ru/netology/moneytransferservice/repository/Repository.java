package ru.netology.moneytransferservice.repository;

import ru.netology.moneytransferservice.entity.Operation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@org.springframework.stereotype.Repository
public class Repository {

    private File file;
    final static String prefix = ("C:" + File.separator + "Users" + File.separator + "i.grachev" + File.separator
            + "IdeaProjects" + File.separator + "GIT projects" + File.separator + "MoneyTransferService" + File.separator);


    public Repository() {

        file = new File(prefix + "operations.log");

        try {
            if (file.createNewFile()) {
                System.out.println("Файл логирования создан");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    StringBuilder sb = new StringBuilder();

    public void createStringOfTransaction(Operation operation) {
        sb.append(operation.getCardToNumber() + " ");
        sb.append(operation.getCardFromCVV() + " ");
        sb.append(operation.getCardFromValidTill() + " ");
        sb.append(operation.getCardFromNumber() + " ");
        sb.append(operation.getAmount().getValue() + " ");
        sb.append(operation.getAmount().getCurrency() + " ");
        sb.append(operation.getOperationId() + " ");

        String text = sb.toString();
        try(FileWriter writer = new FileWriter(file, true)) {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

}
