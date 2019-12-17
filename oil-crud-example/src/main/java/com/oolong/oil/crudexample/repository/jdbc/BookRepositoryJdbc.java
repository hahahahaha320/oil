package com.oolong.oil.crudexample.repository.jdbc;

import com.oolong.oil.crudexample.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepositoryJdbc {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Book> findAll()    {
        return jdbcTemplate.query("select id,name,state,create_time create_time from book", new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int i) throws SQLException {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setState(rs.getString("state"));
                return book;
            }
        });
    }
    public Book getById(int id)    {
        System.out.println("in jdbc ,id="+id);
        return jdbcTemplate.queryForObject("select id,name,state,create_time create_time from book where id="+id, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int i) throws SQLException {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setState(rs.getString("state"));
                return book;
            }
        });
    }
    public int insert(Book book)   {
        return 0;
    }
    public int update(Book book)   {
        return 0;
    }
    public void deleteById(int id) {

    }

}
