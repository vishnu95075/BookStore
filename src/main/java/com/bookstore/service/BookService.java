package com.bookstore.service;

import com.bookstore.dao.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> getAllBook() {
        return bookRepository.findAll();
    }


    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public void delete(Integer id) {
        bookRepository.deleteById(id);
        return;
    }


    public Optional<Book> getBook(Integer idd) {
        return bookRepository.findById(idd);
    }
}
