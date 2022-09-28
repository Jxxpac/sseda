package com.sseda.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sseda.dao.MemberDao;

public class MemberServiceimp implements MemberService {
	private MemberDao dao = new MemberDao();
	public String phoneid(String name, String num) {
		return dao.phoneid(name,num);
	}
	public String emailid(String email, String name) {
		return dao.emailid(email,name);
		
	}
	public String phonepw(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("name");
		String phone = req.getParameter("num");
		return dao.phonepw(id,phone);
	}
	public String emailpw(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("name");
		String em = req.getParameter("email");
		return dao.emailpw(id,em);
	}
	public String[] login(String id, String pw) {
		return dao.loginproc(id, pw);
	}
	public void pwchange(HttpServletRequest req, HttpServletResponse res) {
		dao.pwchange(req,res);
	}
	
}
