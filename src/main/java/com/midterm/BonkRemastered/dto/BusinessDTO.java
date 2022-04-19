package com.midterm.BonkRemastered.dto;

import com.midterm.BonkRemastered.model.Business;
import org.springframework.web.multipart.MultipartFile;

public class BusinessDTO {

    private Long businessId;

    private Long owner;

    private String businessName;

    private String location;

    private String proofofBusiness;

    private MultipartFile image;

    /*private String imageLoc;*/

    public BusinessDTO(){}



    public BusinessDTO(Business business){
        this.businessId = business.getBusinessId();
        this.owner = business.getOwner().getId();
        this.businessName = business.getBusinessName();
        this.location = business.getLocation();
        this.proofofBusiness = business.getProofofBusiness();


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

    public String getProofofBusiness() {
        return proofofBusiness;
    }

    public void setProofofBusiness(String proofofBusiness) {
        this.proofofBusiness = proofofBusiness;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
