package com.bookstore.repository;

import com.bookstore.dao.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {
    @Query("SELECT b FROM Book b")
   public List<Book> findBooks();

//    @Query("SELECT b FROM Book b WHERE b.id=:id")
//    public Book findBooksById(@Param("id") Integer id);
    @Query("SELECT b FROM Book b WHERE b.id = :id")
    Book findBooksById(@Param("id") Integer id);
}
