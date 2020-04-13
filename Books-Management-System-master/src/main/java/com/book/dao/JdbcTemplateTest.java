package com.book.dao;

import com.book.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:book-context.xml")
public class JdbcTemplateTest {


    @Autowired
    private JdbcTemplate jdbcTemplate;
//    String sql = "SELECT number FROM book_info where book_id = 10000001";
//    String sql = "SELECT number FROM book_info where book_id = ?";
    String sql = "SELECT * FROM book_info where book_id = ?";
    @Test
    public void test3(){
        Book book = new Book();
        long bookId = 10000001;
        jdbcTemplate.query(sql, new Object[]{bookId}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                book.setBookId(resultSet.getLong("book_id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublish(resultSet.getString("publish"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setIntroduction(resultSet.getString("introduction"));
                book.setLanguage(resultSet.getString("language"));
                book.setPrice(resultSet.getBigDecimal("price"));
                book.setNumber(resultSet.getInt("number"));
                book.setPubdate(resultSet.getDate("pubdate"));
                book.setClassId(resultSet.getInt("class_id"));
                book.setPressmark(resultSet.getInt("pressmark"));
                book.setState(resultSet.getInt("state"));
            }
        });
//        BookDao bookDao = new BookDao();
//        System.out.println(bookDao.getBook((long) 10000001));
        System.out.println(book.getNumber());
    }

    @Test
    public void test2(){
        int number = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(number);
    }


    @Test
    public void test1()
    {
        final ArrayList<Book> books=new ArrayList<Book>();
        String sql = "SELECT * FROM book_info";
        System.out.println(jdbcTemplate);
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()){
                    Book book =new Book();
                    book.setPrice(resultSet.getBigDecimal("price"));
                    book.setState(resultSet.getInt("state"));
                    book.setPublish(resultSet.getString("publish"));
                    book.setPubdate(resultSet.getDate("pubdate"));
                    book.setName(resultSet.getString("name"));
                    book.setIsbn(resultSet.getString("isbn"));
                    book.setClassId(resultSet.getInt("class_id"));
                    book.setBookId(resultSet.getLong("book_id"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setIntroduction(resultSet.getString("introduction"));
                    book.setPressmark(resultSet.getInt("pressmark"));
                    book.setLanguage(resultSet.getString("language"));
                    System.out.println(book);
                    books.add(book);
                }
            }
        });
        System.out.println(books);
    }

    @Test
    public void test0(){
        System.out.println(jdbcTemplate);
    }
}