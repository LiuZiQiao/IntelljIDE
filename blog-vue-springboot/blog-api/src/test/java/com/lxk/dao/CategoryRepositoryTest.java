package com.lxk.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lxk.BlogApiApplicationTests;
import com.lxk.repository.CategoryRepository;

public class CategoryRepositoryTest extends BlogApiApplicationTests{

	@Autowired
	private CategoryRepository	categoryRepository;

	@Test
	public void test() {
	}
}
