package com.bookstore.bookstoremanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstoremanagementsystem.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
