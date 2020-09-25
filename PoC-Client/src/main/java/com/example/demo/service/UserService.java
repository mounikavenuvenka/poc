package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.User;
import com.example.demo.repo.IUserRepository;

@Component
public class UserService {
	@Autowired
	private IUserRepository repo;

	public User getUser(@PathVariable("id") Integer id) {
		return repo.getOne(id);
	}

	public User save(@RequestBody User user) {
		return repo.save(user);
	}

}
