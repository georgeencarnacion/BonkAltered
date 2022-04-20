package com.midterm.BonkRemastered.model;

import com.midterm.BonkRemastered.dto.BusinessDTO;

import javax.persistence.*;

@Entity
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long businessId;

    @ManyToOne
    @JoinColumn(name = "Owner", nullable = false)
    private User owner;

    @Column(nullable = false)
    private String businessName;

    @Column(nullable = false)
    private String location;

    @Column
    private String imageLoc;

    public Business() {}

    public Business (Long businessId){

        this.businessId = businessId;
    }

    public Business (BusinessDTO businessDTO) {
        this.businessId = businessDTO.getBusinessId();
        this.owner = new User(businessDTO.getOwner());
        this.businessName = businessDTO.getBusinessName();
        this.location = businessDTO.getLocation();


    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getImageLoc() {
        return imageLoc;
    }

    public void setImageLoc(String imageLoc) {
        this.imageLoc = imageLoc;
    }
}