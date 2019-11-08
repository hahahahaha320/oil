package com.oolong.oil.oilcrudexample.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "authorList")
    private List<Book> bookList;

    private Date birthday;
    private Date createTime;

}
