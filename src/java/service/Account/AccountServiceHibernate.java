
package service.Account;

import javax.inject.Inject;
import model.User.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import util.ORM.HibernateSession;


public class AccountServiceHibernate implements AccountService {
    
    @Inject
    static HibernateSession hibFactory;
   
    @Override
    public  void createAccount(Account user) {
        Session session = hibFactory.getsessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public  Account getAccountByEmail(String email) {              
        Session session = hibFactory.getsessionFactory().openSession();
        Account user = null;
        String queryString = "from Account where EMAIL = :Email";
        Query query = session.createQuery(queryString);
        query.setString("Email", email);
        Object queryResult = query.uniqueResult();
        user = (Account) queryResult;
        return user;

    }
    
    @Override
    public  Account getAccountByID(Long  accountID) {
        Session session = hibFactory.getsessionFactory().openSession();
        Account user = null;
        String queryString = "from Account where account_id = :accountID";
        Query query = session.createQuery(queryString);
        query.setLong("accountID", accountID);
        Object queryResult = query.uniqueResult();
        user = (Account) queryResult;
        return user;
    }

}
