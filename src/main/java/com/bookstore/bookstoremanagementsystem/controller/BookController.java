package com.bookstore.bookstoremanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.bookstoremanagementsystem.model.Book;
import com.bookstore.bookstoremanagementsystem.model.MyBookList;
import com.bookstore.bookstoremanagementsystem.service.BookService;
import com.bookstore.bookstoremanagementsystem.service.MyBookService;

import jakarta.websocket.server.PathParam;

@Controller
public class BookController {

    @Autowired
    BookService bService;
    @Autowired
    MyBookService mybookservice;

    


    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("book_register")
    public String bookregister(){
        return "registerbookpage";
    }

    @GetMapping("available_books")
    public ModelAndView availableBooks(){
        List<Book> books =bService.getallbooks();
        // ModelAndView mov = new ModelAndView("availablebookpage");
        //  ModelAndView mov = new ModelAndView();
        // mov.setViewName("availablebookpage");
        // mov.addObject("booklist", books);
    return new ModelAndView("availablebookpage","booklist", books);
    }

    @GetMapping("my_books")
    public ModelAndView mybookspage(){
       List<MyBookList> mybooks = mybookservice.getmybooks();
        return new ModelAndView("mybookspage","mybooks",mybooks);
    }

    @GetMapping("my_bookid")
    public String mybooks(@RequestParam Long bookid){
        bService.getbook(bookid);
        return "redirect:/available_books";
    }

    @PostMapping("/save")
    public String savebook(@ModelAttribute Book b){
        bService.savebook(b);
        return "redirect:/available_books";
        
    }

    @GetMapping("removefrommylist")
    public String removebook(@RequestParam Long id){
         mybookservice.removebook(id);

         return "redirect:/my_books";

    }
    @GetMapping("deletebook")
    public String deletebook(@RequestParam Long bookid){
        bService.deletebook(bookid);
       return "redirect:/available_books";
    }

   
}
