package com.codegym.dto;

import com.codegym.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class CustomerDto implements Validator {
    private int id;
    @NotEmpty(message = "Name is not empty")
    private String name;
    @NotEmpty(message = "Date Of Birth is not empty")
    private String dateOfBirth;
    @NotNull(message = "Gender is not empty")
    private int gender;
    @NotEmpty(message = "Id Card is not empty")
    private String idCard;
    @NotEmpty(message = "Phone Number is not empty")
    private String phoneNumber;
    @NotEmpty(message = "Email is not empty")
    private String email;
    @NotEmpty(message = "Address is not empty")
    private String address;
    private CustomerType customerTypeList;
    private int deleteStatus = 1;

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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (!customerDto.getName().matches("\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*")) {
            errors.rejectValue("name", "name", "Name must be not have number and first word must be capitalized");
        }

        if (!(customerDto.getPhoneNumber().matches("[0][9][0]\\d{7}") ||
                customerDto.getPhoneNumber().matches("[0][9][1]\\d{7}") ||
                customerDto.getPhoneNumber().matches("[(][8][4][)][+][9][0]\\d{7}") ||
                customerDto.getPhoneNumber().matches("[(][8][4][)][+][9][1]\\d{7}"))) {
            errors.rejectValue("phoneNumber", "phone-number", "Phone number must be valid (090xxxxxxx) hoặc (091xxxxxxx) hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
        }

        if (!(customerDto.getIdCard().matches("\\d{9}") ||
                customerDto.getIdCard().matches("\\d{12}"))) {
            errors.rejectValue("idCard", "id-card", "ID card must be valid (XXXXXXXXX) hoặc (XXXXXXXXXXXX)");
        }

        if (!customerDto.getEmail().matches("\\w+[@]\\w+[.]\\w+")) {
            errors.rejectValue("email", "email", "Email must be valid");
        }
    }
}
