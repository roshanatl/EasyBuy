/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.AddressService;

import model.User.Address;

/**
 *
 * @author megha_000
 */
public interface AddressService {
    public  int  AddAddress(Address newAddress);
    public  Address getAddressByID (int addressId);
    
}
