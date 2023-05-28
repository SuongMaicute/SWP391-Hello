/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhilty.model;

/**
 *
 * @author leyen
 */
public class Product {
    private int productID;
    private String productName;
    private double priceIn;
    private String type;
    private String category;
    private int quantity;
    private String description;
    private String status;
    private String img;
    private String sku;
    private Shop shop;
    private double priceOut;
    private double pSale;

    public Product() {
    }

    public Product(int productID, String productName, double priceIn, String type,
            String category, int quantity, String description, String status, 
            String img, String sku, Shop shop, double priceOut, double pSale) {
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
        this.shop = shop;
        this.priceOut = priceOut;
        this.pSale = pSale;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(double priceIn) {
        this.priceIn = priceIn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public double getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(double priceOut) {
        this.priceOut = priceOut;
    }

    public double getpSale() {
        return pSale;
    }

    public void setpSale(double pSale) {
        this.pSale = pSale;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", priceIn=" + priceIn + ", type=" + type + ", category=" + category + ", quantity=" + quantity + ", description=" + description + ", status=" + status + ", img=" + img + ", sku=" + sku + ", shop=" + shop + ", priceOut=" + priceOut + ", pSale=" + pSale + '}';
    }

   
    
    
}
