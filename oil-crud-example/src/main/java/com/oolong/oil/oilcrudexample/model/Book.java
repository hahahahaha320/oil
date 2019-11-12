package com.oolong.oil.oilcrudexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_detail_id")
    private BookDetail bookDetail;

    @JsonIgnoreProperties(ignoreUnknown = true, value = {"bookList"})
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private List<Author> authorList;

    @ManyToOne
    @JoinColumn(name = "press_id")
    private Press press;

    @JsonIgnoreProperties(ignoreUnknown = true, value = {"book"})
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Chapter> chapterList;


    private String state = "ok";
    private Date createTime;

}
