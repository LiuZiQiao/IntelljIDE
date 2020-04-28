package com.lxk.book.service;

import com.lxk.book.dao.JournalDao;
import com.lxk.book.entitys.Journal_Info;
import com.lxk.book.entitys.Journal_had_catalog;
import com.lxk.book.entitys.Journal_len_return;
import com.lxk.book.entitys.Journal_reduce;
import com.lxk.book.entitys.Journal_subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/14 9:43
 */

@Service
public class JournalService {

    @Autowired
    private JournalDao journalDao;

    public ArrayList<Journal_Info> journal_infos(){
        return journalDao.journal_infos();
    }

    public ArrayList<Journal_had_catalog> Journal_had_catalog(){
        return journalDao.journal_had_catalog();
    }

    public ArrayList<Journal_len_return> Journal_len_return(){
        return journalDao.journal_len_return();
    }

    public ArrayList<Journal_subscribe> Journal_subscribe(){
        return journalDao.journal_subscribe();
    }

    public ArrayList<Journal_reduce> Journal_reduce(){
        return journalDao.journal_reduce();
    }

    //info
    public Journal_Info getJournal_info(String qkbh){
        return journalDao.getJournal_Info(qkbh);
    }
    public int deleteJournal_info(String qkbh){
        return journalDao.deleteJournal_info(qkbh);
    }
    public int addJournal_info(Journal_Info journal_info){
        return journalDao.addjournal_info(journal_info);
    }

    //catalog
    public Journal_had_catalog getJournal_had_catalog(String qkbh){
        return journalDao.getjournal_had(qkbh);
    }
    public int deleteJournal_had_catalog(String qkbh){
        return journalDao.deletejournal_had(qkbh);
    }
    public int addJournal_had(Journal_had_catalog journal_info){
        return journalDao.addjournal_had(journal_info);
    }

    //reduce
    public Journal_reduce getjournal_reduce(String qkbh){
        return journalDao.getjournal_reduce(qkbh);
    }
    public int deletejournal_reduce(String qkbh){
        return journalDao.deletejournal_reduce(qkbh);
    }
    public int addjournal_reduce(Journal_reduce journal_info){
        return journalDao.addjournal_reduce(journal_info);
    }

    //Journal_subscribe
    public Journal_subscribe getjournal_subscribe(String qkbh){
        return journalDao.getjournal_subscribe(qkbh);
    }
    public int deletejournal_subscribe(String qkbh){
        return journalDao.deletejournal_subscribe(qkbh);
    }
    public int addjournal_subscribe(Journal_subscribe journal_info){
        return journalDao.addjournal_subscribe(journal_info);
    }

    //Journal_len_return
    public Journal_len_return getJournal_len(String qkbh){
        return journalDao.getJournal_len(qkbh);
    }
    public int deleteJournal_len(String qkbh){
        return journalDao.deleteJournal_len(qkbh);
    }
    public int addjournal_len(Journal_len_return journal_info){
        return journalDao.addjournal_len(journal_info);
    }
}
