package com.midterm.BonkRemastered.dto;

import com.midterm.BonkRemastered.model.Business;
import org.springframework.web.multipart.MultipartFile;

public class BusinessDTO {

    private Long businessId;

    private Long owner;

    private String businessName;

    private String location;

    private MultipartFile image;

    private String imageLocation;

    public BusinessDTO(){}



    public BusinessDTO(Business business){
        this.businessId = business.getBusinessId();
        this.owner = business.getOwner().getId();
        this.businessName = business.getBusinessName();
        this.location = business.getLocation();
        this.imageLocation = business.getImageLoc();

    }


    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }
}
