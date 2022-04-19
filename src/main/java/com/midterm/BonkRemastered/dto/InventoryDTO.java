package com.midterm.BonkRemastered.dto;

import com.midterm.BonkRemastered.model.Inventory;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class InventoryDTO {

    private Long inventoryId;
    private Long business;
    private Set<ProductDTO> productList;
    private Set<RecordDTO> recordList;

    public InventoryDTO(){}

    public InventoryDTO(Inventory inventory){

        this.inventoryId = inventory.getInventoryId();
        this.business = inventory.getBusiness().getBusinessId();
        this.productList = Optional.ofNullable(inventory.getProductList())
                .orElseGet(Collections::emptySet)
                .stream()
                .map(ProductDTO::new)
                .collect(Collectors.toSet());
        this.recordList = Optional.ofNullable(inventory.getRecordList())
                .orElseGet(Collections::emptySet)
                .stream()
                .map(RecordDTO::new)
                .collect(Collectors.toSet());
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getBusiness() {
        return business;
    }

    public void setBusiness(Long business) {
        this.business = business;
    }

    public Set<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(Set<ProductDTO> productList) {
        this.productList = productList;
    }

    public Set<RecordDTO> getRecordList() {
        return recordList;
    }

    public void setRecordList(Set<RecordDTO> recordList) {
        this.recordList = recordList;
    }
}
