package com.lxk.book.controller;


import com.lxk.book.entitys.ArrivedBook;
import com.lxk.book.entitys.Book_Info;
import com.lxk.book.entitys.Book_catalog;
import com.lxk.book.entitys.Book_order;
import com.lxk.book.entitys.Book_reduce;
import com.lxk.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/10 19:09
 */

@Controller
//@RequestMapping(value = "/book")
public class BookController {
    private static final Logger LOG = Logger.getLogger(String.valueOf(LoginController.class));

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book_info")
    public ModelAndView Book_Info(){
        LOG.info("book_info");
        ArrayList<Book_Info> books_info=bookService.book_info();
        ModelAndView modelAndView=new ModelAndView("book_info");
        modelAndView.addObject("books_info",books_info);
        return modelAndView;
    }


    @RequestMapping(value = "/arrived_books")
    public ModelAndView Arrived_Books(){
        ArrayList<ArrivedBook> books=bookService.arrived_books();
        ModelAndView modelAndView=new ModelAndView("arrived_books");
        modelAndView.addObject("books",books);
        LOG.info(String.valueOf(books.size()));
        return modelAndView;
    }

    @RequestMapping(value = "/book_order")
    public ModelAndView Book_order(){
        ArrayList<Book_order> books=bookService.book_order();
        ModelAndView modelAndView=new ModelAndView("book_order");
        modelAndView.addObject("books",books);
        return modelAndView;
    }

    @RequestMapping(value = "/book_catalog")
    public ModelAndView Book_catalog(){
        ArrayList<Book_catalog> books=bookService.book_catalog();
        ModelAndView modelAndView=new ModelAndView("book_catalog");
        modelAndView.addObject("books",books);
        return modelAndView;
    }

    @RequestMapping(value = "/book_reduce")
    public ModelAndView Book_reduce(){
        ArrayList<Book_reduce> books=bookService.book_reduce();
        ModelAndView modelAndView=new ModelAndView("book_reduce");
        modelAndView.addObject("books",books);
        return modelAndView;
    }
}
