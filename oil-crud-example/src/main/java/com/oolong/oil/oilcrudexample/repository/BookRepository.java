package com.oolong.oil.oilcrudexample.repository;

import com.oolong.oil.oilcrudexample.dataobject.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {



}
