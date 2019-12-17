package com.oolong.oil.crudexample.controller;

import com.oolong.oil.crudexample.model.Book;
import com.oolong.oil.crudexample.service.BookService;
import com.oolong.oil.crudexample.service.impl.BookServiceJdbcImpl;
import com.oolong.oil.crudexample.service.impl.BookServiceJpaImpl;
import com.oolong.oil.crudexample.service.impl.BookServiceMybatisImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {


    private @Autowired BookServiceMybatisImpl bookService;

//    private @Autowired BookServiceJdbcImpl bookService;

//    private @Autowired BookServiceJpaImpl bookService;

    @RequestMapping("/get_all")
    public List<Book> getAll()  {
        return bookService.getAllBook();
    }

    @RequestMapping("/get_one")
    public Book getOne(@RequestParam int id)  {
        return bookService.getById(id);
    }

    @PostMapping("/add")
    public String add(@RequestBody Book book)  {
        bookService.insert(book);
        return "ok";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam int id)  {
        bookService.delete(id);
        return "ok";
    }

    @PostMapping("/edit")
    public String edit(@RequestBody Book book)  {
        bookService.update(book);
        return "ok";
    }
}
