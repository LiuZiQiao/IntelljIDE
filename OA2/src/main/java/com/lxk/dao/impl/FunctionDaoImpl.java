package com.lxk.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lxk.dao.FunctionDao;
import com.lxk.domain.Function;
import com.lxk.exception.DaoException;
import com.lxk.util.C3P0Util;

public class FunctionDaoImpl implements FunctionDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	public List<Function> findAll() {
		try {
			return qr.query("select * from functions", new BeanListHandler<Function>(Function.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void save(Function function) {
		try {
			qr.update("insert into functions (name,uri) values (?,?)", function.getName(),function.getUri());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
