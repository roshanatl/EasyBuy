/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Payment;

import controller.admin.ValidateCard;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Financial.CreditCard;
import org.apache.commons.validator.CreditCardValidator;

/**
 *
 * @author megha_000
 */
public class PaymentService {

    public static String  validateCard(CreditCard creditCard) {
        CreditCardValidator v = new CreditCardValidator();
        creditCard.setValid(v.isValid(creditCard.getCardNum()));
       
        Date date = null;
        Date now = new Date();
        try {
            date = new SimpleDateFormat("MM/yyyy").parse(creditCard.getCardExpiry());

        } catch (ParseException ex) {
            Logger.getLogger(ValidateCard.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (date.getYear() == now.getYear() && date.getMonth() > now.getMonth()) {
            creditCard.setExpired(false); 
        } else if (date.getYear() > now.getYear()) {
            creditCard.setExpired(false); 
        }
        if (creditCard.getCardCVV().length() == 3 || creditCard.getCardCVV().length() == 4) {
            try {
                Integer.parseInt(creditCard.getCardCVV());
                creditCard.setCVVValid(true);
            } catch (NumberFormatException e) {
                //ignore isCVVValid is false
            }
        }
        String paymentErrorMessage=null;
        if(!creditCard.isValid())
        {
            paymentErrorMessage="Invalid Card Number";
        }    
        if(creditCard.isExpired())
        {
            paymentErrorMessage="Expired Card";
        }    
        if(!creditCard.isCVVValid())
        {
            paymentErrorMessage="Invalid CVV";
        }    
        return paymentErrorMessage;
    }
}

