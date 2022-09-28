package com.sseda.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sseda.dto.Match;
import com.sseda.dto.Match_App;
import com.sseda.dto.Rating;

public interface MatchingService {
	public List<Rating> machinglist(String id,String no);
	public void del(String id, String no,String[] seqno);
	public Map<String,List<Match>> match(String id);
	public void insert(HttpServletRequest request);
	public void stat(String parameter);
	public int serch(String no, String id);
	public void update(Rating r);
	public List<Match_App> put(String parameter, String id);
	public void accept(String no,String id);
	public void cancel(String[] no);
	public void apply(String no, String id);
}
