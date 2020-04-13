package com.lxk.test;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test02 {
    @Test
    public void test()
    {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql:///spring");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("123546");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(basicDataSource);
        jdbcTemplate.update("insert into user(userName,password) value (?,?)","zhangsan","123456");
    }
}
