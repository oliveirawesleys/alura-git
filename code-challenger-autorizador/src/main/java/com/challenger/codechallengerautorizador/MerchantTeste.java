package com.challenger.codechallengerautorizador;

public class MerchantTeste {

    private String merchant;
    private Long amount;
    private String time;

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "{\"transaction\": {" +
                "\"merchant\": \"" + merchant + '\"' +
                ", \"amount\": " + amount +
                ", \"time\": \"" + time + '\"' +
                "}}";
    }

}
