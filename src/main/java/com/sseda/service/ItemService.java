package com.sseda.service;


import javax.servlet.http.HttpServletRequest;

import com.sseda.dto.Cre;
import com.sseda.dto.Item;
import com.sseda.dto.ItemList;

public interface ItemService {
	public ItemList list(HttpServletRequest request, Cre c);
	public Item detail(String parameter);
	public void delete(String parameter);
	public void reg(HttpServletRequest request);
	public Item insert(HttpServletRequest request);
	public void reprot(String no);
}
