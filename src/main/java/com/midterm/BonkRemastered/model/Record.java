package com.midterm.BonkRemastered.model;

import com.midterm.BonkRemastered.dto.RecordDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;

@Entity
public class Record {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(nullable = false)
    private String month;

    @Column(nullable = false)
    private long revenue;

    @Column(nullable = false)
    private long cogs;

    @Column(nullable = false)
    private long expenses;

    @Column(nullable = false)
    private long netProfit;


    public Record() {
    }

    public Record(Long recordId) {

        this.recordId = recordId;
    }

    public Record(RecordDTO recordDTO) {

        this.recordId = recordDTO.getRecordId();
        this.user = new User(recordDTO.getUser());
        this.month = recordDTO.getMonth();
        this.revenue = recordDTO.getRevenue();
        this.cogs = recordDTO.getCogs();
        this.expenses = recordDTO.getExpenses();
        this.netProfit = recordDTO.getNetProfit();
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
