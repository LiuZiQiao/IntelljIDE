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

    // Journal_Info
    @RequestMapping(value = "Journal_Info")
    public ModelAndView Journal_Info(){
        LOG.info("Journal_Info");
        ArrayList<Journal_Info> journalInfos= journalService.journal_infos();
        ModelAndView modelAndView=new ModelAndView("journal_info");
        modelAndView.addObject("journalInfos",journalInfos);
        return modelAndView;
    }
    @RequestMapping(value = "/addJournal_Info.html")
    public String addJournal_Info(){
        return "Journal_info_add";
    }
    @RequestMapping(value = "addJournal_info")
    public ModelAndView addJournal_info(Journal_Info journal_info){
        System.out.println("journal_info--->"+journal_info);
        int ret = journalService.addJournal_info(journal_info);
        ModelAndView modelAndView = new ModelAndView("journal_info");
        if (ret>0){
            ArrayList<Journal_Info> journal_infos = journalService.journal_infos();
            modelAndView.addObject("journalInfos",journal_infos);
        }
        return modelAndView;
    }
    @RequestMapping("deleteJournal_info")
    public ModelAndView deleteJournal_info(String qkbh){
        int res = journalService.deleteJournal_info(qkbh);
        ModelAndView modelAndView = new ModelAndView("journal_info");
        if (res>0){
            ArrayList<Journal_Info> journal_infos = journalService.journal_infos();
            modelAndView.addObject("journalInfos",journal_infos);
        }
        return modelAndView;
    }
    @RequestMapping(value = "/editJournal_info.html")
    public ModelAndView updateJournal_info(String bookId){
        System.out.println("qkbh:"+bookId);
        Journal_Info journal_info = journalService.getJournal_info(bookId);
        System.out.println("journal_info--->"+journal_info);
        ModelAndView modelAndView = new ModelAndView("journal_info_edit");
        modelAndView.addObject("journalInfos",journal_info);
        return modelAndView;
    }
    @RequestMapping(value = "doupdateJouranl_info")
    public ModelAndView doupdateJouranl_info(Journal_Info journal_info){
        System.out.println("doupdateJournal_infp--->"+journal_info);
        int res = journalService.deleteJournal_info(journal_info.getQkbh());
        ModelAndView modelAndView = new ModelAndView("journal_info");
        if (res>0) {
            int ret = journalService.addJournal_info(journal_info);
            if (ret>0) {
                ArrayList<Journal_Info> journal_infos = journalService.journal_infos();
                modelAndView.addObject("journalInfos", journal_infos);
            }
        }
        return modelAndView;
    }

    //Journal_had_catalog
    @RequestMapping(value = "Journal_had_catalog")
    public ModelAndView Journal_had_catalog(){
        LOG.info("Journal_had_catalog");
        ArrayList<Journal_had_catalog> Journal_had_catalog = journalService.Journal_had_catalog();
        ModelAndView modelAndView=new ModelAndView("journal_had_catalog");
        modelAndView.addObject("journal_catalog",Journal_had_catalog);
        return modelAndView;
    }

    @RequestMapping(value = "/addJournal_had_catalog.html")
    public String addJournal_had_catalog(){
        return "Journal_had_add";
    }
    @RequestMapping(value = "addJournal_had_catalog")
    public ModelAndView addJournal_had_catalog(Journal_had_catalog journal_info){
        int ret = journalService.addJournal_had(journal_info);
        ModelAndView modelAndView = new ModelAndView("journal_had_catalog");
        if (ret>0){
            ArrayList<Journal_had_catalog> Journal_had_catalog = journalService.Journal_had_catalog();
            modelAndView.addObject("journal_catalog",Journal_had_catalog);
        }
        return modelAndView;
    }
    @RequestMapping("deleteJournal_had")
    public ModelAndView deleteJournal_had(String qkbh){
        int res = journalService.deleteJournal_had_catalog(qkbh);
        ModelAndView modelAndView = new ModelAndView("journal_had_catalog");
        if (res>0){
            ArrayList<Journal_had_catalog> Journal_had_catalog = journalService.Journal_had_catalog();
            modelAndView.addObject("journal_catalog",Journal_had_catalog);
        }
        return modelAndView;
    }
    @RequestMapping(value = "/editJournal_had.html")
    public ModelAndView updateJournal_had(String qkbh){
        Journal_had_catalog journal_info = journalService.getJournal_had_catalog(qkbh);
        ModelAndView modelAndView = new ModelAndView("journal_had_edit");
        modelAndView.addObject("journalInfos",journal_info);
        return modelAndView;
    }
    @RequestMapping(value = "doupdateJouranl_had")
    public ModelAndView doupdateJouranl_had(Journal_had_catalog journal_had_catalog){
        System.out.println("Journal_had_catalog--->"+journal_had_catalog);
        int res = journalService.deleteJournal_had_catalog(journal_had_catalog.getHdqk());
        ModelAndView modelAndView = new ModelAndView("journal_had_catalog");
        if (res>0){
            int ret = journalService.addJournal_had(journal_had_catalog);
            if (ret>0){
                ArrayList<Journal_had_catalog> Journal_had_catalogs = journalService.Journal_had_catalog();
                modelAndView.addObject("journal_catalog",Journal_had_catalogs);
            }
        }
        return modelAndView;
    }


