/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.ORM;

import javax.inject.Named;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author megha_000
 */
@Named
public class JPAEntityManager {
private  static EntityManagerFactory myEMF = null ;

  

    /**
     *
     * @return
     */
    public  static  EntityManagerFactory getEntityManagerFactory() {
        if (myEMF == null) {
             myEMF = Persistence.createEntityManagerFactory("Demo");            
        }
       return myEMF;
    }
}
