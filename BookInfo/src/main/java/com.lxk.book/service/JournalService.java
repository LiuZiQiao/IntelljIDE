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
}
