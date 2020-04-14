package com.lxk.book.dao;

import com.lxk.book.entitys.Journal_Info;
import com.lxk.book.entitys.Journal_had_catalog;
import com.lxk.book.entitys.Journal_len_return;
import com.lxk.book.entitys.Journal_reduce;
import com.lxk.book.entitys.Journal_subscribe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/13 23:42
 */

@Mapper
public interface JournalDao {

    @Select("select *from Journal_Info")
    public  ArrayList<Journal_Info> journal_infos();

    @Select("select *from Journal_had_catalog")
    public ArrayList<Journal_had_catalog> journal_had_catalog();

    @Select("select *from Journal_len_return")
    public ArrayList<Journal_len_return> journal_len_return();

    @Select("select *from Journal_subscribe")
    public ArrayList<Journal_subscribe> journal_subscribe();

    @Select("select *from Journal_reduce")
    public ArrayList<Journal_reduce> journal_reduce();
}