//    Journal_len_return
    @RequestMapping(value = "Journal_len_return")
    public ModelAndView Journal_len_return(){
        LOG.info("Journal_len_return");
        ArrayList<Journal_len_return> Journal_len_return = journalService.Journal_len_return();
        ModelAndView modelAndView=new ModelAndView("journal_len_return");
        modelAndView.addObject("journal_len_return",Journal_len_return);
        return modelAndView;
    }

    @RequestMapping(value = "/addJournal_len_return.html")
    public String addJournal_len_return(){
        return "Journal_len_return_add";
    }
    @RequestMapping(value = "addJournal_len_return")
    public ModelAndView addJournal_len_return(Journal_len_return journal_len_return){
        int ret = journalService.addjournal_len(journal_len_return);
        ModelAndView modelAndView = new ModelAndView("journal_len_return");
        if (ret>0){
            ArrayList<Journal_len_return> journal_len_returns = journalService.Journal_len_return();
            modelAndView.addObject("journal_len_return",journal_len_returns);
        }
        return modelAndView;
    }
    @RequestMapping("deleteJournal_len_return")
    public ModelAndView deleteJournal_len_return(String qkbh){
        int res = journalService.deleteJournal_len(qkbh);
        ModelAndView modelAndView = new ModelAndView("journal_len_return");
        if (res>0){
            ArrayList<Journal_len_return> journal_len_returns = journalService.Journal_len_return();
            modelAndView.addObject("journal_len_return",journal_len_returns);
        }
        return modelAndView;
    }
    @RequestMapping(value = "/editJournal_len_return.html")
    public ModelAndView editJournal_len_return(String qkbh){
        Journal_len_return journal_len_return = journalService.getJournal_len(qkbh);
        System.out.println("doupdateJournal_infp--->"+journal_len_return);
        ModelAndView modelAndView = new ModelAndView("journal_len_return_edit");
        modelAndView.addObject("journal_len_return",journal_len_return);
        return modelAndView;
    }
    @RequestMapping(value = "doupdateJournal_len_return")
    public ModelAndView doupdateJournal_len_return(Journal_len_return journal_len_return){
        System.out.println("doupdateJournal_infp--->"+journal_len_return);
        int res = journalService.deleteJournal_len(journal_len_return.getJyrq());
        ModelAndView modelAndView = new ModelAndView("journal_len_return");
        if (res>0){
            int ret = journalService.addjournal_len(journal_len_return);
            if (ret>0){
                ArrayList<Journal_len_return> journal_len_returns = journalService.Journal_len_return();
                modelAndView.addObject("journal_len_return",journal_len_returns);
            }
        }
        return modelAndView;
    }

