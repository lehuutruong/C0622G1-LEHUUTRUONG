package com.codegym.model.customer;

import com.codegym.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dateOfBirth;
    private int gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerTypeList;
    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private Set<Contract> contractList;
    private int deleteStatus=1;
    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerTypeList() {
        return customerTypeList;
    }

    public void setCustomerTypeList(CustomerType customerTypeList) {
        this.customerTypeList = customerTypeList;
    }

    public Set<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(Set<Contract> contractList) {
        this.contractList = contractList;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
