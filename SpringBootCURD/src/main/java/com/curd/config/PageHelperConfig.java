package com.curd.config;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.dialect.helper.MySqlDialect;
import com.github.pagehelper.page.PageAutoDialect;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/9 22:42
 */
public class PageHelperConfig extends PageAutoDialect {

    static {
        System.out.println("加载了。。。。");
        registerDialectAlias("zenith", MySqlDialect.class);
    }
}
