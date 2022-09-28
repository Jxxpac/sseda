package com.sseda.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseda.dao.AdminDao;
import com.sseda.dao.AdminDaoImpl;
import com.sseda.dto.AdminList;
import com.sseda.dto.Member;

@Service
public class AdminServiceImp implements AdminService {
	
	@Autowired
	AdminDao memberdao;
	/*
	@Override
	public AdminList list(HttpServletRequest req) {
		return memberdao.memberlist(req);
	}
	

	public Member detailList(String id) {
		
		return memberdao.detailList(id);
	}
	
	
	public List<Member> deleteList() {
		return memberdao.deleteList();
	}
	
	public Member delete(String id) {
		return memberdao.delete(id);
	}

*/
	public String login(String id, String pw) {
		return memberdao.login(id,pw);
	}

}
