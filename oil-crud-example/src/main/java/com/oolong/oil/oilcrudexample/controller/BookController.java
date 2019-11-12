package com.oolong.oil.oilcrudexample.controller;

import com.oolong.oil.oilcrudexample.model.Book;
import com.oolong.oil.oilcrudexample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public String add(@RequestBody Book book)  {
        bookService.save(book);
        return "ok";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam int id)  {
        bookService.delete(id);
        return "ok";
    }

    @PostMapping("/edit")
    public String edit(@RequestBody Book book)  {
        bookService.save(book);
        return "ok";
    }
}
