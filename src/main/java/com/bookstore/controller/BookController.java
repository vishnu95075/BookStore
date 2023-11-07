package com.bookstore.controller;

import com.bookstore.dao.Book;
import com.bookstore.dao.ErrorMessage;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBook() {
        try {
            return ResponseEntity.status(200).body((List<Book>) bookService.getAllBook());
        } catch (Exception e) {
            System.out.println("Here Book Error"+e);
        }
        return null;
    }
    @PostMapping()
    public ResponseEntity<Book> getAllBook(@RequestBody Book book) {
        try {
            Book book1= bookService.create(book);
            return ResponseEntity.status(201).body(book1);
        } catch (Exception e) {
            System.out.println("Here Book Error" + e);
           return ResponseEntity.status(500).body(null);
        }
    }
    @PostMapping("/{id}")
    public ResponseEntity<Book> getAllBook(@PathVariable String id,@RequestBody Book book) {
        try {
            Book book1= bookService.create(book);
            return ResponseEntity.status(201).body(book1);
        } catch (Exception e) {
            System.out.println("Here Book Error" + e);
            return ResponseEntity.status(500).body(null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> getAllBook(@PathVariable String id) {
        try {
            Integer idd = Integer.parseInt(id);
            bookService.delete(idd);
            return ResponseEntity.status(201).body("Book is successfully deleted");
        } catch (Exception e) {
            System.out.println("Here Book Error" + e);
            return ResponseEntity.status(500).body("Book is not successfully deleted");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<?>> getBookById(@PathVariable String id) {
        try {
            Integer idd = Integer.parseInt(id);
            Optional<Book> book1= bookService.getBook(idd);
            if(book1.isEmpty()){
                ErrorMessage errorMessage=new ErrorMessage();
                errorMessage.setErrorMessage("e.getMessage()");
                errorMessage.setMessage("Book not found");
                errorMessage.setStatusCode(500);
                errorMessage.setTime_now(6767);
                System.out.println("Here Book Error");
                return ResponseEntity.status(500).body(Optional.of(errorMessage));
            }
            return ResponseEntity.status(200).body(book1);
        } catch (Exception e) {
            ErrorMessage errorMessage=new ErrorMessage();
            errorMessage.setErrorMessage(e.getMessage());
            errorMessage.setMessage("Book not found");
            errorMessage.setStatusCode(500);
            errorMessage.setTime_now(6767);
            System.out.println("Here Book Error" + e);
            return ResponseEntity.status(500).body(Optional.of(errorMessage));
        }
    }

}
