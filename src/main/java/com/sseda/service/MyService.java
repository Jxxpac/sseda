package com.sseda.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sseda.dto.Board;
import com.sseda.dto.Item;
import com.sseda.dto.Member;
import com.sseda.dto.Reply;

public interface MyService {
public String[] login(String id, String pw);
	
	//�쉶�썝媛��엯
	public void signUp(HttpServletRequest req);
	
	//�븘�씠�뵒 以묐났寃��궗
	public int checkid(HttpServletRequest req);
	
	//留덉씠�럹�씠吏�
	public Member firstmy(String myid);
	
	//留덉씠�럹�씠吏� - �긽�꽭
	public Member mypage(String myid);
	
	//媛쒖씤�젙蹂� �닔�젙
	public int changemy(String myid, HttpServletRequest req);
	
	//�땳�꽕�엫, �쟾�솕踰덊샇, �씠硫붿씪 �닔�젙�떆 以묐났泥댄겕
	public int dupnickname(HttpServletRequest req);
	
	//�쉶�썝�깉�눜�슂泥�
	public void delrep(HttpServletRequest req);
	
	//�궡�븘�씠�뀥 紐⑸줉議고쉶
	public List<Item> myitem(HttpServletRequest req);
	
	//�궡媛� �옉�꽦�븳 寃뚯떆湲� 紐⑸줉議고쉶
	public List<Board> myboard(HttpServletRequest req);
	
	//�궡媛� �옉�꽦�븳 �뙎湲� 紐⑸줉議고쉶
	public List<Reply> myreply(HttpServletRequest req);
}
