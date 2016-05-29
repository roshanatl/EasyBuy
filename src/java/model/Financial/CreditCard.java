/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Financial;

/**
 *
 * @author megha_000
 */
public class CreditCard {
    private String cardNum;
    private String cardExpiry;
    private String cardCVV;
    private String cardType;
    private boolean Valid=false;
    private boolean Expired = true;
    private boolean CVVValid = false;

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public String getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public boolean isValid() {
        return Valid;
    }

    public void setValid(boolean Valid) {
        this.Valid = Valid;
    }

    public boolean isExpired() {
        return Expired;
    }

    public void setExpired(boolean Expired) {
        this.Expired = Expired;
    }

    public boolean isCVVValid() {
        return CVVValid;
    }

    public void setCVVValid(boolean CVVValid) {
        this.CVVValid = CVVValid;
    }

    
    
    
}
