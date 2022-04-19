package com.midterm.BonkRemastered.dto;

import com.midterm.BonkRemastered.model.User;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO {

    private Long Id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String email;


    private String role;

    private String phoneNum;

    private String password;


    private String cPassword;


    private Set<BusinessDTO> businessList;


    public UserDTO() {
    }


    public UserDTO(User user) {
        this.Id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.middleName = user.getMiddleName();
        this.email = user.getEmail();
        this.phoneNum = user.getPhoneNum();
        this.role = user.getRole().getName();

        this.businessList = Optional.ofNullable(user.getBusinessList())
                .orElseGet(Collections::emptySet)
                .stream()
                .map(BusinessDTO::new)
                .collect(Collectors.toSet());


    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public Set<BusinessDTO> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(Set<BusinessDTO> businessList) {
        this.businessList = businessList;
    }

}