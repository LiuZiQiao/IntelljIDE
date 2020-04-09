package com.lxk.dao;

import java.util.List;

import com.lxk.domain.Function;

public interface FunctionDao {

	List<Function> findAll();

	void save(Function function);

}
