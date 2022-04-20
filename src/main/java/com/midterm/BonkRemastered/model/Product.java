package com.midterm.BonkRemastered.model;


import com.midterm.BonkRemastered.dto.ProductDTO;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User uniqueId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long resellPrice;


    public Product(Long productId) {
        this.productId = productId;
    }

    public Product(ProductDTO productDTO) {
        this.productId = productDTO.getProductId();
        this.uniqueId = new User(productDTO.getUniqueId());
        this.productName = productDTO.getProductName();
        this.quantity = productDTO.getQuantity();
        this.price = productDTO.getPrice();
        this.resellPrice = productDTO.getResellPrice();
    }

    public Product() {

    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public User getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(User uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getResellPrice() {
        return resellPrice;
    }

    public void setResellPrice(Long resellPrice) {
        this.resellPrice = resellPrice;
    }

}

