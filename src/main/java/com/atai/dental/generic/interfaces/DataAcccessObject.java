package com.atai.dental.generic.interfaces;

import java.util.List;


public interface DataAcccessObject<T> {

	public void addData(T p);
	public void updateData(T p);
	public List<T> listData();
	public List<T> executeSelectQuery(T p);
	public T getByObjid(String objid);
} 

