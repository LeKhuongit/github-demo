package com.ps21510.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps21510.dao.CategoryDAO;
import com.ps21510.entity.Category;

@Controller
@RequestMapping("/user/")
public class UserController {
	@RequestMapping("login")
	public String login() {
		return "user/login";
	}
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(ModelMap model, 
			@RequestParam("id") String id,
			@RequestParam("password") String password,
			HttpSession session) {
		if(id.equals("fpt") && password.equals("poly")){
			session.setAttribute("user", id);
			model.addAttribute("message", "Đăng nhập thành công !");
			return "redirect:/user/edit";
		}
		else{
			model.addAttribute("message", "Sai thông tin đăng nhập !");
		}
		return "user/login";
	}
	
	@RequestMapping("logoff")
	public String logoff() {
		return "user/index";
	}
	@RequestMapping("register")
	public String register() {
		return "user/index";
	}
	@RequestMapping("activate")
	public String activate() {
		return "user/index";
	}
	@RequestMapping("forgot-password")
	public String forgot() {
		return "user/index";
	}
	
	@RequestMapping("chgpwd")
	public String change(Model model) {
		model.addAttribute("message", "Change Password");
		return "user/index";
	}
	
	/*
	@RequestMapping("edit")
	public String edit(Model model) {
		model.addAttribute("message", "Edit");
		return "user/index";
	}
	*/		
	@Autowired
	CategoryDAO dao;
	
	@RequestMapping("edit")
	public String index(Model model) {
		Category item = new Category();
		model.addAttribute("item", item);
		List<Category> items = dao.findAll();
		model.addAttribute("items", items);
		return "category/index";
	}
}