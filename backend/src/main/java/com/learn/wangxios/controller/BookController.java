package com.learn.wangxios.controller;


import com.learn.wangxios.entity.Book;
import com.learn.wangxios.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll")
    public List<Book> FindAll(){
        return bookRepository.findAll();
    }
}
