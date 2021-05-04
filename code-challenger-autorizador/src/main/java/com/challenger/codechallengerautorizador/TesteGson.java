package com.challenger.codechallengerautorizador;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TesteGson {

    public static void main(String[] args) {
        String file = "C:/Users/olive/Desktop/teste.json";

        try {
            String json = String.join(" ",
                    Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8));

            Account account = new Gson().fromJson(json, Account.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
