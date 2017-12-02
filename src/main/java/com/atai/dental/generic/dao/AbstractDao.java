package com.atai.dental.generic.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;


public class AbstractDao<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
	    
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }
 
    public void persist(Object entity){
    	Method method;
    	try{
	    	method = entity.getClass().getMethod("setObjid", String.class);
	    	method.invoke(entity, entity.toString());
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
        getSession().save(entity);
    }
 
    public void update(T entity) {
		getSession().update(entity);

	}
    
    public void delete(PK key) {
    	T obj = getSession().load(persistentClass, key);
		if (obj != null)
		{
			getSession().delete(obj);
		}
    }
    
    public List<T> list() {
		List<T> objects = getSession().createQuery("from "+persistentClass.getName()+"").list();
		return objects;
	}
        
    public T getByObjid(String objid) {
		List<T> objectList = getSession().createQuery("from "+persistentClass.getName()+" where objid = '" + objid+"'").list();
		T object = objectList.get(0);
		
		return object;
	}
       
	protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }

	// Following code section is for search queries
	public List<T> executeSelectQuery(T entity)
	{
		Criteria criteria = getSession().createCriteria(persistentClass, "mainquery");
		createCriteria(entity, criteria, null);
		List<T> results = criteria.list();
		return results;
	}
	
	private void createCriteria(Object entity, Criteria criteria, String alias)
	{
		Field[] fields = entity.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				if (field.getName()!="objid")
					setValue(entity, criteria, field, alias);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
		}
	}
	
	private void setValue(Object entity, Criteria criteria, Field field, String alias) throws Exception
	{
		String fieldName;
		String fieldValue;
		field.setAccessible(true);
		Method method;
		Date date;
		char[] fieldNameArray;
		
		if (!checkIfNull(entity, field))
		{ 
			Class<?> c = field.getType();
			
			if(c.isPrimitive() || (c.getTypeName() == "java.lang.String") || (c.getTypeName() == "java.math.BigDecimal") || (c.getTypeName() == "java.util.Date")|| (c.getTypeName() == "java.lang.Integer") || (c.getTypeName() == "java.lang.Double"))
			{
				fieldName = field.getName();
				fieldValue = field.get(entity).toString();
				System.out.println("field value is ----------------------"+fieldValue);
				//if(fieldValue.contains("%"))
				if(!fieldValue.contains("data:image"))
				{
					if(c.getTypeName() == "java.lang.String")
					{
						if (alias == null)
						{
							criteria.add(Restrictions.ilike(fieldName, "%"+field.get(entity).toString()+"%"));
						}
						else
						{
							criteria.add(Restrictions.ilike(alias + "."+fieldName, "%"+field.get(entity)+"%"));
						}
					}
					else
					{
						if (c.getTypeName() == "java.util.Date")
						{
							date = (Date)field.get(entity);
							if (alias == null)
							{							
								criteria.add(Restrictions.eq(fieldName, new Date(date.getYear(), date.getMonth(), date.getDate())));
							}
							else
							{
								criteria.add(Restrictions.eq(alias + "."+fieldName, new Date(date.getYear(), date.getMonth(), date.getDate())));
							}
						}
						else
						{
							if (alias == null)
							{
								criteria.add(Restrictions.eq(fieldName, field.get(entity)));
							}
							else
							{
								criteria.add(Restrictions.eq(alias + "."+fieldName, field.get(entity)));
							}
						}
						
					}
				}
			}
			else
			{
				fieldName = field.getName();
				fieldNameArray = field.getName().toCharArray();
				fieldNameArray[0] = Character.toUpperCase(fieldNameArray[0]);
				method = entity.getClass().getMethod("get"+(new String(fieldNameArray)));
				createCriteria(method.invoke(entity), criteria, fieldName);
			}
		}
		
	}
	
	private boolean checkIfNull(Object entity, Field field) throws Exception
	{
		if (field.getType().equals(Integer.TYPE))
		{
			if (field.getInt(entity) != 0)
				return false;
		}
		else if (field.getType().equals(String.class))
		{
			if ((field.get(entity) !=null) && (field.get(entity) != ""))
				return false;
		}
		else if (field.getType().equals(Byte.TYPE))
		{
			if(field.getByte(entity) != 0)
				return false;
		}
		else if(field.getType().equals(Short.TYPE))
		{
			if (field.getShort(entity)!= 0)
				return false;
		}
		else if(field.getType().equals(Long.TYPE))
		{
			if (field.getLong(entity)!= 0L)
				return false;
		}
		else if(field.getType().equals(Float.TYPE))
		{
			if(field.getFloat(entity)!= 0.0F)
				return false;
		}
		else if(field.getType().equals(Double.TYPE))
		{
			if(field.getDouble(entity)!=0.0d)
				return false;
		}
		else if (field.getType().equals(Character.TYPE))
		{
			if(field.getChar(entity)!='\u0000')
				return false;
		}
		else
		{
			if (field.get(entity) != null)
			{
				return false;
			}
		}
		return true;
	}
}
