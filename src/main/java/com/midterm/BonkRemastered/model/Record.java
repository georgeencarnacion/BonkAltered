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
    private Month month;

    @Column(nullable = false)
    private Integer revenue;

    @Column(nullable = false)
    private Integer qty;

    @Column(nullable = false)
    private Integer inventory;

    @Column(nullable = false)
    private Integer cogs;

    @Column(nullable = false)
    private Integer expenses;

    @Column(nullable = false)
    private Integer netProfit;


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

    public Month getMonth() {
        return month;
    }

    public void setDate(Month date) {
        this.month = date;
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
