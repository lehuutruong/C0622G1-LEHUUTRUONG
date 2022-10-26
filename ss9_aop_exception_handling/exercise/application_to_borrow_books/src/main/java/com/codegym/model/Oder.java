package com.codegym.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int code;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book list;

    public Oder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Book getList() {
        return list;
    }

    public void setList(Book list) {
        this.list = list;
    }
}
