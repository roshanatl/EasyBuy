/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author megha_000
 */
@Entity
@Table(name="Account")
public class Account {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long account_id;
    private String name;
    private String password;
    private String email;
    private String phone;    
    private String address;

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }   

    @Override
    public String toString() {
        return "Account{" + "account_id=" + account_id + ", name=" + name + ", password=" + password + ", email=" + email + ", phone=" + phone + ", address=" + address + '}';
    }
    
}
