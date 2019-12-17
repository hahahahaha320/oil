package com.oolong.oil.crudexample.repository.mybatis;

import com.oolong.oil.crudexample.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepositoryMybatis {

    List<Book> findAll();
    Book getById(int id);
    int insert(Book book);
    int update(Book book);
    void deleteById(int id);

}
