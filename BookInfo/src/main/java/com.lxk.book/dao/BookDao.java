package com.lxk.book.dao;

import com.lxk.book.entitys.ArrivedBook;
import com.lxk.book.entitys.Book_Info;
import com.lxk.book.entitys.Book_catalog;
import com.lxk.book.entitys.Book_order;
import com.lxk.book.entitys.Book_reduce;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/10 19:10
 */

@Mapper
public interface BookDao {


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

}
