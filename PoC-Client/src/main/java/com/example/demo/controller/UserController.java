package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping(value = "/createuser", produces = { "application/json", "application/xml" }, consumes = {
			"application/xml", "application/json" })
	public User save(@RequestBody User user) {
		User save = service.save(user);
		return save;

	}

}
