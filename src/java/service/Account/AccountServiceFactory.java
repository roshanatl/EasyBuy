/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Account;

/**
 *
 * @author megha_000
 */
public class AccountServiceFactory {

    public static AccountService getAccountService(boolean useJPA) {
        AccountService accountServ;
        if (useJPA == true) {
            accountServ = new AccountServiceJPA();
        } else {
            accountServ = new AccountServiceHibernate();
        }
        return accountServ;
    }
}
