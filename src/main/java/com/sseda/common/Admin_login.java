package com.sseda.common;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sseda.dto.Member;
import com.sseda.service.AdminService;


@Controller
public class Admin_login {

	@Autowired
	AdminService ad;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Member mem, HttpSession sess) {
		
		String map = ad.login(mem.getId(), mem.getPw());
		
			
		return "/admin/ad_main/m_main";
	}
	
}
