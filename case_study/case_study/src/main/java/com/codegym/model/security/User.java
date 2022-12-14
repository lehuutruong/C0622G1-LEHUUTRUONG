package com.codegym.model.security;

import com.codegym.model.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private Integer status = 1;

    @JsonBackReference
    @OneToMany(mappedBy = "role")
    private Set<UserRole> UserRoles;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    public User() {
    }

    public User(Integer id, String username, String password, Integer status,
                Set<UserRole> userRoles, Employee employee) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        UserRoles = userRoles;
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<UserRole> getUserRoles() {
        return UserRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        UserRoles = userRoles;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
