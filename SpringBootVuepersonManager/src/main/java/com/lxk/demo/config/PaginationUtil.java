package com.lxk.demo.config;

import com.lxk.demo.mapper.PersonsMapper;
import com.lxk.demo.model.PageInfo;
import com.lxk.demo.model.Persons;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class PaginationUtil{
    private PageInfo pageInfo = new PageInfo();

    private Map<String,PageInfo> results = new HashMap<>();
    public Map<String,PageInfo> filterQuery(String sex,String email,Pageable pageable){
        Types typeInstance;
        if(sex.length() == 0 && email.length() == 0){
            typeInstance = new AllType(sex,email,pageable);
        }else if(sex.length()>0 &&email.length()>0){
            typeInstance = new SexEmailType(sex,email,pageable);
        }else {
            typeInstance = new SexType(sex,email,pageable);
        }

        this.pageInfo.setCount(typeInstance.getCount());
        this.pageInfo.setPage(typeInstance.getPageNumber()+1);
        this.pageInfo.setResults(typeInstance.getContent());
        this.pageInfo.setTotal(typeInstance.getTotal());
        this.results.put("data",this.pageInfo);
        return results;
    }
}

class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext == null){
            SpringUtil.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static Object getBean(String name){
        return getApplicationContext().getType(name);
    }

    public static <T> T getBean(Class<T> c){
        return getApplicationContext().getBean(c);
    }

    public static <T> T getBean(String name,Class<T> c){
        return  getApplicationContext().getBean(name,c);
    }
}

class BasePaginationInfo{
    public Pageable pageable;

    public PersonsMapper instance = SpringUtil.getBean(PersonsMapper.class);

    public String sex,email;
    public BasePaginationInfo(String sexName,String emailName,Pageable pageable){
        this.email = emailName;
        this.sex = sexName;
        this.pageable = pageable;
    }
}

interface Types{

    public Page<Persons> query();
    public Integer getCount();
    public Integer getPageNumber();
    public  Long getTotal();
    public Object getContent();
}

class AllType extends BasePaginationInfo implements Types{

    public AllType(String sexName,String emailName,Pageable pageable){
        super(sexName,emailName,pageable);
    }

    @Override
    public Page<Persons> query() {
        return this.instance.findAll(this.pageable);
    }

    @Override
    public Integer getCount() {
        return this.query().getSize();
    }

    @Override
    public Integer getPageNumber() {
        return this.query().getNumber();
    }

    @Override
    public Long getTotal() {
        return this.query().getTotalElements();
    }

    @Override
    public Object getContent() {
        return this.query().getContent();
    }
}

class SexEmailType extends BasePaginationInfo implements Types{

    public SexEmailType(String sexName, String emailName, Pageable pageable) {
        super(sexName, emailName, pageable);
    }

    @Override
    public Page<Persons> query() {
        return this.instance.findBySexAndEmailContains(this.sex,this.email,this.pageable);
    }

    @Override
    public Integer getCount() {
        return this.query().getSize();
    }

    @Override
    public Integer getPageNumber() {
        return this.query().getNumber();
    }

    @Override
    public Long getTotal() {
        return this.query().getTotalElements();
    }

    @Override
    public Object getContent() {
        return this.query().getContent();
    }
}

class SexType extends BasePaginationInfo implements Types{

    public SexType(String sexName, String emailName, Pageable pageable) {
        super(sexName, emailName, pageable);
    }

    @Override
    public Page<Persons> query() {
        return this.instance.findBySex(this.sex,this.pageable);
    }

    @Override
    public Integer getCount() {
        return this.query().getSize();
    }

    @Override
    public Integer getPageNumber() {
        return this.query().getNumber();
    }

    @Override
    public Long getTotal() {
        return this.query().getTotalElements();
    }

    @Override
    public Object getContent() {
        return this.query().getContent();
    }
}
