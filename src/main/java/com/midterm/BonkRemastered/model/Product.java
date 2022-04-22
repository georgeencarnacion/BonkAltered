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
    private String month;


    @Column(nullable = false)
    private Long quantity;


    @Column(nullable = false)
    private Long totalInventory;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long resellPrice;

    @Column
    private Long income;

    @Column
    private Long expenses;

    @Column
    private Long itemSold;


    public Product(Long productId) {
        this.productId = productId;
    }

    public Product(ProductDTO productDTO) {
        this.productId = productDTO.getProductId();
        this.uniqueId = new User(productDTO.getUniqueId());
        this.month = productDTO.getMonth();
        this.productName = productDTO.getProductName();
        this.quantity = productDTO.getQuantity();
        this.totalInventory = productDTO.getTotalInventory();
        this.price = productDTO.getPrice();
        this.resellPrice = productDTO.getResellPrice();
        this.income = productDTO.getIncome();
        this.expenses = productDTO.getExpenses();
        this.itemSold = productDTO.getItemSold();
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }


    public Long getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(Long totalInventory) {
        this.totalInventory = totalInventory;
    }

    public Long getIncome() {
        return income;
    }

    public void setIncome(Long income) {
        this.income = income;
    }

    public Long getExpenses() {
        return expenses;
    }

    public void setExpenses(Long expenses) {
        this.expenses = expenses;
    }

    public Long getItemSold() {
        return itemSold;
    }

    public void setItemSold(Long itemSold) {
        this.itemSold = itemSold;
    }

}

