package com.sseda.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {
	public String phoneid(String name, String num);
	public String emailid(String email, String name);
	public String phonepw(HttpServletRequest req, HttpServletResponse res);
	public String emailpw(HttpServletRequest req, HttpServletResponse res);
	public String[] login(String id, String pw);
}
