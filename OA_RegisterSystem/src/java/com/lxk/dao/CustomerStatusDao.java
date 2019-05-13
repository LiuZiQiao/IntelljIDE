package com.lxk.dao;

import java.util.List;

import com.lxk.domain.CustomerStatus;

public interface CustomerStatusDao {

	List<CustomerStatus> findAll();

	CustomerStatus findOne(String customerStatusId);

	void save(CustomerStatus customerStatus);

}
