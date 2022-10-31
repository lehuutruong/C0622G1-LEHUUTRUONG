package com.example.demo.dto;

public class AppBlogDto {
    private int id;
    private String author;
    private String content;
    private String dateOfWriting;

    public AppBlogDto() {
    }

    public AppBlogDto(int id, String author, String content, String dateOfWriting) {
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
}
