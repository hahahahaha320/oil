package com.oolong.oil.oilcrudexample.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "book_detail")
public class BookDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @OneToOne(mappedBy = "bookDetail")
//    private Book book;

    private String descr;

    private Date createTime;

    public BookDetail() {
    }

}
