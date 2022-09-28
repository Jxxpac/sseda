package com.sseda.dto;

import java.util.List;

public class BoardList {
	private List<Board> b;
	private Keyword k;
	private String cate;
	private String keyword;
	public Keyword getK() {
		return k;
	}
	public void setK(Keyword k) {
		this.k = k;
	}
	public List<Board> getB() {
		return b;
	}
	public void setB(List<Board> b) {
		this.b = b;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
