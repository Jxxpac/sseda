package com.sseda.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sseda.dto.Cre;
import com.sseda.dto.Item;
import com.sseda.dto.Page;
import com.sseda.service.ItemServiceimp;

@WebServlet("/it/*")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ItemController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doaction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doaction(request,response);
	}

	private void doaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		ItemServiceimp i = new ItemServiceimp();
		if(cmd.equals("item")) {
			String page = request.getParameter("cpage");
			String row = request.getParameter("row");
			if(page == null) {
				page = "1";
			}
			if(row == null) {
				row = "6";
			}
			Cre c = new Cre(Integer.parseInt(page), Integer.parseInt(row));
			c.setContent(request.getParameter("content"));
			request.setAttribute("item", i.list(request,c));
			request.setAttribute("page", new Page(i.getT(),c));
			view(request,response,"/item/itemlist.jsp");
		}
		if(cmd.equals("detail")){
			String no = request.getParameter("no");
			if(no == null) {
				no = (String)request.getAttribute("no");
			}
			request.setAttribute("detail",i.detail(no));
			view(request,response,"/item/itemdetail.jsp");
		}
		if(cmd.equals("delete")) {
			i.delete(request.getParameter("no"));
			view(request,response,"/it/item");
		}
		if(cmd.equals("itemreg")) {
			Item it = new Item();
			it.setTitle(request.getParameter("title"));
			it.setSeqno(request.getParameter("no"));
			it.setContent(request.getParameter("content"));
			it.setOpen(request.getParameter("open"));
			request.setAttribute("item", it);
			view(request,response,"/item/itemreg.jsp");
		}
		if(cmd.equals("reg")) {
			i.reg(request);
			request.setAttribute("no", request.getParameter("no"));
			view(request,response,"/it/detail");
			
		}
		if(cmd.equals("insert")) {
			view(request,response,"/item/iteminsert.jsp");
		}
		if(cmd.equals("in")) {
			request.setAttribute("detail", i.insert(request));
			view(request,response,"/item/itemdetail.jsp");
		}
		if(cmd.equals("report")) {
			String no = request.getParameter("no");
			i.reprot(no);
			request.setAttribute("no", no);
			view(request,response,"/it/detail");
		}
	}

	private void view(HttpServletRequest request, HttpServletResponse response, String string) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(string);
		rd.forward(request, response);
	}

}
