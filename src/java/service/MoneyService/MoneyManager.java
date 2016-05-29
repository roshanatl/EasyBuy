/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.MoneyService;

import javax.inject.Inject;
import model.Financial.Money;
import org.hibernate.Query;
import org.hibernate.Session;
import util.ORM.HibernateSession;

/**
 *
 * @author megha_000
 */
public class MoneyManager {

    @Inject
    static HibernateSession hibFactory;

    private static void addMoney(Money myMoney) {
        Session session = hibFactory.getsessionFactory().openSession();
        session.beginTransaction();
        session.save(myMoney);
        session.getTransaction().commit();
        session.close();

    }

    public static void updateMoneyAmount(long sellerID, Double amount) {
        Session session = hibFactory.getsessionFactory().openSession();
        Money myMoney = getMoneyofUser(sellerID);

        session.beginTransaction();
        if (myMoney == null) {
            Money myNewMoney = new Money();
            myNewMoney.setBalance(amount);
            myNewMoney.setUserID(sellerID);
            addMoney(myNewMoney);
        } else {
            myMoney.setBalance(myMoney.getBalance() + amount);
            session.update(myMoney);
        }
        session.getTransaction().commit();
        session.close();

    }

    public static Money getMoneyofUser(long userID) {
        Session session = hibFactory.getsessionFactory().openSession();
        try {

            session.beginTransaction();
            Money myMoney = null;
            String queryString = "from Money where userID = :userID";
            Query query = session.createQuery(queryString);
            query.setLong("userID", userID);
            Object queryResult = query.uniqueResult();
            myMoney = (Money) queryResult;
            session.close();

            return myMoney;
        } catch (Exception e) {
            Money zero = new Money();
            zero.setBalance(0);
            return zero;
        }

    }
}
