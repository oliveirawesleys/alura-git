package com.challenger.codechallengerautorizador;

public class Account {

    private Boolean activeCard;
    private Long availableLimit;

    public Account() {
    }

    public Account(Boolean activeCard, Long availableLimit) {
        this.activeCard = activeCard;
        this.availableLimit = availableLimit;
    }


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
}
