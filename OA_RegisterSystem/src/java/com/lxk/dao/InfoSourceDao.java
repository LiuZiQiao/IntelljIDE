package com.lxk.dao;

import java.util.List;

import com.lxk.domain.InfoSource;

public interface InfoSourceDao {

	List<InfoSource> findAll();

	void save(InfoSource infoSource);

	InfoSource findOne(String infoSourceId);

	void update(InfoSource infoSource);

	void delete(String...infoSourceId);

}
