package com.springreactive.firstproject.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.swing.*;

@Table("book_details")
public class Book {

    @Id
    @Column("book_id")
    private int bookId;

    private String name;

    @Column("book_description")
    private String description;

    private String publisher;

    private String author;

    public Book(int bookId, String author, String publisher, String name, String description) {
        this.bookId = bookId;
        this.author = author;
        this.publisher = publisher;
        this.name = name;
        this.description = description;
    }

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
