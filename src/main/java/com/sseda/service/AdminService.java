package com.sseda.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sseda.dto.AdminList;
import com.sseda.dto.Member;

public interface AdminService {
	/*
	 * public AdminList list(HttpServletRequest req);
	 * 
	 * public Member detailList(String id);
	 * 
	 * public List<Member> deleteList();
	 * 
	 * public Member delete(String id);
	 */
	
	public String login(String id, String pw);
	
	
}
