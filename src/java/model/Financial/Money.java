/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Financial;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author megha_000
 */
@Entity
@Table
public class Money implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int moneyID;
    
    private long userID;
    private double balance;

    public int getMoneyID() {
        return moneyID;
    }

    public void setMoneyID(int moneyID) {
        this.moneyID = moneyID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
    
}
