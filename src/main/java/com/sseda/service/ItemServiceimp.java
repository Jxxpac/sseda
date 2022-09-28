package com.sseda.service;


import javax.servlet.http.HttpServletRequest;

import com.sseda.dao.ItemDao;
import com.sseda.dto.Cre;
import com.sseda.dto.Item;
import com.sseda.dto.ItemList;

public class ItemServiceimp implements ItemService {
	ItemDao dao = new ItemDao();
	public ItemList list(HttpServletRequest request, Cre c) {
		return dao.list(request,c);
	}
	public Item detail(String parameter) {
		return dao.detail(parameter);
		
	}
	public void delete(String parameter) {
		dao.delete(parameter);
		
	}
	public void reg(HttpServletRequest request) {
		dao.reg(request);
		
	}
	public Item insert(HttpServletRequest request) {
		return dao.insert(request);
	}
	public void reprot(String no) {
		dao.report(no);
	}
	public int getT() {
		return dao.getT();
	}

}
