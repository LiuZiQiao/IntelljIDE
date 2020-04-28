package com.lxk.book.dao;

import com.lxk.book.entitys.ArrivedBook;
import com.lxk.book.entitys.Book_Info;
import com.lxk.book.entitys.Book_catalog;
import com.lxk.book.entitys.Book_order;
import com.lxk.book.entitys.Book_reduce;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/10 19:10
 */

@Mapper
public interface BookDao {

    @Delete("delete from book_info where tsbh = #{tsbh}")
    public int deleteBookBytsbh(String tsbh);

    @Insert("insert into book_info value(#{tsbh},#{tstxm},#{zbt},#{blbt},#{fbt},#{jsgjz},"+
            "#{cbh},#{dyzz},#{qtzz},#{jg},#{wxlxm},#{zdm},#{flh},#{zgyzm},#{yzm},#{kb},"+
            "#{ys},#{bc},#{fjmc},#{csmc},#{csbz},#{cbs},#{cbsjbm},#{cbd},#{cbrq},#{fxdw},#{bz},#{tsztm})")
    public int addBook(Book_Info bookInfo);

    @Insert("insert into book_info value(#{tsbh},#{tstxm},#{zbt},#{blbt},#{fbt},#{jsgjz},"+
            "#{cbh},#{dyzz},#{qtzz},#{jg},#{wxlxm},#{zdm},#{flh},#{zgyzm},#{yzm},#{kb},"+
            "#{ys},#{bc},#{fjmc},#{csmc},#{csbz},#{cbs},#{cbsjbm},#{cbd},#{cbrq},#{fxdw},#{bz},#{tsztm})")
    public int updateBookInfo(Book_Info bookInfo);

    @Select("SELECT * FROM book_arrived")
    public ArrayList<ArrivedBook> arrived_books();

    @Select("select *from book_info")
    public ArrayList<Book_Info> book_info();

    @Select("select *from book_order")
    public ArrayList<Book_order> book_order();

    @Select("select *from book_catalog")
    public ArrayList<Book_catalog> book_catalog();

    @Select("select *from book_reduce")
    public ArrayList<Book_reduce> book_reduce();

    @Select("select *from book_info where tsbh =#{tsbh}")
    public Book_Info getBook(String tsbh);

    //Book_order
    @Delete("delete from book_order where dgh=#{dgh}")
    public int deleteBookOrderBydgh(String dgh);

    @Insert("insert into book_order value(#{dgh},#{ydjg},#{ydcs},#{ydrq},#{hdfsm},#{zdrzgh},#{bz})")
    public int addBookOrder(Book_order book_order);

    @Insert("insert into book_order value(#{dgh},#{ydjg},#{ydcs},#{ydrq},#{hdfsm},#{zdrzgh},#{bz})")
    public int updateBookOrder(Book_order book_order);

    @Select("select *from book_order where dgh=#{dgh}")
    Book_order getBookOrder(String dgh);

    //Bookrarrived
    @Delete("delete from book_arrived where dgh=#{dgh}")
    public int deletebook_arrived(String dgh);

    @Insert("insert into book_arrived value(#{dgh},#{sdjg},#{sdcs},#{dhrq},#{jsrzgh},#{bz})")
    public int addbook_arrived(ArrivedBook arrivedBook);

    @Insert("insert into book_arrived value(#{dgh},#{sdjg},#{sdcs},#{dhrq},#{jsrzgh},#{bz})")
    public int updatebook_arrived(ArrivedBook arrivedBook);

    @Select("select *from book_arrived where dgh=#{dgh}")
    public ArrivedBook getArrivedBook(String dgh);

    //book_catalog
    @Insert("insert into book_catalog value(#{pjh},#{jch},#{bmrq},#{gcd})")
    public int addbook_catalog(Book_catalog book_catalog);
    @Select("select *from book_catalog where pjh=#{pjh}")
    public Book_catalog getBook_catalog(String pjh);
    @Delete("delete from book_catalog where pjh=#{pjh}")
    public int deleteBook_catalog(String pjh);

    //book_reduce
    @Insert("insert into book_reduce value(#{jsrq},#{jsyy},#{jsjg},#{jsrzgh})")
    public int addbook_reduce(Book_reduce book_reduce);
    @Select("select *from book_reduce where jsrq=#{jsrq}")
    public Book_reduce getBook_reduce(String jsrq);
    @Delete("delete from book_reduce where jsrq=#{jsrq}")
    public int deleteBook_reduce(String jsrq);
}