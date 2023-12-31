package com.bookstore.bookstoremanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.bookstoremanagementsystem.model.Book;
import com.bookstore.bookstoremanagementsystem.service.BookService;

@Controller
public class BookController {

    @Autowired
    BookService bService;

    


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
    public String mybooks(){
        return "mybookspage";
    }

    @PostMapping("/save")
    public String savebook(@ModelAttribute Book b){
        bService.savebook(b);
        return "redirect:/available_books";
        
    }
}
