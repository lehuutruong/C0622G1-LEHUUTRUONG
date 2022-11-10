package com.codegym.dto;

import com.codegym.model.customer.CustomerType;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.impl.CustomerService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Collections;
import java.util.List;


public class CustomerDto implements Validator {
    private int id;
    private String name;
    private String dateOfBirth;
    private int gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    private CustomerType customerTypeList;
    private int deleteStatus = 1;
    private List<String> emailList;
    public CustomerDto() {
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

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (customerDto.getName().equals("")) {
            errors.rejectValue("name", "name", "name is not empty");
        } else {
            if (!customerDto.getName().matches("\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*")) {
                errors.rejectValue("name", "name", "Name must be not have number and first word must be capitalized");
            }
        }
        if (customerDto.getPhoneNumber().equals("")) {
            errors.rejectValue("phoneNumber", "phoneNumber", "phone Number is not empty");
        } else {
            if (!(customerDto.getPhoneNumber().matches("[0][9][0]\\d{7}") ||
                    customerDto.getPhoneNumber().matches("[0][9][1]\\d{7}") ||
                    customerDto.getPhoneNumber().matches("[(][8][4][)][+][9][0]\\d{7}") ||
                    customerDto.getPhoneNumber().matches("[(][8][4][)][+][9][1]\\d{7}"))) {
                errors.rejectValue("phoneNumber", "", "Phone number must be valid (090xxxxxxx) hoặc (091xxxxxxx) hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
            }
        }
        for (String idCard:customerDto.getEmailList()
             ) {if(idCard.equals(customerDto.getIdCard())){
                 errors.rejectValue("idCard","idCard","id Card is exists");
        }

        }
        if (customerDto.getIdCard().equals("")) {
            errors.rejectValue("idCard", "idCard", "id Card is not empty");
        } else {
            if (!(customerDto.getIdCard().matches("\\d{9}") ||
                    customerDto.getIdCard().matches("\\d{12}"))) {
                errors.rejectValue("idCard", "", "ID card must be valid (XXXXXXXXX) hoặc (XXXXXXXXXXXX)");
            }
        }
        for (String email:customerDto.emailList
        ) {
            if(email.equals(customerDto.getEmail())){
                errors.rejectValue("email","email","email is exists");
            }

        }
        if (customerDto.getEmail().equals("")) {
            errors.rejectValue("email", "email", "Email is not empty");
        } else {
            if (!customerDto.getEmail().matches("\\w+[@]\\w+[.]\\w+")) {
                errors.rejectValue("email", "", "Email must be valid");
            }
        }
        if (customerDto.getAddress().equals("")) {
            errors.rejectValue("address", "address", "address is not empty");
        }
    }
}
