package com.lxk.crawler.autohome.service;

import com.lxk.crawler.autohome.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Override
    public String queryDate() {
       String date = this.testMapper.queryDate();
        return date;
    }
}
