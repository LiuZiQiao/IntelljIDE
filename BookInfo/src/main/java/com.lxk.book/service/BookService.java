package com.lxk.book.service;

import com.lxk.book.dao.BookDao;
import com.lxk.book.entitys.ArrivedBook;
import com.lxk.book.entitys.Book_Info;
import com.lxk.book.entitys.Book_catalog;
import com.lxk.book.entitys.Book_order;
import com.lxk.book.entitys.Book_reduce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public int updateBook(Book_Info bookInfo){
        return bookDao.updateBookInfo(bookInfo);
    }

    public int deleteBook(String tsbh){
        return bookDao.deleteBookBytsbh(tsbh);
    }

    public Book_Info getBook(String tsbh){
        return bookDao.getBook(tsbh);
    }

    public ArrayList<ArrivedBook> arrived_books() {
            return bookDao.arrived_books();
    }

    public ArrayList<Book_Info> book_info() {
        return bookDao.book_info();
    }

    public ArrayList<Book_order> book_order() {
        return bookDao.book_order();
    }

    public ArrayList<Book_catalog> book_catalog() {
        return bookDao.book_catalog();
    }
    public ArrayList<Book_reduce> book_reduce() {
        return bookDao.book_reduce();
    }

    public int addBook(Book_Info bookInfo) {
        return bookDao.addBook(bookInfo);
    }

    public int deletebook(String bookId) {
        return bookDao.deleteBookBytsbh(bookId);
    }


    //book_order
    public int deletebookorder(String dgh) {
        return bookDao.deleteBookOrderBydgh(dgh);
    }

    public int updateBookorder(Book_order book_order) {
        return bookDao.updateBookOrder(book_order);
    }

    public Book_order getBook_order(String dgh){
        return bookDao.getBookOrder(dgh);
    }

    public int addBookOrder(Book_order book_order){
        return bookDao.addBookOrder(book_order);
    }
}
