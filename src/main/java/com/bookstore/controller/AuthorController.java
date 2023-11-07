package com.bookstore.controller;

import com.bookstore.dao.Author;
import com.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping()
    public List<Author> getAuthor() {
        return (List<Author>) authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Author> getAuthorById(@PathVariable String id) {
        try {
            Integer idd = Integer.parseInt(id);
            return authorRepository.findById(idd);
        } catch (Exception e) {
            System.out.println("Error is : " + e);
            return Optional.empty();
        }
    }
    @PostMapping("/{id}")
    public String getAuthorById(@PathVariable String id, @RequestBody Author newAuthor) {
        try {
            System.out.println("Id is :"+id);
            newAuthor.setId(Integer.parseInt(id));
            System.out.println("Author is : "+newAuthor);
            authorRepository.save(newAuthor);
            return "Author Successfully Saved";
        } catch (Exception e) {
            System.out.println("Error is : " + e);
            return "Not saved ";
        }
    }
}
