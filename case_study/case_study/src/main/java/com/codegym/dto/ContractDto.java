package com.codegym.dto;

import com.codegym.model.contract.ContractDetail;
import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;

import java.util.Set;

public class ContractDto {
    private int id;
    private String startDate;
    private String endDate;
    private double deposit;
    private Set<ContractDetail> contractDetailList;
    private Employee employee;
    private Customer customer;
    private Facility facility;
    private  double totalPrice;
    private int deleteStatus=1;
    public ContractDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Set<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(Set<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
    public void getTotalCost() {
        this.totalPrice = this.facility.getCost();
        if (this.contractDetailList != null) {
            for (ContractDetail contractDetail : this.contractDetailList) {
                this.totalPrice += contractDetail.getQuantity() * contractDetail.getAttachFacility().getCost();
            }
        }
    }
}
