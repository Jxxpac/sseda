package com.sseda.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sseda.dto.Board;
import com.sseda.dto.Cre;
import com.sseda.dto.Page;
import com.sseda.service.BoardServiceimp;

@WebServlet("/bo/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
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
		BoardServiceimp b = new BoardServiceimp();
		if(cmd.equals("board")) {
			String page = request.getParameter("cpage");
			String row = request.getParameter("row");
			if(page == null) {
				page = "1";
			}
			if(row == null) {
				row="3";
			}
			Cre c = new Cre(Integer.parseInt(page), Integer.parseInt(row));
			c.setContent(request.getParameter("content"));
			
			request.setAttribute("board", b.board(c,request));
			request.setAttribute("page", new Page(b.getT(),c));
			view(request,response,"/board/board.jsp");
		}
		if(cmd.equals("insert")) {
			request.setAttribute("no", request.getParameter("no"));
			view(request,response,"/board/boardinsert.jsp");
		}
		if(cmd.equals("detail")) {
			String no = request.getParameter("no");
			System.out.println("1"+no+"1");
			HttpSession sess = request.getSession();
			String id = (String)sess.getAttribute("sess_id");
			if(no == null || no.equals("1")) {
				no = (String)request.getAttribute("no");
			}
			request.setAttribute("b", b.detail(no,id));
			view(request,response,"/board/boarddetail.jsp");
		}
		if(cmd.equals("boardin")) {
			String no = b.insert(request);
			request.setAttribute("no", no);
			view(request,response,"/bo/detail");
		}
		if(cmd.equals("reg")) {
			Board board = new Board();
			board.setName(request.getParameter("name"));
			board.setNo(request.getParameter("no"));
			board.setContent(request.getParameter("content"));
			board.setTitle(request.getParameter("title"));
			board.setOpen(request.getParameter("open"));
			request.setAttribute("board", board);
			view(request,response,"/board/boardreg.jsp");
		}
		if(cmd.equals("boardreg")) {
			b.reg(request);
			request.setAttribute("no", request.getParameter("no"));
			view(request,response,"/bo/detail");
		}
		if(cmd.equals("del")) {
			b.del(request);
			view(request,response,"/bo/board");
		}
		if(cmd.equals("reply_re")) {
			String c = b.reply_re(request);
			PrintWriter out = response.getWriter();
			out.print(c);
		}
		if(cmd.equals("re_reg")) {
			b.re(request);
			request.setAttribute("no", request.getParameter("no"));
			view(request,response,"/bo/detail");
		}
		if(cmd.equals("reply")) {
			b.reply(request);
			request.setAttribute("no", request.getParameter("no"));
			view(request,response,"/bo/detail");
		}
		if(cmd.equals("redel")) {
			b.redel(request);
			request.setAttribute("no", request.getParameter("seqno"));
			view(request,response,"/bo/detail");
		}
		if(cmd.equals("report")) {
			b.report(request);
			request.setAttribute("no", request.getParameter("no"));
			view(request,response,"/bo/detail");
		}
		if(cmd.equals("replyreport")) {
			b.replyreport(request);
			request.setAttribute("no", request.getParameter("seqno"));
			view(request,response,"/bo/detail");
		}
		
	}

	private void view(HttpServletRequest request, HttpServletResponse response, String string) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(string);
		rd.forward(request, response);
		
	}
	

}
