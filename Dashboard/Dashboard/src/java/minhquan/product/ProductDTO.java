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
    private int productID;
    private String productName;
    private float priceIn;
    private String type;
    private String category;
    private int quantity;
    private String description;
    private String status;
    private String img;
    private String sku;
    private int shopID;
    private float priceOut;
    private float pSale;

    public ProductDTO() {
    }

    public ProductDTO(int productID, String productName, float priceIn, String type, String category, int quantity, String description, String status, String img, String sku, int shopID, float priceOut, float pSale) {
        this.productID = productID;
        this.productName = productName;
        this.priceIn = priceIn;
        this.type = type;
        this.category = category;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
        this.img = img;
        this.sku = sku;
        this.shopID = shopID;
        this.priceOut = priceOut;
        this.pSale = pSale;
    }

    /**
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the priceIn
     */
    public float getPriceIn() {
        return priceIn;
    }

    /**
     * @param priceIn the priceIn to set
     */
    public void setPriceIn(float priceIn) {
        this.priceIn = priceIn;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
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

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
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
     * @return the shopID
     */
    public int getShopID() {
        return shopID;
    }

    /**
     * @param shopID the shopID to set
     */
    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    /**
     * @return the priceOut
     */
    public float getPriceOut() {
        return priceOut;
    }

    /**
     * @param priceOut the priceOut to set
     */
    public void setPriceOut(float priceOut) {
        this.priceOut = priceOut;
    }

    /**
     * @return the pSale
     */
    public float getpSale() {
        return pSale;
    }

    /**
     * @param pSale the pSale to set
     */
    public void setpSale(float pSale) {
        this.pSale = pSale;
    }
    
    
}
