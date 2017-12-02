package com.atai.dental.generic.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


public interface Service<T> {

	public void addData(T p);
	public void updateData(T p);
	public List<T> listData();
	public List<T> executeSelectQuery(T p);
	public T getByObjid(String objid);
}
