package com.sseda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sseda.dao.MemberDao;




@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/")
	public String index() {
		return "/admin/ad_main/index";
	}

}	

