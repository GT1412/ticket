package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


// table create using entity

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String username;
	String password;
	
	@OneToMany (cascade = CascadeType.ALL)
	List<Task> task;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + ", task=" + task + "]";
	}

	public Admin(int id, String username, String password, List<Task> task) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.task = task;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
