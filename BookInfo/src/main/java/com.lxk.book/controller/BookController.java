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

    @RequestMapping(value = "/addbook.html")
    public String book_add(){
        return "book_add";
    }

    @RequestMapping(value = "/book_add_do.html")
    public ModelAndView book_add_do(Book_Info bookInfo){
        int res = bookService.addBook(bookInfo);
        ModelAndView modelAndView = new ModelAndView("book_info");
        if (res>0){
            ModelAndView modelAndView1 = new ModelAndView("book_add");
            return modelAndView1;
        }
        System.out.println("增加失败--->"+bookInfo);
        return modelAndView;
    }

    @RequestMapping(value = "deletebook.html")
    public ModelAndView deletebook(String bookId){
        int res = bookService.deletebook(bookId);
        if (res>0){
            System.out.println("删除成功--->"+bookId);
        }
        ArrayList<Book_Info> books_info=bookService.book_info();
        ModelAndView modelAndView=new ModelAndView("book_info");
        modelAndView.addObject("books_info",books_info);
        return modelAndView;
    }

    @RequestMapping(value = "updatebook.html")
    public ModelAndView updatebook(String bookId){
        Book_Info books = bookService.getBook(bookId);
        System.out.println("edit books--->"+books);
        ModelAndView modelAndView=new ModelAndView("book_edit");
        modelAndView.addObject("books",books);
        return modelAndView;
    }

    @RequestMapping(value = "book_edit_do.html")
    public ModelAndView doUpdateBook(Book_Info bookInfo){
        System.out.println("update bookInfo--->"+bookInfo);
        int ret = bookService.deletebook(bookInfo.getTsbh());
        ModelAndView modelAndView = new ModelAndView("book_info");
        if (ret>0) {
            int res = bookService.updateBook(bookInfo);
            if (res>0){
                ArrayList<Book_Info> books = bookService.book_info();
                modelAndView.addObject("books",books);
                return modelAndView;
            }
        }
        return modelAndView;
    }

    /*
     *  //book_order
     */
    @RequestMapping(value = "updatebook_order.html")
    public ModelAndView updatebook_order(String bookId){
        Book_order books = bookService.getBook_order(bookId);
        System.out.println("edit bookorder--->"+books);
        ModelAndView modelAndView=new ModelAndView("bookorder_edit");
        modelAndView.addObject("books",books);
        return modelAndView;
    }

    //修改，先删后插入数据
    @RequestMapping(value = "doaupdatebook_order.html")
    public ModelAndView doUpdateBook_order(Book_order book_order){
//        System.out.println("update bookInfo--->"+bookInfo);
        int ret = bookService.deletebookorder(book_order.getDgh());
        ModelAndView modelAndView = new ModelAndView("book_order");
        if (ret>0) {
            int res = bookService.updateBookorder(book_order);
            if (res>0){
                ArrayList<Book_order> books = bookService.book_order();
                modelAndView.addObject("books",books);
                return modelAndView;
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "addbook_order.html")
    public String bookorder_add(){
        return "bookorder_add";
    }

    @RequestMapping(value = "doaddbook_order")
    public ModelAndView addbook_order(Book_order book_order){
        int ret = bookService.addBookOrder(book_order);
        ModelAndView modelAndView = new ModelAndView("book_order");
        if (ret>0){
            ArrayList<Book_order> books = bookService.book_order();
            modelAndView.addObject("books",books);
        }
        return modelAndView;
    }
//    deletebook_order.html
    @RequestMapping(value = "deletebook_order.html")
    public ModelAndView deletebook_order(String dgh){
        int ret = bookService.deletebookorder(dgh);
        ModelAndView modelAndView = new ModelAndView("book_order");
        if (ret>0){
            ArrayList<Book_order> books = bookService.book_order();
            modelAndView.addObject("books",books);
            return modelAndView;
        }
        return modelAndView;
    }

    // arrivedbook
    @RequestMapping(value = "deletebook_arrived.html")
    public ModelAndView deletebook_arrived(String bookId){
        int ret = bookService.deletebook_arived(bookId);
        ModelAndView modelAndView = new ModelAndView("arrived_books");
        if (ret>0){
            ArrayList<ArrivedBook> books = bookService.arrived_books();
            modelAndView.addObject("books",books);
            return modelAndView;
        }
        return modelAndView;
    }
    @RequestMapping(value = "updatebook_arrived.html")
    public ModelAndView updatebook_arrived(String bookId){
        ArrivedBook books = bookService.getArrivedBook(bookId);
        System.out.println("edit bookarrived--->"+books);
        ModelAndView modelAndView=new ModelAndView("bookarrived_edit");
        modelAndView.addObject("books",books);
        return modelAndView;
    }
    @RequestMapping(value = "dodoupdatebook_arrived")
    public ModelAndView doupdatebook_arrived(ArrivedBook arrivedBook){
        System.out.println("doupdatebook_arrived--->"+arrivedBook);
        int ret = bookService.deletebook_arived(arrivedBook.getDgh());
        ModelAndView modelAndView = new ModelAndView("arrived_books");
        if (ret>0) {
            int res = bookService.updateBookArrived(arrivedBook);
            if (res>0){
                ArrayList<ArrivedBook> books = bookService.arrived_books();
                modelAndView.addObject("books",books);
                return modelAndView;
            }
        }
        return modelAndView;
    }
    @RequestMapping(value = "addbookarrived.html")
    public String addbookarrived(){
        return "bookarrived_add";
    }

    @RequestMapping(value = "addbookarrived")
    public ModelAndView addbookarrived(ArrivedBook arrivedBook){
        int ret = bookService.addbook_arrived(arrivedBook);
        ModelAndView modelAndView = new ModelAndView("arrived_books");
        return modelAndView;
    }

    // book_catalog
    @RequestMapping(value = "deleteBook_catalog.html")
    public ModelAndView deeteBook_catalog(String bookId){
        int ret =  bookService.deletebook_catalog(bookId);
        ModelAndView modelAndView = new ModelAndView("book_catalog");
        if (ret>0){
            ArrayList<Book_catalog> books = bookService.book_catalog();
            modelAndView.addObject("books",books);
            return modelAndView;
        }
        return modelAndView;
    }

    @RequestMapping(value = "editBook_catalog.html")
    public ModelAndView updateBook_catalog(String bookId){
        Book_catalog book_catalog = bookService.getBook_catalog(bookId);
        ModelAndView modelAndView = new ModelAndView("bookcatalog_edit");
        modelAndView.addObject("books",book_catalog);
        return modelAndView;
    }

    @RequestMapping(value = "doupdtebook_catalog")
    public ModelAndView doupdtebook_catalog(Book_catalog book_catalog){
        System.out.println("doupdatebook_catalog--->" + book_catalog);
        int res = bookService.deletebook_catalog(book_catalog.getPjh());
        ModelAndView modelAndView = new ModelAndView("book_catalog");
        if (res>0){
            int ret = bookService.addbook_catalog(book_catalog);
            if (ret>0){
                ArrayList<Book_catalog> book_catalogs = bookService.book_catalog();
                modelAndView.addObject("books",book_catalogs);
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "addbookcatalog.html")
    public String addbookcatalog(){
        return "bookcatalog_add";
    }
    @RequestMapping(value = "addBookcatalog")
    public ModelAndView addBookcatalog(Book_catalog book_catalog){
        System.out.println("addbook_catalog--->"+book_catalog);
        ModelAndView modelAndView = new ModelAndView("book_catalog");
        int ret = bookService.addbook_catalog(book_catalog);
        return modelAndView;
    }


    // book_reduce
    @RequestMapping(value = "deleteBook_reduce.html")
    public ModelAndView deeteBook_reduce(String bookId){
        int ret =  bookService.deletebook_reduce(bookId);
        ModelAndView modelAndView = new ModelAndView("book_reduce");
        if (ret>0){
            ArrayList<Book_reduce> books = bookService.book_reduce();
            modelAndView.addObject("books",books);
        }
        return modelAndView;
    }

    @RequestMapping(value = "editBook_reduce.html")
    public ModelAndView updateBook_reduce(String bookId){
        Book_reduce book_reduce = bookService.getBook_reduce(bookId);
        System.out.println("editBookReduce--->"+book_reduce);
        ModelAndView modelAndView = new ModelAndView("bookreduce_edit");
        modelAndView.addObject("books",book_reduce);
        return modelAndView;
    }

    @RequestMapping(value = "doupdtebook_reduce")
    public ModelAndView doupdtebook_catalog(Book_reduce book_reduce){
        System.out.println("doupdatebook_reduce--->" + book_reduce);
        int res = bookService.deletebook_reduce(book_reduce.getJsrq());
        ModelAndView modelAndView = new ModelAndView("book_reduce");
        if (res>0){
            int ret = bookService.addbook_reduce(book_reduce);
            if (ret>0){
                ArrayList<Book_reduce> book_reduces = bookService.book_reduce();
                modelAndView.addObject("books",book_reduces);
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "addbookreduce.html")
    public String addbookreduce(){
        return "bookreduce_add";
    }
    @RequestMapping(value = "addBookreduce")
    public ModelAndView addBookreduce(Book_reduce book_reduce){
        System.out.println("addbook_reduce--->"+book_reduce);
        ModelAndView modelAndView = new ModelAndView("book_reduce");
        int ret = bookService.addbook_reduce(book_reduce);
        if (ret>0){
            ArrayList<Book_reduce> book_reduces = bookService.book_reduce();
            modelAndView.addObject("books",book_reduces);
        }
        return modelAndView;
    }

}
