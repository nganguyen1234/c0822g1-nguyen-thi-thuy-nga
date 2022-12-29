package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String title;
    private String author;
    @Column(columnDefinition = "text")
    private String content;
    private boolean isDeleted;


    @ManyToOne
    @JsonBackReference
    private Category category;

    public Blog() {
    }

    public Blog(int id, String date, String title, String author, String content, boolean isDeleted, Category category) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.author = author;
        this.content = content;
        this.isDeleted = isDeleted;
        this.category = category;
    }

    public Blog(String date, String title, String author, String content) {
        this.date = date;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Blog(int id, String date, String title, String author, String content) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
