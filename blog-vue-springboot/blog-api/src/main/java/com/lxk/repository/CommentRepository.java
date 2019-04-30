package com.lxk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lxk.entity.Article;
import com.lxk.entity.Comment;

/**
 * @author lxk
 * <p>
 * 2018年1月25日
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByArticleAndLevelOrderByCreateDateDesc(Article a, String level);


}
