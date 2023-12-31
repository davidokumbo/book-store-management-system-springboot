package com.bookstore.bookstoremanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstoremanagementsystem.model.Book;
import com.bookstore.bookstoremanagementsystem.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository bRepo;

    public void savebook(Book b) {

         bRepo.save(b);
        
    }

    public List<Book> getallbooks() {
        return bRepo.findAll();
    }

}
