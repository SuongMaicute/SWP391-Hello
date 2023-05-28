/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minhquan.orders;

/**
 *
 * @author Minh Quan
 */
public class OrdersDTO {

    private int order_id;
    private String email;
    private String order_date;
    private float total;
    private int order_status_id;

    public OrdersDTO() {
    }

    public OrdersDTO(int order_id, String email, String order_date, float total, int order_status_id) {
        this.order_id = order_id;
        this.email = email;
        this.order_date = order_date;
        this.total = total;
        this.order_status_id = order_status_id;
    }
 
    /**
     * @return the order_id
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * @param order_id the order_id to set
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the order_date
     */
    public String getOrder_date() {
        return order_date;
    }

    /**
     * @param order_date the order_date to set
     */
    public void setOrder_date(String order_date) {
        this.order_date = order_date;
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
     * @return the order_status_id
     */
    public int getOrder_status_id() {
        return order_status_id;
    }

    /**
     * @param order_status_id the order_status_id to set
     */
    public void setOrder_status_id(int order_status_id) {
        this.order_status_id = order_status_id;
    }

}
