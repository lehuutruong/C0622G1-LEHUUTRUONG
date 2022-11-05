package com.example.demo.dto;

public class AppBlogDto {
    private int id;
    private String name;
    private String content;
    private String dateOfWriting;

    public AppBlogDto() {
    }

    public AppBlogDto(int id, String name, String content, String dateOfWriting) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.dateOfWriting = dateOfWriting;
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

    public void setName(String ame) {
        this.name = name;
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
