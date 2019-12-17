package com.oolong.oil.crudexample.service.impl;

import com.oolong.oil.crudexample.model.Book;
import com.oolong.oil.crudexample.repository.jpa.BookRepositoryJpa;
import com.oolong.oil.crudexample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceJpaImpl implements BookService {

    @Autowired
    private BookRepositoryJpa bookRepository;

    public List<Book> getAllBook()  {
        return bookRepository.findAll();
    }

    public Book getById(int id)  {
        Optional<Book> optional = bookRepository.findById(id);
        return optional.isPresent()?optional.get():null;
    }

    @Override
    public int insert(Book book) {
        bookRepository.save(book);
        return 1;
    }

    @Override
    public int update(Book book) {
        bookRepository.save(book);
        return 1;
    }

    public void delete(int id)    {
        bookRepository.deleteById(id);
    }
}
