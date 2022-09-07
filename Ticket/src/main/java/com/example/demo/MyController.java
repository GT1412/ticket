package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@Autowired
	UserRepo userrepo;
	@Autowired
	TaskRepo taskrepo;
	
	@Autowired
	AdminRepo ar;
	
	@RequestMapping("/")
	public String hii()
	{
		
		return "home.jsp";
	}
@RequestMapping("delete{taskid}")
	
	public String delete(@PathVariable int taskid,Model model,HttpSession session)
	{
		if(session.getAttribute("id")==null)
		{
			return "dashboard.jsp";
		}
		int userid=(Integer)session.getAttribute("id");
		
		
		User user = userrepo.findById(userid).get();
		List<Task> tasks = user.getTasks();
		System.out.println("size"+tasks.size());
		
		for (int i = 0; i < tasks.size();i++)
		{
			if(tasks.get(i).getId()==taskid)
			{
				tasks.remove(taskid);
				break;
			}
		}
		userrepo.save(user);
		
		model.addAttribute("user", user);
		return "dashboard.jsp";
	
	}
	
	@RequestMapping("login")
	public String login(@PathParam("username") String username,@PathParam("password") String password,Model model,HttpSession session)
	{
		if(userrepo.countByUsername(username)==0)
		{
			model.addAttribute("msg", "no user with this username");
			return "errorpage.jsp";
		}
		if(userrepo.countByUsername(username)>1)
		{
			model.addAttribute("msg", "multiple user with this username");
			return "errorpage.jsp";
		}
		User user = userrepo.findByUsername(username);
		if(!user.getPassword().equals(password))
		{
			model.addAttribute("msg", "Wrong password");
			return "errorpage.jsp";
		}
		session.setAttribute("id", user.id);
		model.addAttribute("user", user);
		if(taskrepo.countById(user.id)==0)
		return "generateticket.jsp";
		else
			return "dashboard.jsp";
	}
	

	
	
	

	
	@RequestMapping("add{userid}")
	public String addTicket(@PathParam ("empid")int empid,@PathParam ("empname")String empname,@PathParam ("MobNo")String MobNo,@PathParam ("Email")String Email, @PathParam ("Category")String Category,@PathParam ("issue")String issue, @PathParam ("priority") int priority,@PathParam ("status")String status,Model model)
	{
		//User user=userrepo.findById(empId).get();
		Task task =new Task(0, empid, empname, MobNo, Email,Category , issue, priority, "Newly Added");
	
		User user=userrepo.findById(empid).get();
		user.getTasks().add(task);
		
		user=userrepo.save(user);
	   
		Admin admin=ar.findById(empid).get();
		admin.getTask().add(task);
		admin=ar.save(admin);
		
		
		model.addAttribute("user", user);
		System.out.println(task);
		return "dashboard.jsp";
		
	
	}
	
	
	@RequestMapping("register")
	public String register(@PathParam("name") String name,@PathParam("username") String username,@PathParam("password") String password,Model model)
	{
		if(userrepo.countByUsername(username)==0 && username!=null && password!=null)
			{
			User user =new User(0,name,username,password,null);
			user.setName(name);
			user.setUsername(username);
			user.setPassword(password);
			user=userrepo.save(user);
			return "home.jsp";
			}
		else
		{
		model.addAttribute("msg", "already login this user");
		return "errorpage.jsp";
		
		}
		
	}
	
	@RequestMapping("logout")
	public String logout()
	{
		return "home.jsp";
	}
	
}
