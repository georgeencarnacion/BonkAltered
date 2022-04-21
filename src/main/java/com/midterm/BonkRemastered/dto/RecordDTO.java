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
    private Month month;

    @PositiveOrZero(message = "Revenue must not be a negative number")
    private Integer revenue;

    @PositiveOrZero(message = "Cost of Goods must not be a negative number")
    private Integer cogs;

    @PositiveOrZero(message = "Expenses must not be a negative number")
    private Integer expenses;

    @PositiveOrZero(message = "Income must not be a negative number")
    private Integer netProfit;

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

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
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
