package com.challenger.codechallengerautorizador;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LendoArquivoJson {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert information:");
        String userCommand = scanner.nextLine();

        String path = "C:/Users/olive/Desktop/testeDois.json";
        String pathTres = "C:/Users/olive/Desktop/testeTres.json";
        String fileOperations = "C:/Users/olive/Desktop/operations.json";
        JSONObject jsonObject;
        JSONObject jsonObjectTres;
        JSONObject jsonObjectMerged;
        JSONParser parser = new JSONParser();

/*        Gson gson = new Gson();
        AccountTeste objAccount = gson.fromJson(userCommand, AccountTeste.class);

        System.out.println(userCommand);
        System.out.println(objAccount.getActiveCard());*/


        AccountTeste account = new AccountTeste();
        MerchantTeste merchant = new MerchantTeste();

        try {
            //jsonObjectMerged = (JSONObject) parser.parse(new FileReader(fileOperations));


            jsonObject = (JSONObject) parser.parse(new FileReader(path));
            jsonObjectTres = (JSONObject) parser.parse(new FileReader(pathTres));

            account.setActiveCard((Boolean) jsonObject.get("active-card"));
            account.setAvailableLimit((Long) jsonObject.get("available-limit"));
            merchant.setMerchant((String) jsonObjectTres.get("merchant"));
            merchant.setAmount((Long) jsonObjectTres.get("amount"));
            merchant.setTime((String) jsonObjectTres.get("time"));

            var availableLimitUpdated = account.getAvailableLimit() - merchant.getAmount();
            account.setAvailableLimit(availableLimitUpdated);

            while (scanner.hasNextLine()) {

                if (userCommand.contains("transaction")) {
                    System.out.println("TRANSACTION");
                    System.out.println(merchant.toString());
                }

                scanner.nextLine();
            }

            if (userCommand.contains("account")) {
                System.out.println("ACCOUNT");
                if (account.getAvailableLimit() > 0) {

                }

            }
            System.out.println(account.toString());
            System.out.println(merchant.toString());

        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
    }
}
