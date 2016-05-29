/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.AddressService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import model.User.Address;
import util.ORM.JPAEntityManager;

/**
 *
 * @author megha_000
 */
public class AddressServiceJPA implements AddressService{
    @Inject
    private JPAEntityManager jpaEMF;
    
    @Override
     public  int  AddAddress(Address newAddress)
    {
        EntityManager em;
        em = jpaEMF.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(newAddress);
        em.getTransaction().commit();
        em.close();
        return newAddress.getAddressID();
        
    }
     
    @Override
      public  Address getAddressByID (int addressId)
    {
        EntityManager em ;
        em = jpaEMF.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Address myAddress ;
        String queryString = "SELECT I from Address  I where I.addressID = :addressId";
        javax.persistence.Query query = em.createQuery(queryString);
        query.setParameter("addressId", addressId);
        myAddress = (Address) query.getSingleResult();
        em.getTransaction().commit();
        em.close();  
        return myAddress;
        
    }
    
}
