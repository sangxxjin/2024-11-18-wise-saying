package org.example.model;

public class WiseSaying {

    private static int nextId = 1;
    private int id;
    private String saying;
    private String author;

    public WiseSaying(String saying, String author) {
        this.id = nextId++;
        this.saying = saying;
        this.author = author;
    }

    public int getId() {
        return this.id;
    }

    public String getWiseSaying() {
        return this.saying;
    }

    public String getAuthor() {
        return this.author;
    }
    public void setSaying(String saying) {
        this.saying = saying;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

}