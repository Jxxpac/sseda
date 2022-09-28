package com.sseda.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sseda.service.QnaServiceimp;

@WebServlet("/qa/*")
public class QnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QnaController() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doaction(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doaction(req,res);
	}
	private void doaction(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		QnaServiceimp q = new QnaServiceimp();
		if(cmd.equals("qnainsert")) {
			view(req,res,"/service/serviceinsert.jsp");
		}
		if(cmd.equals("insert")) {
			q.insert(req,res);
			view(req,res,"/qa/qna");
		}
		if(cmd.equals("qna")) {
			req.setAttribute("qna", q.qna());
			view(req,res,"/service/service.jsp");
		}
		if(cmd.equals("detail")) {
			String no = req.getParameter("no");
			String[] tc = q.detail(no);
			PrintWriter out = res.getWriter();
			out.print(tc[0]+"/"+tc[1]);
		}
		if(cmd.equals("myquestion")) {
			req.setAttribute("qna", q.mylist(req));
			view(req,res,"/mypage/myqnalist.jsp");
		}
		if(cmd.equals("question")) {
			req.setAttribute("qna", q.question(req));
			view(req,res,"/mypage/question.jsp");
		}
	}
	private void view(HttpServletRequest req, HttpServletResponse res,String uri) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}

}
