package com.bookstore.bookstoremanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstoremanagementsystem.model.MyBookList;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Long>  {

    
}
