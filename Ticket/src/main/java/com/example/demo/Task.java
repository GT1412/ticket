package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


	@Entity
	public class Task {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int id;
		
		int empid;
		String empname;
		String empmob;
		String empmail;
		String category;
		String issue;
		int priority;
		String status;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getEmpid() {
			return empid;
		}
		public void setEmpid(int empid) {
			this.empid = empid;
		}
		public String getEmpname() {
			return empname;
		}
		public void setEmpname(String empname) {
			this.empname = empname;
		}
		public String getEmpmob() {
			return empmob;
		}
		public void setEmpmob(String empmob) {
			this.empmob = empmob;
		}
		public String getEmpmail() {
			return empmail;
		}
		public void setEmpmail(String empmail) {
			this.empmail = empmail;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getIssue() {
			return issue;
		}
		public void setIssue(String issue) {
			this.issue = issue;
		}
		public int getPriority() {
			return priority;
		}
		public void setPriority(int priority) {
			this.priority = priority;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "Task [id=" + id + ", empid=" + empid + ", empname=" + empname + ", empmob=" + empmob + ", empmail="
					+ empmail + ", category=" + category + ", issue=" + issue + ", priority=" + priority + ", status="
					+ status + "]";
		}
		public Task(int id, int empid, String empname, String empmob, String empmail, String category, String issue,
				int priority, String status) {
			super();
			this.id = id;
			this.empid = empid;
			this.empname = empname;
			this.empmob = empmob;
			this.empmail = empmail;
			this.category = category;
			this.issue = issue;
			this.priority = priority;
			this.status = status;
		}
		public Task() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	}


