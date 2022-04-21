package com.midterm.BonkRemastered.dto;

import com.midterm.BonkRemastered.model.Product;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class ProductDTO {

    private Long productId;

    private Long uniqueId;

    @NotBlank(message = "Product Name is required")
    private String productName;

    @PositiveOrZero(message = "Quantity must not be a negative number")
    private long quantity;

    @PositiveOrZero(message = "Quantity must not be a negative number")
    private long totalInventory;



    @PositiveOrZero(message = "Price must not be a negative number")
    private long price;


    @PositiveOrZero(message = "Price must not be a negative number")
    private long resellPrice;


    public ProductDTO(){}

    public ProductDTO(Product product) {
        this.productId = product.getProductId();
        this.uniqueId = product.getUniqueId().getId();
        this.productName = product.getProductName();
        this.quantity = product.getQuantity();
        this.totalInventory = product.getTotalInventory();
        this.price = product.getPrice();
        this.resellPrice = product.getResellPrice();
    }







    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public Long getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(Long totalInventory) {
        this.totalInventory = totalInventory;
    }

    public long getResellPrice() {
        return resellPrice;
    }

    public void setResellPrice(long resellPrice) {
        this.resellPrice = resellPrice;
    }

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }
}
