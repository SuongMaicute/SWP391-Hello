/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minhquan.ordersItem;

/**
 *
 * @author Minh Quan
 */
public class OrderItemDTO {
    private int order_item_id;
    private int order_id;
    private String sku;
    private int quantity;
    private float price;
    private float subtotal;

    public OrderItemDTO() {
    }

    public OrderItemDTO(int order_item_id, int order_id, String sku, int quantity, float price, float subtotal) {
        this.order_item_id = order_item_id;
        this.order_id = order_id;
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = subtotal;
    }
  
    
    /**
     * @return the order_item_id
     */
    public int getOrder_item_id() {
        return order_item_id;
    }

    /**
     * @param order_item_id the order_item_id to set
     */
    public void setOrder_item_id(int order_item_id) {
        this.order_item_id = order_item_id;
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
     * @return the sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * @param sku the sku to set
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the subtotal
     */
    public float getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
