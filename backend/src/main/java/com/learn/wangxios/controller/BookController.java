package com.learn.wangxios.controller;

import com.learn.wangxios.entity.Book;
import com.learn.wangxios.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return bookRepository.findAll(request);
    }

    @PostMapping("/save")
    public String saveBook(@RequestBody Book book){
        System.out.println(book);
        Book result = bookRepository.save(book);
        if(result != null){
            return "success";
        }else {
            return "error";
        }
    }
}
