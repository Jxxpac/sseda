package com.sseda.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sseda.dao.MemberDao;
import com.sseda.dao.MyDao;
import com.sseda.dto.Board;
import com.sseda.dto.Item;
import com.sseda.dto.Member;
import com.sseda.dto.Reply;

public class MyServiceimp implements MyService {
MyDao md = new MyDao();
	

	public String[] login(String id, String pw) {
		return md.loginproc(id, pw);
	}

	public void signUp(HttpServletRequest req) {
		md.signUp(req);
	}

	public int checkid(HttpServletRequest req) {
		int posi = md.checkid(req);
		return posi;
		
	}

	public Member mypage(String myid) {
		return md.mypage(myid); 
	}

	public Member firstmy(String myid) {
		return md.firstmy(myid);
	}

	public int changemy(String myid, HttpServletRequest req) {
		return md.changemy(myid, req);
	}

	public int dupnickname(HttpServletRequest req) {
		return md.dupcheck(req);
	}

	public void delrep(HttpServletRequest req) {
		md.delreq(req);
	}

	public List<Item> myitem(HttpServletRequest req) {
		return md.myitem(req);
	}

	
	public List<Board> myboard(HttpServletRequest req) {
		return md.myboard(req);
	}

	public List<Reply> myreply(HttpServletRequest req) {
		return md.myreply(req);
		
	}
}
