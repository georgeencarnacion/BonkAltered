package com.midterm.BonkRemastered.model;

import com.midterm.BonkRemastered.dto.InventoryDTO;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Inventory {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventoryId;

    @OneToOne
    @JoinColumn(name = "Business", nullable = false)
    private Business business;


    @OneToMany(mappedBy = "inventory", cascade = CascadeType.REMOVE)
    private Set<Product> productList;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.REMOVE)
    private Set<Record> recordList;

    public Inventory() {
    }

    public Inventory(Long inventoryId) {

        this.inventoryId = inventoryId;
    }

    public Inventory(InventoryDTO inventoryDTO) {
        this.inventoryId = inventoryDTO.getInventoryId();
        this.business = new Business(inventoryDTO.getBusiness());


    }


    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Set<Product> getProductList() {
        return productList;
    }

    public void setProductList(Set<Product> productList) {
        this.productList = productList;
    }

    public Set<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(Set<Record> recordList) {
        this.recordList = recordList;
    }
}