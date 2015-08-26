/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author megha_000
 */
public class ManageAccount {

    public static void createAccount(Account user) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(Account.class);
        config.configure("hibernate.cfg.xml");
        // Creates a table
        new SchemaExport(config).create(true, true);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }

    public static Account getAccountByEmail(String email) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(Account.class);
        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Account user = null;
        String queryString = "from Account where EMAIL = :Email";
        Query query = session.createQuery(queryString);
        query.setString("Email", email);
        Object queryResult = query.uniqueResult();
        user = (Account) queryResult;
        return user;

    }

}
