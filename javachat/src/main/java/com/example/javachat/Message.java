package com.example.javachat;

class Message {
    String author;
    String text;

    public Message(final String author, final String text) {
        this.author = author;
        this.text = text;
    }

    @Override
    public String toString() {
        return author + ": " + text;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }
}
