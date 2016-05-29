/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Store;

import java.io.Serializable;
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
@Table
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderID;
    private int deliveryAddressID;
    private int orderState;
    private long userID;
    private long sellerID;
    private int itemID;
    private int quantity;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getDeliveryAddressID() {
        return deliveryAddressID;
    }

    public void setDeliveryAddressID(int deliveryAddressID) {
        this.deliveryAddressID = deliveryAddressID;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getSellerID() {
        return sellerID;
    }

    public void setSellerID(long sellerID) {
        this.sellerID = sellerID;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", deliveryAddressID=" + deliveryAddressID + ", orderState=" + orderState + ", userID=" + userID + ", itemID=" + itemID + ", quantity=" + quantity + '}';
    }

}
