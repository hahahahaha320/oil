package com.oolong.oil.crudexample.service;

import com.oolong.oil.crudexample.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {


    List<Book> getAllBook();

    Book getById(int id);

    int insert(Book book);
    int update(Book book);

    void delete(int id);
}
