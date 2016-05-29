/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Account;

import model.User.Account;

/**
 *
 * @author megha_000
 */
public interface AccountService {
      public  void createAccount(Account user);
      public  Account getAccountByEmail(String email);
      public  Account getAccountByID(Long  accountID);
      
}
