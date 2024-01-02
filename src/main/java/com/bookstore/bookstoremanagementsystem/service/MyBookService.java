package com.bookstore.bookstoremanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstoremanagementsystem.model.MyBookList;
import com.bookstore.bookstoremanagementsystem.repository.MyBookRepository;

@Service
public class MyBookService {
    @Autowired
    MyBookRepository mybookrepo;
    public void mybooklist(MyBookList mybooklist){
        mybookrepo.save(mybooklist);
    }

    public List<MyBookList> getmybooks(){
     return mybookrepo.findAll();
    }

    public void removebook(Long id) {
        mybookrepo.deleteById(id);
    }
}
