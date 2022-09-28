package com.sseda.service;


import javax.servlet.http.HttpServletRequest;

import com.sseda.dao.BoardDao;
import com.sseda.dto.Board;
import com.sseda.dto.BoardList;
import com.sseda.dto.Cre;

public class BoardServiceimp implements BoardService {
	BoardDao dao = new BoardDao();
	public String insert(HttpServletRequest request) {
		return dao.insert(request);
	}
	public Board detail(String no, String id) {
		return dao.detail(no,id);
	}
	public BoardList board(Cre c, HttpServletRequest request) {
		return dao.board(c,request);
	}
	public String reply_re(HttpServletRequest request) {
		return dao.reply_re(request);
	}
	public void re(HttpServletRequest request) {
		dao.re(request);
	}
	public void reply(HttpServletRequest request) {
		dao.reply(request);
	}
	public void redel(HttpServletRequest request) {
		dao.redel(request);
	}
	public void reg(HttpServletRequest request) {
		dao.reg(request);
	}
	public void del(HttpServletRequest request) {
		dao.del(request);
	}
	public void report(HttpServletRequest request) {
		dao.report(request);
	}
	public void replyreport(HttpServletRequest request) {
		dao.replyreport(request);
	}
	public int getT() {
		return dao.getT();
	}

}
