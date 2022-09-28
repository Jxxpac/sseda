package com.sseda.dto;

import java.util.List;

public class Board {
	private String no;
	private String title;
	private String content;
	private String id;
	private String count;
	private String open;
	private String wdate;
	private String name;
	private List<Reply> r;
	private String like;
	private String like_seqno;
	private String num;
	
	
	public List<Reply> getR() {
		return r;
	}
	public void setR(List<Reply> r) {
		this.r = r;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public String getLike_seqno() {
		return like_seqno;
	}
	public void setLike_seqno(String like_seqno) {
		this.like_seqno = like_seqno;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	
}
