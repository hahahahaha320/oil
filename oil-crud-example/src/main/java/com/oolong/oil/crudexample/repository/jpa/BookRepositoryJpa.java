package com.oolong.oil.crudexample.repository.jpa;

import com.oolong.oil.crudexample.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositoryJpa extends JpaRepository<Book,Integer> {



}