//    Journal_subscribe
    @RequestMapping(value = "Journal_subscribe")
    public ModelAndView Journal_subscribe(){
        LOG.info("Journal_subscribe");
        ArrayList<Journal_subscribe> Journal_subscribes = journalService.Journal_subscribe();
        ModelAndView modelAndView=new ModelAndView("journal_subscribe");
        modelAndView.addObject("journal_subscribe",Journal_subscribes);
        return modelAndView;
    }

    @RequestMapping(value = "/addJournal_subscribe.html")
    public String addJournal_subscribe(){
        return "journal_subscribe_add";
    }
    @RequestMapping(value = "addJournal_subscribe")
    public ModelAndView addJournal_subscribe(Journal_subscribe journal_subscribe){
        int ret = journalService.addjournal_subscribe(journal_subscribe);
        ModelAndView modelAndView = new ModelAndView("journal_subscribe");
        if (ret>0){
            ArrayList<Journal_subscribe> journal_len_returns = journalService.Journal_subscribe();
            modelAndView.addObject("journal_subscribe",journal_len_returns);
        }
        return modelAndView;
    }
    @RequestMapping("deleteJournal_subscribe")
    public ModelAndView deleteJournal_subscribe(String qkdgh){
        int res = journalService.deletejournal_subscribe(qkdgh);
        ModelAndView modelAndView = new ModelAndView("journal_subscribe");
        if (res>0){
            ArrayList<Journal_subscribe> journal_len_returns = journalService.Journal_subscribe();
            modelAndView.addObject("journal_subscribe",journal_len_returns);
        }
        return modelAndView;
    }
    @RequestMapping(value = "/editJournal_subscribe.html")
    public ModelAndView editJournal_subscribe(String qkdgh){
        Journal_subscribe journal_subscribe = journalService.getjournal_subscribe(qkdgh);
        System.out.println("doupdatejournal_subscribe--->"+journal_subscribe);
        ModelAndView modelAndView = new ModelAndView("journal_subscribe_edit");
        modelAndView.addObject("journal_subscribe",journal_subscribe);
        return modelAndView;
    }
    @RequestMapping(value = "doupdateJournal_subscribe")
    public ModelAndView doupdateJournal_subscribe(Journal_subscribe journal_subscribe){
        System.out.println("doupdateJournal_subscribe--->"+journal_subscribe);
        int res = journalService.deletejournal_subscribe(journal_subscribe.getQkdgh());
        ModelAndView modelAndView = new ModelAndView("journal_subscribe");
        if (res>0){
            int ret = journalService.addjournal_subscribe(journal_subscribe);
            if (ret>0){
                ArrayList<Journal_subscribe> journal_subscribes = journalService.Journal_subscribe();
                modelAndView.addObject("journal_subscribe",journal_subscribes);
            }
        }
        return modelAndView;
    }

//    Journal_reduce
    @RequestMapping(value = "Journal_reduce")
    public ModelAndView Journal_reduce(){
        LOG.info("Journal_reduce");
        ArrayList<Journal_reduce> Journal_reduce = journalService.Journal_reduce();
        ModelAndView modelAndView=new ModelAndView("journal_reduce");
        modelAndView.addObject("Journal_reduce",Journal_reduce);
        return modelAndView;
    }

    @RequestMapping(value = "/addJournal_reduce.html")
    public String addJournal_reduce(){
        return "journal_reduce_add";
    }
    @RequestMapping(value = "addJournal_reduce")
    public ModelAndView addJournal_reduce(Journal_reduce journal_reduce){
        int ret = journalService.addjournal_reduce(journal_reduce);
        ModelAndView modelAndView = new ModelAndView("journal_reduce");
        if (ret>0){
            ArrayList<Journal_reduce> journal_reduces = journalService.Journal_reduce();
            modelAndView.addObject("Journal_reduce",journal_reduces);
        }
        return modelAndView;
    }
    @RequestMapping("deleteJournal_reduce")
    public ModelAndView deleteJournal_reduce(String jsrq){
        int res = journalService.deletejournal_reduce(jsrq);
        ModelAndView modelAndView = new ModelAndView("journal_reduce");
        if (res>0){
            ArrayList<Journal_reduce> journal_reduces = journalService.Journal_reduce();
            modelAndView.addObject("Journal_reduce",journal_reduces);
        }
        return modelAndView;
    }
    @RequestMapping(value = "/editJournal_reduce.html")
    public ModelAndView editJournal_reduce(String jsrq){
        Journal_reduce journal_reduce = journalService.getjournal_reduce(jsrq);
        System.out.println("doupdatejournal_reduce--->"+journal_reduce);
        ModelAndView modelAndView = new ModelAndView("journal_reduce_edit");
        modelAndView.addObject("Journal_reduce",journal_reduce);
        return modelAndView;
    }
    @RequestMapping(value = "doupdateJournal_reduce")
    public ModelAndView doupdateJournal_reduce(Journal_reduce journal_reduce){
        System.out.println("doupdateJournal_reduce--->"+journal_reduce);
        int res = journalService.deletejournal_reduce(journal_reduce.getJsrq());
        ModelAndView modelAndView = new ModelAndView("journal_reduce");
        if (res>0){
            int ret = journalService.addjournal_reduce(journal_reduce);
            if (ret>0){
                ArrayList<Journal_reduce> journal_reduces = journalService.Journal_reduce();
                modelAndView.addObject("Journal_reduce",journal_reduces);
            }
        }
        return modelAndView;
    }
}
