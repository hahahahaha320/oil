package com.oolong.oil.crudexample.service.impl;

import com.oolong.oil.crudexample.model.Book;
import com.oolong.oil.crudexample.repository.jdbc.BookRepositoryJdbc;
import com.oolong.oil.crudexample.repository.mybatis.BookRepositoryMybatis;
import com.oolong.oil.crudexample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class BookServiceJdbcImpl implements BookService {

    @Autowired
    private BookRepositoryJdbc bookRepository;

    public List<Book> getAllBook()  {

        return bookRepository.findAll();
    }

    public Book getById(int id)  {
        return bookRepository.getById(id);
    }

    @Override
    public int insert(Book book) {
        return bookRepository.insert(book);
    }

    @Override
    public int update(Book book) {
        return bookRepository.update(book);
    }

    public void delete(int id)    {
        bookRepository.deleteById(id);
    }
}
