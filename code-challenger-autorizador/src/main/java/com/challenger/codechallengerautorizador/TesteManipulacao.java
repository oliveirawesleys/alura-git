package com.challenger.codechallengerautorizador;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;

public class TesteManipulacao {

    public static void main(String[] args) {
        SpringApplication.run(CodeChallengerAutorizadorApplication.class, args);

        String file = "C:/Users/olive/Desktop/teste.json";
        String texto = "{ \"account\": { \"active-card\": \"true\", \"available-limit\": \"100\" } }";
        JSONObject obj = new JSONObject(texto);

        if (obj.has("account")) {
            System.out.println("possui nome = " + obj.get("account"));
        } else {
            System.out.println("não possui nome");
        }

    }
}
