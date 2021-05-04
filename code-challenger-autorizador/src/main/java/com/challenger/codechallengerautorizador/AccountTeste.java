package com.challenger.codechallengerautorizador;

public class AccountTeste {

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


    @Override
    public String toString() {
        return "{\"account\": {" +
                "\"active-card\": " + activeCard  +
                ", \"available-limit\": "  + availableLimit +
                "}}";
    }
}
