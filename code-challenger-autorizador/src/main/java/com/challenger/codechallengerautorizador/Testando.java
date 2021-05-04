package com.challenger.codechallengerautorizador;

public class Testando {

    public static void main(String[] args) {

        Account a1 = new Account();
        BussinesOperations bussines = new BussinesOperations();
        a1.setActiveCard(true);
        a1.setAvailableLimit(200L);

        bussines.createAccount(a1);

        System.out.println();

    }
}
