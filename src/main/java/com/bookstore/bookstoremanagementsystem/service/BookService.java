package com.bookstore.bookstoremanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstoremanagementsystem.model.Book;
import com.bookstore.bookstoremanagementsystem.model.MyBookList;
import com.bookstore.bookstoremanagementsystem.repository.BookRepository;
import com.bookstore.bookstoremanagementsystem.repository.MyBookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository bRepo;

    @Autowired
    MyBookRepository  mybookrepo;

    public void savebook(Book b) {

         bRepo.save(b);
        
    }

    public List<Book> getallbooks() {
        return bRepo.findAll();
    }

    public String getbook(Long bookid) {
       Book mybook = bRepo.findById(bookid).get();
       MyBookList myb = new MyBookList( mybook.getId(), mybook.getName(),mybook.getAuthor(),mybook.getPrice());
       mybookrepo.save(myb);

        return null;
    }

    public void deletebook(Long bookid) {
        bRepo.deleteById(bookid);
        mybookrepo.deleteById(bookid);
    }

}
