package com.midterm.BonkRemastered.dto;

import com.midterm.BonkRemastered.model.Product;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class ProductDTO {

    private Long productId;

    private Long inventory;

    @NotBlank(message = "Product Name is required")
    private String productName;

    @PositiveOrZero(message = "Quantity must not be a negative number")
    private long quantity;



    @PositiveOrZero(message = "Price must not be a negative number")
    private long price;


    @PositiveOrZero(message = "Price must not be a negative number")
    private long resellPrice;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.resellPrice = product.getResellPrice();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getResellPrice() {
        return resellPrice;
    }

    public void setResellPrice(long resellPrice) {
        this.resellPrice = resellPrice;
    }



}