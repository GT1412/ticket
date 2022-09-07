package com.example.demo;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>{

	 int countByUsername(String username);
	 User findByUsername(String username);
}
