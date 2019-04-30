package com.lxk.repository.wrapper;

import com.lxk.entity.Article;
import com.lxk.vo.ArticleVo;
import com.lxk.vo.PageVo;

import java.util.List;

public interface ArticleWrapper {
    List<Article> listArticles(PageVo page);

    List<Article> listArticles(ArticleVo article, PageVo page);

    List<ArticleVo> listArchives();

}
