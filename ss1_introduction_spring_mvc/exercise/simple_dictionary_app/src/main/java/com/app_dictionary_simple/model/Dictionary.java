package com.app_dictionary_simple.model;

public class Dictionary {
    private String english;
    private String vn;

    public Dictionary() {
    }

    public Dictionary(String english, String vn) {
        this.english = english;
        this.vn = vn;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }
}
