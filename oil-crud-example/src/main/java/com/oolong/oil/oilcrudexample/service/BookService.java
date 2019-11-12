package com.oolong.oil.oilcrudexample.service;

import com.oolong.oil.oilcrudexample.model.Book;
import com.oolong.oil.oilcrudexample.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBook()  {
        return bookRepository.findAll();
    }

    public Book getById(int id)  {
        Optional<Book> optional = bookRepository.findById(id);
        return optional.isPresent()?optional.get():null;
    }

    public Book save(Book book)    {
        return bookRepository.save(book);
    }

    public void delete(int id)    {
        bookRepository.deleteById(id);
    }
}
