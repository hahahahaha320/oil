package com.oolong.oil.oilcrudexample.controller;

import com.oolong.oil.oilcrudexample.dataobject.Book;
import com.oolong.oil.oilcrudexample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/get_all")
    public List<Book> getAll()  {
        return bookService.getAllBook();
    }
    @RequestMapping("/get_one")
    public Book getOne(@RequestParam int id)  {
        return bookService.getById(id);
    }


}
