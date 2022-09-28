package com.sseda.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sseda.dto.Qna;

public interface QnaService {
	public void insert(HttpServletRequest req, HttpServletResponse res);
	public Map<String,List<Qna>> qna();
	public String[] detail(String no);
}
