package com.coderhouse.interfaces;

import java.util.List;

public interface CrudRestInterface <T, ID>{
	
	List<T> getAll();
	
	T getById(ID id);
	
	T create(T entity);
	
	T update(T entity);
	
	void delete(ID id);
	
}
