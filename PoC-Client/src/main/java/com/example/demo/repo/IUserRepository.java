package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	
}