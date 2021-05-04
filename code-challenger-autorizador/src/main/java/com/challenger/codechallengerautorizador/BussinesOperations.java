package com.challenger.codechallengerautorizador;

import java.util.ArrayList;
import java.util.List;

public class BussinesOperations {

    Account account = new Account();
    private Long limitDefaut = 100L;
    List<String> res = new ArrayList<>();
    Boolean vioalations = true;

    public Account createAccount(Account account) {
        account.setActiveCard(true);
        account.setAvailableLimit(limitDefaut);
        if (vioalations == false) {

        } else {

        }
        return account;
    }

}
