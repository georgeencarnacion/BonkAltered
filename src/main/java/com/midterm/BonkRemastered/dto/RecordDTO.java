package com.midterm.BonkRemastered.dto;

import com.midterm.BonkRemastered.model.Record;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.time.Month;

public class RecordDTO {

    private Long recordId;

    private Long user;

    @NotBlank(message = "Month is required")
    private String month;

    @PositiveOrZero(message = "Revenue must not be a negative number")
    private long revenue;

    @PositiveOrZero(message = "Cost of Goods must not be a negative number")
    private long cogs;

    @PositiveOrZero(message = "Expenses must not be a negative number")
    private long expenses;

    @PositiveOrZero(message = "Income must not be a negative number")
    private long netProfit;

    public RecordDTO(){};

    public RecordDTO(Record record){

        this.recordId = record.getRecordId();
        this.user = record.getUser().getId();
        this.month = record.getMonth();
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

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public long getCogs() {
        return cogs;
    }

    public void setCogs(long cogs) {
        this.cogs = cogs;
    }

    public long getExpenses() {
        return expenses;
    }

    public void setExpenses(long expenses) {
        this.expenses = expenses;
    }

    public long getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(long netProfit) {
        this.netProfit = netProfit;
    }
}
