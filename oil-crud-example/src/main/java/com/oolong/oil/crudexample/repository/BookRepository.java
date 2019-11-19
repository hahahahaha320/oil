package com.oolong.oil.crudexample.repository;

import com.oolong.oil.crudexample.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {



}
