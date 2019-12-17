package com.oolong.oil.crudexample.service.impl;

import com.oolong.oil.crudexample.model.Book;
import com.oolong.oil.crudexample.repository.jpa.BookRepositoryJpa;
import com.oolong.oil.crudexample.repository.mybatis.BookRepositoryMybatis;
import com.oolong.oil.crudexample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceMybatisImpl implements BookService {

    @Autowired
    private BookRepositoryMybatis bookRepository;

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
