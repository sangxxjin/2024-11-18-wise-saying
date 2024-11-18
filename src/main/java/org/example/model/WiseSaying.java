package org.example.model;

public class WiseSaying {

    private String saying;
    private String author;

    public WiseSaying(String wiseSaying, String author) {
        this.saying = wiseSaying;
        this.author = author;
    }

    public String getWiseSaying() {
        return this.saying;
    }

    public String getAuthor() {
        return this.author;
    }

}