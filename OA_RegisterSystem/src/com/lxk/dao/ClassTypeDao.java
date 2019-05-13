package com.lxk.dao;

import java.util.List;

import com.lxk.domain.ClassType;

public interface ClassTypeDao {

	List<ClassType> findAll();

	void save(ClassType classType);

	ClassType findOne(String classTypeId);

}
