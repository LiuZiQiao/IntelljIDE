package com.lxk.dao;

import java.util.List;

import com.lxk.domain.Customer;

public interface CustomerDao {

	void save(Customer customer);
	/**
	 * QBE：Query By Example
	 * 根据客户的属性字段进行查询。只要字段不是null，都作为查询条件.目前不支持模糊查询
	 * @param customer
	 * @return 
	 */
	List<Customer> find(Customer customer);
	/**
	 * 适合返回结果只有一条的情况，如果返回的结果又多条，调用该方法应抛出异常
	 * @param customer
	 * @return 一条记录，要么没有
	 */
	Customer uniqueResult(Customer customer);
	/**
	 * 根据邮箱和电话查询客户
	 * @param email
	 * @param phoneNumber
	 * @return 没有返回null
	 */
	Customer find(String email, String phoneNumber);
	void update(Customer customer);

}
