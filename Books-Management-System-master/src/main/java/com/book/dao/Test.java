package com.book.dao;

import com.book.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

@ContextConfiguration(locations = "classpath:book-context.xml")
public class Test {
    public static ArrayList<Book> arrayList;

    @Autowired
    public static JdbcTemplate jdbcTemplate;


    public static void main(String[] args) {
//        arrayList = Test.getAllBooks();
//        Book book = new Book();
//        book.setName("呵呵");
//        book.setAuthor("hehe");
//        book.setIntroduction("11111");
//        book.setIsbn("1");
//        int a = Test.addBook(book);

        //目标:使用jdbctemplate 执行sql
        //1. 构建数据库
        //spring 内置了一个数据库
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql:///library?serverTimezone=UTC");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//
//        //2. 创建jdbctemplate 实例
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //3. 执行sql,创建表test001
        System.out.println(jdbcTemplate);
        final ArrayList<Book> books=new ArrayList<Book>();
        String sql = "SELECT * FROM book_info";

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






    public static int addBook(Book book){
        String sql = "INSERT INTO book_info VALUES(NULL ,?,?,?,?,?,?,?,?,?,?,?)";
        String name=book.getName();
        String author=book.getAuthor();
        String publish=book.getPublish();
        String isbn=book.getIsbn();
        String introduction=book.getIntroduction();
        String language=book.getLanguage();
        BigDecimal price=book.getPrice();
        Date pubdate=book.getPubdate();
        int classId=book.getClassId();
        int pressmark=book.getPressmark();
        int state=book.getState();

        return jdbcTemplate.update(sql,new Object[]{name,author,publish,isbn,introduction,language,price,pubdate,classId,pressmark,state});
    }


    public static ArrayList<Book> getAllBooks(){
        final ArrayList<Book> books=new ArrayList<Book>();
        String sql = "SELECT * FROM book_info";

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
        return books;

    }
}
