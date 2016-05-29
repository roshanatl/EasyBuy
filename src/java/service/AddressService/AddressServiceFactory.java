/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.AddressService;

/**
 *
 * @author megha_000
 */
public class AddressServiceFactory {

    /**
     *
     * @param useJPA
     * @return
     */
    public static AddressService getAddressService(boolean useJPA)
    {
        AddressService addressServ;
        if(useJPA==true){
            addressServ = new AddressServiceJPA();
        }
        else{
          addressServ = new AddressServiceHibernate();
        }
        return addressServ;
    }
    
}
