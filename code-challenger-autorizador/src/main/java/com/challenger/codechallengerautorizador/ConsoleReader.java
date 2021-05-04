package com.challenger.codechallengerautorizador;

import org.json.JSONML;

import java.util.Scanner;

public class ConsoleReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert information:");
        //String account = scanner.nextLine(); lendo a linha

        String account = "{\"account\": {\"active-card\": true, \"available-limit\": 100}}\n";
        String transaction = "{\"transaction\": {\"merchant\": \"Burger King\", \"amount\": 20, \"time\": \"2019-02-13T10:00:00.000Z\"}}";

        //True or False
        String activeCard = account.substring(28,32);

        //Limit 100-999
        String availableLimit = account.substring(53,56);

        //Amount at transaction
        String amount = transaction.substring(54,56);

        String violations = ", \"violations\": []}";
        String violationsInsuficient = ", \"violations\":[\"insufficient-limit\"]}";

        //Convert String limit to Integer limit
        Integer limit = Integer.parseInt(availableLimit);

        //Convert String amount to Integer amount
        Integer amountConvert = Integer.parseInt(amount);



        if (account.contains("account")) {
            System.out.println("sou a linha ACCOUNT");
        }

        if (transaction.contains("transaction")) {
            System.out.println("sou a linha TRANSACTION");
        }

        Boolean teste = Boolean.valueOf(activeCard.toString());
        if (teste)
            System.out.println(account);

        System.out.println("ACTIVE = " + account.substring(0, account.length()-2) + violations);
        System.out.println("LIMIT = " + limit);
    }
}
