package com.lxk.book.dao;

import com.lxk.book.entitys.Journal_Info;
import com.lxk.book.entitys.Journal_had_catalog;
import com.lxk.book.entitys.Journal_len_return;
import com.lxk.book.entitys.Journal_reduce;
import com.lxk.book.entitys.Journal_subscribe;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    //journal info
//    Journal_Info(qkbh=1002, qktxm=1002, qkzwmc=1003, qkywmc=1004, cbh=1005, bjb=1006, zb=1007, dj=1008,
//    ckny=1009, qh=1010, zqh=1011, flh=1012, zgyzm=1013, yzm=1014, qklbm=1015, qkztm=1)
//    @Insert("insert into journal_info value(#{qkbh},#{qktxm},#{qkzwmc},#{qkywmc},#{cbh},#{bjb},#{zb},#{dj}" +
//            "#{ckny},#{qh},#{zqh},#{flh},#{zgyzm},#{yzm},#{qklbm},#{qkztm})")
    @Insert("insert into journal_info value(#{qkbh},#{qktxm},#{qkzwmc},#{qkywmc},#{cbh},#{bjb},#{zb}," +
            "#{dj},#{ckny},#{qh},#{zqh},#{flh},#{zgyzm},#{yzm},#{qklbm},#{qkztm})")
    public int addjournal_info(Journal_Info journal_info);
    @Select("select *from journal_info where qkbh=#{qkbh}")
    public Journal_Info getJournal_Info(String qkbh);
    @Delete("delete from journal_info where qkbh=#{qkbh}")
    public int deleteJournal_info(String qkbh);

    //journal_len_return
    @Insert("insert into journal_len_return value(#{jyrq},#{jyr},#{ghrq},#{bz})")
    public int addjournal_len(Journal_len_return journal_len_return);
    @Select("select *from journal_len_return where jyrq=#{jyrq}")
    public Journal_len_return getJournal_len(String jyrq);
    @Delete("delete from journal_len_return where jyrq=#{jyrq}")
    public int deleteJournal_len(String jyrq);

    //journal_reduce
    @Insert("insert into journal_reduce value(#{jsrq},#{jsyy},#{jsjg},#{jsrzgh})")
    public int addjournal_reduce(Journal_reduce journal_reduce);
    @Select("select *from journal_reduce where jsrq=#{jsrq}")
    public Journal_reduce getjournal_reduce(String jsrq);
    @Delete("delete from journal_reduce where jsrq=#{jsrq}")
    public int deletejournal_reduce(String jsrq);

    //journal_subscribe
    @Insert("insert into journal_subscribe value(#{qkdgh},#{ydjg},#{ydcs},#{ydnd},#{hdfsm},#{zdrzgh},#{bz})")
    public int addjournal_subscribe(Journal_subscribe journal_subscribe);
    @Select("select *from journal_subscribe where qkdgh=#{qkdgh}")
    public Journal_subscribe getjournal_subscribe(String qkdgh);
    @Delete("delete from journal_subscribe where qkdgh=#{qkdgh}")
    public int deletejournal_subscribe(String qkdgh);

    //journal_had_catalog
    @Insert("insert into journal_had_catalog value(#{hdqk},#{bmrq},#{gcd})")
    public int addjournal_had(Journal_had_catalog journal_had_catalog);
    @Select("select *from journal_had_catalog where hdqk=#{hdqk}")
    public Journal_had_catalog getjournal_had(String hdqk);
    @Delete("delete from journal_had_catalog where hdqk=#{hdqk}")
    public int deletejournal_had(String hdqk);
}
