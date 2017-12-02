package com.atai.dental.generic.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.atai.dental.generic.dao.AbstractDao;

public class AbstractService <PK extends Serializable, T>{
	
	AbstractDao<PK, T> dao;
	
	public AbstractService(AbstractDao<PK, T> dao)
	{
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
    public T getByKey(PK key) 
    {
        return dao.getByKey(key);
    }
 
	@Transactional
    public void persist(T entity) 
    {
       dao.persist(entity);
    }
 
	@Transactional
    public void update(T entity)
    {
		dao.update(entity);
    }
    
	@Transactional
    public void delete(PK key) 
    {
    	dao.delete(key);
    }
     
	@Transactional(readOnly = true)
    public List<T> list() 
    {
		return dao.list();
	}
    
    @Transactional(readOnly = true)
    public T getByObjid(String objid) 
    {
		return dao.getByObjid(objid);
	}
    
    @Transactional(readOnly = true)
    public List<T> executeSelectQuery(T entity)
	{
		return dao.executeSelectQuery(entity);
	}
}
