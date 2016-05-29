
package service.Account;

import javax.persistence.EntityManager;
import model.User.Account;
import util.ORM.JPAEntityManager;


public class AccountServiceJPA implements AccountService {
    
   
   
   
    @Override
    public  void createAccount(Account user) {
        EntityManager em;
        em = JPAEntityManager.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public  Account getAccountByEmail(String email) {              
        EntityManager em ;
        em = JPAEntityManager.getEntityManagerFactory().createEntityManager();
        
        em.getTransaction().begin();
        Account user = null;

        String queryString = "SELECT I from Account  I where I.email = :email";
        javax.persistence.Query query = em.createQuery(queryString);
        query.setParameter("email", email);
        user = (Account) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return user;

    }
    
    @Override
    public  Account getAccountByID(Long  accountID) {
         EntityManager em ;
        em = JPAEntityManager.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Account user = null;

        String queryString = "SELECT I from Account  I where I.account_id = :accountID";
        javax.persistence.Query query = em.createQuery(queryString);
        query.setParameter("accountID", accountID);
        user = (Account) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return user;
    }

}
