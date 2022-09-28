package com.sseda.dto;

import java.util.List;

public class ItemList {
	private List<Item> item;
	private CheckOption check;
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	public CheckOption getCheck() {
		return check;
	}
	public void setCheck(CheckOption check) {
		this.check = check;
	}
	
	
}
