package com.example.guestbook;

public class Entry {
    private int id;
    private String author;
    private String content;

    public Entry(final int id, final String author, final String content) {
        this(author, content);
        this.id = id;
    }

    public Entry(final String author, final String content) {
        this.author = author;
        this.content = content;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Wpis nr: " + id + "\n"
                + "autor: " + author + "\n"
                + "treść: " + content;
    }
}
