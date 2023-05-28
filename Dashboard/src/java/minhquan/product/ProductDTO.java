package minhquan.product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Minh Quan
 */
public class ProductDTO {
    private String sku;
    private String product_name;
    private String image;
    private float price;
    private int quantity;
    private String description;
    private int category_id;
    private int product_status_id;
    private boolean is_deleted;

    public ProductDTO() {
    }

    public ProductDTO(String sku, String product_name, String image, float price, int quantity, String description, int category_id, int product_status_id, boolean is_deleted) {
        this.sku = sku;
        this.product_name = product_name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category_id = category_id;
        this.product_status_id = product_status_id;
        this.is_deleted = is_deleted;
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
     * @return the product_name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * @param product_name the product_name to set
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the category_id
     */
    public int getCategory_id() {
        return category_id;
    }

    /**
     * @param category_id the category_id to set
     */
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    /**
     * @return the product_status_id
     */
    public int getProduct_status_id() {
        return product_status_id;
    }

    /**
     * @param product_status_id the product_status_id to set
     */
    public void setProduct_status_id(int product_status_id) {
        this.product_status_id = product_status_id;
    }

    /**
     * @return the is_deleted
     */
    public boolean isIs_deleted() {
        return is_deleted;
    }

    /**
     * @param is_deleted the is_deleted to set
     */
    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
    
}
