package com.midterm.BonkRemastered.dto;

import com.midterm.BonkRemastered.model.Record;

import java.time.LocalDate;

public class RecordDTO {



    private Long recordId;
    private Long inventory;
    private LocalDate date;
    private Integer revenue;
    private Integer cogs;
    private Integer expenses;
    private Integer netProfit;

    public RecordDTO(){};

    public RecordDTO(Record record){

        this.recordId = record.getRecordId();
        this.inventory = record.getInventory().getInventoryId();
        this.date = record.getDate();
        this.revenue = record.getRevenue();
        this.cogs = record.getCogs();
        this.expenses = record.getExpenses();
        this.netProfit = record.getNetProfit();
    }




    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Integer getCogs() {
        return cogs;
    }

    public void setCogs(Integer cogs) {
        this.cogs = cogs;
    }

    public Integer getExpenses() {
        return expenses;
    }

    public void setExpenses(Integer expenses) {
        this.expenses = expenses;
    }

    public Integer getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(Integer netProfit) {
        this.netProfit = netProfit;
    }
}
