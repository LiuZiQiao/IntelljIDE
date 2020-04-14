package com.lxk.book.controller;

import com.lxk.book.entitys.Journal_Info;
import com.lxk.book.entitys.Journal_had_catalog;
import com.lxk.book.entitys.Journal_len_return;
import com.lxk.book.entitys.Journal_reduce;
import com.lxk.book.entitys.Journal_subscribe;
import com.lxk.book.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/14 9:48
 */
@Controller
public class JournalController {
    private static final Logger LOG = Logger.getLogger(String.valueOf(LoginController.class));

    @Autowired
    private JournalService journalService;

    @RequestMapping(value = "Journal_Info")
    public ModelAndView Journal_Info(){
        LOG.info("Journal_Info");
        ArrayList<Journal_Info> journalInfos= journalService.journal_infos();
        ModelAndView modelAndView=new ModelAndView("journal_info");
        modelAndView.addObject("journalInfos",journalInfos);
        return modelAndView;
    }

    @RequestMapping(value = "Journal_had_catalog")
    public ModelAndView Journal_had_catalog(){
        LOG.info("Journal_had_catalog");
        ArrayList<Journal_had_catalog> Journal_had_catalog = journalService.Journal_had_catalog();
        ModelAndView modelAndView=new ModelAndView("journal_had_catalog");
        modelAndView.addObject("journal_catalog",Journal_had_catalog);
        return modelAndView;
    }

    @RequestMapping(value = "Journal_len_return")
    public ModelAndView Journal_len_return(){
        LOG.info("Journal_len_return");
        ArrayList<Journal_len_return> Journal_len_return = journalService.Journal_len_return();
        ModelAndView modelAndView=new ModelAndView("journal_len_return");
        modelAndView.addObject("journal_len_return",Journal_len_return);
        return modelAndView;
    }

    @RequestMapping(value = "Journal_subscribe")
    public ModelAndView Journal_subscribe(){
        LOG.info("Journal_subscribe");
        ArrayList<Journal_subscribe> Journal_subscribe = journalService.Journal_subscribe();
        ModelAndView modelAndView=new ModelAndView("journal_subscribe");
        modelAndView.addObject("journal_subscribe",Journal_subscribe);
        return modelAndView;
    }

    @RequestMapping(value = "Journal_reduce")
    public ModelAndView Journal_reduce(){
        LOG.info("Journal_reduce");
        ArrayList<Journal_reduce> Journal_reduce = journalService.Journal_reduce();
        ModelAndView modelAndView=new ModelAndView("journal_reduce");
        modelAndView.addObject("Journal_reduce",Journal_reduce);
        return modelAndView;
    }
}
