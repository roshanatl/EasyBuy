package util.ORM;

import model.User.Account;
import model.User.Address;
import model.Financial.Money;
import model.Store.Orders;
import model.Store.Item;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
    
    private static SessionFactory mySessionFactory =null;
  
    public static SessionFactory getsessionFactory() {
        if(mySessionFactory == null){
        Configuration config = new Configuration();
        config.addAnnotatedClass(Account.class);
        config.addAnnotatedClass(Item.class);
        config.addAnnotatedClass(Orders.class);
        config.addAnnotatedClass(Address.class); 
        config.addAnnotatedClass(Money.class); 
        config.configure("hibernate.cfg.xml");
        // Creates a table
        //new SchemaExport(config).create(true, true);
         mySessionFactory = config.buildSessionFactory();           
        }        
        return mySessionFactory;
    }

}
