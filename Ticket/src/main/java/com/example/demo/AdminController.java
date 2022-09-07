package com.example.demo;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//request mapping and get mapping we can write the bussiness logics in controller

@Controller
public class AdminController {
	
 @Autowired
 AdminRepo ar;
 
 @Autowired
 TaskRepo tr;
 
 @Autowired
 UserRepo ur;
	
	
	@RequestMapping("adminhome")
	public String adminhome()
	{
		return "adminhome.jsp";
	}
	
	
	
	@RequestMapping("adminlogin")
	public String login(@PathParam ("username") String username, @PathParam("password") String password, Model model,HttpSession session)
	{
		try {
			
		
		if(ar.countByUsername(username)==0)
		{
			model.addAttribute("msg", "no user with this username");
			return "error.jsp";
		}
		if(ar.countByUsername(username)>1)
		{
			model.addAttribute("msg", "multiple user with this username");
			return "error.jsp";
		}
		Admin admin = ar.findByUsername(username);
		if(!admin.getPassword().equals(password))
		{
			model.addAttribute("msg", "Wrong password");
			return "error.jsp";
		}
		session.setAttribute("id", admin.id);
		model.addAttribute("admin", admin);
		System.out.println(admin);
		return "admindashboard.jsp";
		}
		
		
		catch (Exception e) {
			System.out.println("no");
			return "error.jsp";
		}
	}
	
	
	
	@RequestMapping("adminregister")
	public String register(@PathParam("username") String username,@PathParam("password") String password,Model model)
	{
		if(ar.countByUsername(username)==0 && username!=null && password!=null)
			{
			Admin admin =new Admin(0, username, password, null);
		
			admin.setUsername(username);
			admin.setPassword(password);
			admin=ar.save(admin);
			return "adminhome.jsp";
			}
		else
		{
		model.addAttribute("msg", "already login this user");
		return "error.jsp";
		
		}
		
	}
	
	
	
	@RequestMapping("Status{userId}and{taskId}and{status}")
	public String status(@PathVariable int userId,@PathVariable int taskId,@PathVariable String status,Model model) {
		User user=ur.findById(userId).get();
		Admin admin=ar.findById(userId).get();
		Task task=tr.findById(taskId).get();
		task.setStatus(status);
		tr.save(task);
		ar.save(admin);
		ur.save(user);
		
		
//	  Task task=taskRepo.findById(taskId).get();
//		 task.setStatus(status);
//		taskRepo.save(task);
		//userRepo.save(user);
		model.addAttribute("admin", admin);
		return "admindashboard.jsp";
	}
}
