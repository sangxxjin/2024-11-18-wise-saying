package org.example.model;

public class WiseSaying {

    private static int nextId = 1;
    private final int id;
    private String content;
    private String author;

    public WiseSaying(String content, String author) {
        this.id = nextId++;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return this.id;
    }

    public String getWiseSaying() {
        return this.content;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}