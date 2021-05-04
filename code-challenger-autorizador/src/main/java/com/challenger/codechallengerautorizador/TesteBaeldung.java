package com.challenger.codechallengerautorizador;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TesteBaeldung {

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Insert information:");
            String userCommand = scanner.nextLine();
            //Scanner scanner = new Scanner(new File("C:/Users/olive/Desktop/nikoTeste.txt"));
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                System.out.println(linha);

                Scanner linhaScanner = new Scanner(linha);
                linhaScanner.useDelimiter(",");

                String valor1 = linhaScanner.next();
                String valor2 = linhaScanner.next();

                System.out.println(valor1);
                System.out.println(valor2);
                System.out.println();
            }

    }
}

class TryNow {
    private Boolean activeCard;
    private Long availableLimit;
    private Transaction transaction;

    public Boolean getActiveCard() {
        return activeCard;
    }

    public void setActiveCard(Boolean activeCard) {
        this.activeCard = activeCard;
    }

    public Long getAvailableLimit() {
        return availableLimit;
    }

    public void setAvailableLimit(Long availableLimit) {
        this.availableLimit = availableLimit;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
