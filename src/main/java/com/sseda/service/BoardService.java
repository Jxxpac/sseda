package com.sseda.service;


import javax.servlet.http.HttpServletRequest;

import com.sseda.dto.Board;
import com.sseda.dto.BoardList;
import com.sseda.dto.Cre;

public interface BoardService {
	public String insert(HttpServletRequest request);
	public Board detail(String no, String id);
	public BoardList board(Cre c,HttpServletRequest request);
	public String reply_re(HttpServletRequest request);
	public void re(HttpServletRequest request);
	public void reply(HttpServletRequest request);
	public void redel(HttpServletRequest request);
	public void reg(HttpServletRequest request);
	public void del(HttpServletRequest request);
	public void report(HttpServletRequest request);
	public void replyreport(HttpServletRequest request);
	public int getT();
}
