/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.AddressService;

import javax.inject.Inject;
import model.User.Address;
import org.hibernate.Query;
import org.hibernate.Session;
import util.ORM.HibernateSession;

/**
 *
 * @author megha_000
 */
public class AddressServiceHibernate implements AddressService{
    @Inject
    HibernateSession hibFactory;
    
     public  int  AddAddress(Address newAddress)
    {
        Session session = hibFactory.getsessionFactory().openSession();
        session.beginTransaction();
        session.save(newAddress);
        session.getTransaction().commit();
        session.close();
        return newAddress.getAddressID();
        
    }
     
      public  Address getAddressByID (int addressId)
    {
        Session session = hibFactory.getsessionFactory().openSession();
        Address myAddress = null;
        String queryString = "from Address where addressId = :addressId";
        Query query = session.createQuery(queryString);
        query.setInteger("addressId", addressId);
        Object queryResult = query.uniqueResult();
        myAddress = (Address) queryResult;
        session.close();
        return myAddress;
        
    }
    
}
