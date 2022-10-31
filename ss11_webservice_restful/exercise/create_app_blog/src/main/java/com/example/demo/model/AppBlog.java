package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AppBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String content;
    private String dateOfWriting;
    @ManyToOne
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "categrory_id", referencedColumnName = "id")
    private Category category;
    @ManyToMany
    @JsonBackReference
    @JsonIgnore
    @JoinTable(name = "blog_admin", joinColumns = @JoinColumn(name = "app_blog_id"), inverseJoinColumns = @JoinColumn(name = "admin_id"))
    private Set<Admin> adminList;

    public AppBlog() {
    }

    public AppBlog(int id, String author, String content, String dateOfWriting) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.dateOfWriting = dateOfWriting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateOfWriting() {
        return dateOfWriting;
    }

    public void setDateOfWriting(String dateOfWriting) {
        this.dateOfWriting = dateOfWriting;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(Set<Admin> adminList) {
        this.adminList = adminList;
    }


}
