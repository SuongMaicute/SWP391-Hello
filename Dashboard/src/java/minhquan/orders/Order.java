/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minhquan.orders;

import java.sql.Date;

/**
 *
 * @author Minh Quan
 */
public class Order {

    private int orderID;
    private Date orderDate;
    private float total;
    private int paymentID;
    private int customerID;
    private int addressShipID;
    private Date shipDate;
    private String status;
    public Order() {
    }   

    public Order(int orderID, Date orderDate, float total, int paymentID, int customerID, int addressShipID, Date shipDate, String status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.total = total;
        this.paymentID = paymentID;
        this.customerID = customerID;
        this.addressShipID = addressShipID;
        this.shipDate = shipDate;
        this.status = status;
    }

    /**
     * @return the orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return the paymentID
     */
    public int getPaymentID() {
        return paymentID;
    }

    /**
     * @param paymentID the paymentID to set
     */
    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    /**
     * @return the customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * @return the addressShipID
     */
    public int getAddressShipID() {
        return addressShipID;
    }

    /**
     * @param addressShipID the addressShipID to set
     */
    public void setAddressShipID(int addressShipID) {
        this.addressShipID = addressShipID;
    }

    /**
     * @return the shipDate
     */
    public Date getShipDate() {
        return shipDate;
    }

    /**
     * @param shipDate the shipDate to set
     */
    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

 

}
