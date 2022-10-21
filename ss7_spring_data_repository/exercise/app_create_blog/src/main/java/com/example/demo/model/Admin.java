package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameAdmin;
    @ManyToMany(mappedBy = "adminList")
    private Set<AppBlog> appBlogs;

    public Admin() {
    }

    public Admin(int id, String nameAdmin, Set<AppBlog> appBlogs) {
        this.id = id;
        this.nameAdmin = nameAdmin;
        this.appBlogs = appBlogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAdmin() {
        return nameAdmin;
    }

    public void setNameAdmin(String nameAdmin) {
        this.nameAdmin = nameAdmin;
    }

    public Set<AppBlog> getAppBlogs() {
        return appBlogs;
    }

    public void setAppBlogs(Set<AppBlog> appBlogs) {
        this.appBlogs = appBlogs;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", nameAdmin='" + nameAdmin + '\'' +
                ", appBlogs=" + appBlogs +
                '}';
    }
}
