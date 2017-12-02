package com.atai.dental.generic.controller;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.atai.dental.generic.service.AbstractService;

public class AbstractController<PK extends Serializable, T>{

	public AbstractService<PK, T> service;
	private final Class<T> persistentClass;
	private String baseUrl;
	private Class<PK> keyClass;
	
	public AbstractController(AbstractService<PK,T> service, Class<PK> keyClass, String baseUrl)
	{
		this.service = service;
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		this.baseUrl = baseUrl;
		this.keyClass = keyClass;
		
	}
	
	public ModelAndView init(Model model)
	{
		return new ModelAndView(baseUrl);
	}
	
	public ResponseEntity<List<T>> list()
	{
		List<T> objects = this.service.list();
		return new ResponseEntity<List<T>>(objects, HttpStatus.OK);
	}
	
	@PostMapping(value = "/Object")
	public ResponseEntity<T> add(@RequestBody T object){
		
		System.out.println(persistentClass.getSimpleName() +" object will be added");
		this.service.persist(object);
		return new ResponseEntity<T>(object,HttpStatus.CREATED);
	}
	
	public ResponseEntity<T> modify(T newObject)
	{
		try{
			Method method = newObject.getClass().getMethod("getObjid");
	    	String objid = method.invoke(newObject).toString();
			T oldObject = service.getByObjid(objid);
			method = newObject.getClass().getMethod("setId", keyClass);
			method.invoke(newObject, oldObject.getClass().getMethod("getId").invoke(oldObject));
		}
		catch(NoSuchMethodException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.update(newObject);
		return new ResponseEntity<T>(newObject, HttpStatus.OK);
	}
	
	public ResponseEntity<T> delete(String objid) {
        System.out.println("Fetching & Deleting "+persistentClass.getSimpleName()+" with id " + objid);
  
        T object = service.getByObjid(objid);
        if (object == null) {
            System.out.println("Unable to delete. "+persistentClass.getSimpleName()+" with id " + objid + " not found");
            return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
        }
        
        try {
			service.delete((PK)object.getClass().getMethod("getId").invoke(object));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new ResponseEntity<T>(HttpStatus.NO_CONTENT);
    }
	
	public ResponseEntity<List<T>> search(T object)
	{
		List<T> objects = this.service.executeSelectQuery(object);
		return new ResponseEntity<List<T>>(objects, HttpStatus.OK);
	}
	
	public ResponseEntity<T> getByKeys(T object)
	{
		T objects = null;
		try {
			objects = this.service.getByKey((PK)object.getClass().getMethod("getId").invoke(object));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<T>(objects, HttpStatus.OK);
	}
	
	public ResponseEntity<T> validate(@RequestBody T object,Model model){
		
		try{
			System.out.println(model.toString()+" object will be added");
			/*Method method = newObject.getClass().getMethod("getObjid");
	    	String objid = method.invoke(newObject).toString();
			T oldObject = service.getByObjid(objid);
			method = newObject.getClass().getMethod("setId", keyClass);
			method.invoke(newObject, oldObject.getClass().getMethod("getId").invoke(oldObject));*/
		}
		/*catch(NoSuchMethodException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return new ResponseEntity<T>(object, HttpStatus.OK);
	}
}
