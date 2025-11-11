package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.apis.UserRestApi;
import com.coderhouse.interfaces.CrudRestInterface;
import com.coderhouse.models.User;

@Service
public class UserService implements CrudRestInterface<User, String> {

	@Autowired
	private UserRestApi api;
	
	@Override
	public List<User> getAll() {
		return api.getAll();
	}

	@Override
	public User getById(String id) {
		return api.getById(id);
	}

	@Override
	public User create(User user) {
		return api.create(user);
	}

	@Override
	public User update(User user) {
		return api.update(user);
	}

	@Override
	public void delete(String id) {
		api.delete(id);
	}

}
