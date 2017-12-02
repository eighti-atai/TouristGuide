package com.atai.dental.generic.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

public interface Controller<T> {

	@GetMapping(value = "/objects")
	public ModelAndView init(Model model);
	
	@GetMapping(value = "/Object")
	public ResponseEntity<List<T>> list();
	
	@PostMapping(value = "/Object")
	public ResponseEntity<Void> add(@RequestBody T object);
	
	@PutMapping(value = "/Object")
	ResponseEntity<T> modify(@RequestBody T newObject);
	
	@DeleteMapping(value = "/Object/{objid:.+}")
	public ResponseEntity<T> delete(@PathVariable("objid") String objid);
	
	@PostMapping(value = "/Object/Search")
	ResponseEntity<List<T>> search(@RequestBody T object);
}
