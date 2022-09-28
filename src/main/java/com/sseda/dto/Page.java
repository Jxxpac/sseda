package com.sseda.dto;

public class Page {
	private int start;
	private int end;
	private int t;
	private Cre c;
	private boolean prev;
	private boolean next;
	
	public Page(int t, Cre c) {
		super();
		this.t = t;
		this.c = c;
		end = (int)Math.ceil(c.getCpage()/(c.getRow()*1.0))*c.getRow();
		start = end - (c.getRow()-1);
		int rend = (int)(Math.ceil(t/(c.getRow()*1.0)));
		if(rend < end) {
			end = rend;
		}
		prev = start > 1;
		next = end < rend;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
	}
	public Cre getC() {
		return c;
	}
	public void setC(Cre c) {
		this.c = c;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	
	
}
