package com.LibraryManageInfo.www.controller;

import com.LibraryManageInfo.www.dao.BookDao;
import com.LibraryManageInfo.www.entitys.ArrivedBook;
import com.LibraryManageInfo.www.entitys.Book;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/10 19:09
 */

@Controller
//@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "/getAllBook")
//    @ResponseBody
    public String getAllBook(){

        List<Book> allBoot = bookDao.getAllBoot();
        System.out.println(allBoot);
        return "member-list";
    }

    @RequestMapping(value = "/getArrivedBook")
    public String getArrivedBook(Integer pageNum, Integer maxPage,HttpServletRequest request){
        if (pageNum <= 1) {
            pageNum = 1; // 分页的逻辑判断 ,如果当前页小于1就显示第一页
        } else if (pageNum >= maxPage) {
            pageNum = maxPage;// 如果当前页大于最大页就显示最大页
        }
        PageHelper.startPage(pageNum, 3);
        List<ArrivedBook> arrivedBook = bookDao.getArrivedBook();
        request.setAttribute("bookList",arrivedBook);
        for (Object book: arrivedBook) {
            System.out.println(book);
        }
        return "showAllBooks";
    }
}
