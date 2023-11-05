package com.bookstore.dao;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id")
    private Integer  id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Author author;

    public Book(Integer id, String name, Author author) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
    }


    public Book() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
    }

}
