package com.sseda.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sseda.dto.Rating;
import com.sseda.service.MatchingServiceimp;

@WebServlet("/ma/*")
public class MatchingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MatchingController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doaction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doaction(request,response);
	}
	private void doaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		MatchingServiceimp m = new MatchingServiceimp();
		if(cmd.equals("myrating")) {
			HttpSession sess = request.getSession();
			String id = (String)sess.getAttribute("sess_id");
			String no = request.getParameter("no");
			if(no != null) {
				request.setAttribute("rating", m.machinglist(id,no));
				view(request,response,"/matching/ratinggive.jsp");
			}else {
				request.setAttribute("rating", m.machinglist(id,no));
				view(request,response,"/matching/ratingreceive.jsp");
			}
		}
		if(cmd.equals("del")) {
			HttpSession sess = request.getSession();
			String id = (String)sess.getAttribute("sess_id");
			String[] seqno = request.getParameterValues("check");
			String no = request.getParameter("no");
			if(no != null) {
				m.del(id,no,seqno);
				request.setAttribute("no", "T");
				view(request,response,"/my/myrating");
			}else {
				m.del(id,no,seqno);
				view(request,response,"/my/myrating");
			}
		}
		if(cmd.equals("matching")) {
			HttpSession sess = request.getSession();
			String id = (String)sess.getAttribute("sess_id");
			request.setAttribute("match", m.match(id));
			request.setAttribute("i", request.getAttribute("i"));
			view(request,response,"/matching/usermatching.jsp");
		}
		if(cmd.equals("rainsert")) {
			String no = request.getParameter("no");
			String id = request.getParameter("id");
			if(m.serch(no,id) == 0) {
				request.setAttribute("no", no);
				request.setAttribute("id", id);
				view(request,response,"/matching/ratinginsert.jsp");
			}else {
				request.setAttribute("i", "o");
				view(request,response,"/ma/matching");
			}
		}
		if(cmd.equals("insert")) {
			m.insert(request);
			view(request,response,"/ma/myrating");
		}
		if(cmd.equals("stat")) {
			m.stat(request.getParameter("no"));
			view(request,response,"/ma/matching");
		}
		if(cmd.equals("reg")) {
			Rating r = new Rating();
			r.setTakeid(request.getParameter("id"));
			r.setPoint(request.getParameter("point"));
			r.setNo(request.getParameter("no"));
			request.setAttribute("rating", r);
			view(request,response,"/matching/ratingupdate.jsp");
		}
		if(cmd.equals("update")) {
			Rating r = new Rating();
			r.setPoint(request.getParameter("rating"));
			r.setNo(request.getParameter("no"));
			m.update(r);
			view(request,response,"/ma/myrating");
		}
		if(cmd.equals("put")) {
			HttpSession sess = request.getSession();
			String id = (String)sess.getAttribute("sess_id");
			if(request.getParameter("no") != null) {
				request.setAttribute("match", m.put(request.getParameter("no"),id));
				view(request,response,"/matching/usermatching_send.jsp");
			}else {
				request.setAttribute("match", m.put(request.getParameter("no"),id));
				view(request,response,"/matching/usermatching_receive.jsp");
			}
		}
		if(cmd.equals("accept")) {
			String no = request.getParameter("no");
			String id = request.getParameter("id");
			m.accept(no,id);
			view(request,response,"/ma/matching");
		}
		if(cmd.equals("cancel")) {
			String[] no = request.getParameterValues("no");
			m.cancel(no);
			view(request,response,"/ma/matching");
		}
		if(cmd.equals("apply")) {
			HttpSession sess = request.getSession();
			String no = request.getParameter("no");
			String id = (String)sess.getAttribute("sess_id");
			m.apply(no,id);
			request.setAttribute("no", "1");
			view(request,response,"/ma/put");
		}
	}
	private void view(HttpServletRequest request, HttpServletResponse response, String string) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(string);
		rd.forward(request, response);
	}
		
}


