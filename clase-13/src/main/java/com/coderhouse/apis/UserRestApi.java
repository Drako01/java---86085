package com.coderhouse.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.coderhouse.interfaces.CrudRestInterface;
import com.coderhouse.models.User;

@Component
public class UserRestApi implements CrudRestInterface<User, String> {

	private final String BASE_URL = "https://6913143d52a60f10c823ee09.mockapi.io/users";

	private final String errorMessage = "Error, No se puede obtener datos del Servidor ";

	@Autowired
	private RestTemplate rt;

	@Override
	public List<User> getAll() {
		try {
			@SuppressWarnings("unchecked")
			List<User> users = rt.exchange(BASE_URL, HttpMethod.GET, null, List.class).getBody();
			return users;
		} catch (HttpClientErrorException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(errorMessage + e.getMessage());
		}
	}

	@Override
	public User getById(String id) {
		try {
			String url = BASE_URL + '/' + id;
			return rt.getForObject(url, User.class);
		} catch (HttpClientErrorException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(errorMessage + e.getMessage());
		}

	}

	@Override
	public User create(User user) {
		try {
			return rt.postForObject(BASE_URL, user, User.class);
		} catch (HttpClientErrorException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(errorMessage + e.getMessage());
		}
	}

	@Override
	public User update(User user) {
		try {
			String url = BASE_URL + '/' + user.getId();
			rt.put(url, user);
			return user;
		} catch (HttpClientErrorException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(errorMessage + e.getMessage());
		}
	}

	@Override
	public void delete(String id) {
		try {
			String url = BASE_URL + '/' + id;
			rt.delete(url);
		} catch (HttpClientErrorException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(errorMessage + e.getMessage());
		}

	}

}
