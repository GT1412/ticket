package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

	@Entity
	public class User {

		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int id;
		String name;
		String username;
		String password;
		
		@OneToMany(cascade = CascadeType.ALL)
		List<Task> tasks;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

		public List<Task> getTasks() {
			return tasks;
		}

		public void setTasks(List<Task> tasks) {
			this.tasks = tasks;
		}

		public User(int id, String name, String username, String password, List<Task> tasks) {
			super();
			this.id = id;
			this.name = name;
			this.username = username;
			this.password = password;
			this.tasks = tasks;
		}

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", tasks="
					+ tasks + "]";
		}

}
