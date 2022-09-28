package com.sseda.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sseda.dao.MatchingDao;
import com.sseda.dto.Match;
import com.sseda.dto.Match_App;
import com.sseda.dto.Rating;

public class MatchingServiceimp implements MatchingService {
	MatchingDao dao = new MatchingDao();
	public List<Rating> machinglist(String id,String no) {
		return dao.givelist(id,no);
	}
	public void del(String id, String no,String[] seqno) {
		dao.del(id,no,seqno);
	}
	public Map<String,List<Match>> match(String id) {
		return dao.match(id);
	}
	public void insert(HttpServletRequest request) {
		dao.insert(request);
	}
	public void stat(String parameter) {
		dao.stat(parameter);
		
	}
	public int serch(String no, String id) {
		return dao.serch(no,id);
	}
	public void update(Rating r) {
		dao.update(r);
		
	}
	public List<Match_App> put(String parameter, String id) {
		return dao.put(parameter,id);
		
	}
	public void accept(String no,String id) {
		dao.accept(no,id);
		
	}
	public void cancel(String[] no) {
		dao.cancel(no);
		
	}
	public void apply(String no, String id) {
		dao.apply(no,id);
	}
}
