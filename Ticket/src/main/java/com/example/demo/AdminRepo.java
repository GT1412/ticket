package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

//JPA repo is used to managing the data 

public interface AdminRepo extends JpaRepository<Admin, Integer> {

	 int countByUsername(String username);
	 Admin findByUsername(String username);
}
