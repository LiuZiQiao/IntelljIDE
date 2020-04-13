package com.book.domain;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Journal implements Serializable{

    private long JournalId;
    private String name;
    private String author;
    private String publish;
    private String isbn;
    private String introduction;
    private String language;
    private BigDecimal price;
    private Date pubdate;
    private int number;
    private int classId;
    private int pressmark;
    private int state;


}
