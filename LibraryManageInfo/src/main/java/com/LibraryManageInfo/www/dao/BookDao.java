package com.LibraryManageInfo.www.dao;

import com.LibraryManageInfo.www.entitys.ArrivedBook;
import com.LibraryManageInfo.www.entitys.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/10 19:10
 */

@Mapper
public interface BookDao {
    @Select("select *from book_info")
    public List<Book> getAllBoot();

    @Select("select *from arrived_info")
    public List<ArrivedBook> getArrivedBook();
}
