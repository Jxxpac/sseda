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

import com.sseda.service.MemberServiceimp;
import com.sseda.service.MyServiceimp;

@WebServlet("/mem/*")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MyServiceimp msi = new  MyServiceimp();
	PrintWriter out;   
    public MypageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doaction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doaction(request,response);
	}
	private void doaction(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=utf-8");
		String uri = req.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		HttpSession sess = req.getSession();
		MemberServiceimp m = new MemberServiceimp();
		if(cmd.equals("gologin")) {
			View(req, res, "/member/login.jsp");	
		} else if(cmd.equals("gosignup")) {
			View(req, res, "/member/memberform.jsp");
		} else if(cmd.equals("login")) {
			
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			String[] loginStat = msi.login(id,pw);
			System.out.println(loginStat[0]);
			switch(loginStat[0]) { 
				case "ok" : //濡쒓렇�씤�꽦怨�
					sess.setAttribute("sess_id", id);
					sess.setAttribute("sess_pw",loginStat[1]);
					sess.setAttribute("sess_name", loginStat[2]);
					req.setAttribute("loginmsg", "loginok");
					View(req, res, "/main.jsp");
					break;
				case "pwfail" : //鍮꾨�踰덊샇 遺덉씪移�
					req.setAttribute("loginmsg", "pwfail");
					View(req, res, "/member/login.jsp");
					break;
				case "loginfail" : //濡쒓렇�씤 �떎�뙣
					req.setAttribute("loginmsg", "loginfail");
					View(req, res, "/member/login.jsp");
					break;	
				case "deluser" : //�깉�눜�슂泥��븳 �쑀��
					req.setAttribute("loginmsg", "deluser");
					View(req, res, "/member/login.jsp");
					break;
			}
		} else if(cmd.equals("logout")) {
			req.getSession().invalidate();
			View(req, res, "/main.jsp");
		} else if(cmd.equals("signup")) {
			msi.signUp(req);
			View(req, res, "/main.jsp");
		} else if(cmd.equals("idcheck")) {
			int posi = msi.checkid(req);
			
			//System.out.println("�븘�씠�뵒 泥댄겕 媛� = " + posi);
			try {
				out = res.getWriter();
				out.print(posi);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if(cmd.equals("usercheck")) {
			String pw = req.getParameter("pw");
			String id = req.getParameter("id");
			//System.out.println("�솗�씤 1 = " + pw);
			req.setAttribute("id", id);
			req.setAttribute("chpw", pw);
			View(req, res, "/mypage/usercheck.jsp");
		} else if(cmd.equals("checkpw")) {
			String pw = req.getParameter("chpw");
			//System.out.println("�솗�씤 2 = " + pw );
			System.out.println(req.getParameter("putpw"));
			if(pw.equals(req.getParameter("putpw"))) {
				String myid = req.getParameter("id");
				req.setAttribute("firstmy", msi.firstmy(myid));
				//System.out.println("�벑湲� �솗�씤 = " + msi.mypage(myid).getGrade().get(0).getGrade());
				View(req, res, "/mypage/mypage.jsp");
			} else {
				View(req, res, "/main.jsp");
			}
			
		} else if(cmd.equals("userinfo")) {
			String myid = req.getParameter("id");
			
			if(myid == null) {
				myid = (String)req.getAttribute("id");
			}
			
			req.setAttribute("mypage", msi.mypage(myid)); 
			View(req, res, "/mypage/userinfo.jsp");
		} else if(cmd.equals("changeuser")) {
			req.setAttribute("id", req.getParameter("id"));
			View(req, res, "/mypage/changeuser.jsp");
		} else if(cmd.equals("changeinfo")) {
			String myid = req.getParameter("id");
			int ch = msi.changemy(myid, req);
			//req.setAttribute("changemy", msi.changemy(myid, req);
		} else if(cmd.equals("closechuser")){
			//System.out.println("痍⑥냼�븷�븣 = " + req.getParameter("id"));
			req.setAttribute("id", req.getParameter("id"));
			View(req, res, "/mem/userinfo");
		} else if(cmd.equals("dupcheck")) {
			int dup = msi.dupnickname(req);
			
			try {
				out = res.getWriter();
				out.print(dup);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//System.out.println("�땳�꽕�엫 以묐났�솗�씤 媛� = " + dup);
		} else if(cmd.equals("delreq")) {
			msi.delrep(req);
			req.getSession().invalidate();
		} else if(cmd.equals("userinfoitem")) {
			req.setAttribute("myitem", msi.myitem(req));
			View(req, res, "/mypage/userinfo_item.jsp");
		} else if(cmd.equals("userinfoboard")) {
			req.setAttribute("myboard", msi.myboard(req));
			View(req, res, "/mypage/userinfo_board.jsp");
		} else if(cmd.equals("userinforeply")) {
			req.setAttribute("myreply", msi.myreply(req));
			View(req, res, "/mypage/userinfo_reply.jsp");
		}
		if(cmd.equals("idfind")) {
			View(req,res,"/member/idfind.jsp");
		}
		if(cmd.equals("phoneid")) {
			String name = req.getParameter("name");
			String num = req.getParameter("phonenum");
			req.setAttribute("findid", m.phoneid(name,num));
			View(req,res,"/member/idfind.jsp");
		}
		if(cmd.equals("emailid")) {
			String email = req.getParameter("email")+"@"+req.getParameter("em");
			String name = req.getParameter("name");
			req.setAttribute("findid", m.emailid(email,name));
			View(req,res,"/member/idfind.jsp");
		}
		if(cmd.equals("pwfind")) {
			View(req,res,"/member/pwfind.jsp");
		}
		if(cmd.equals("phonepw")) {
			PrintWriter out = res.getWriter();
			out.print(m.phonepw(req,res));
		}
		if(cmd.equals("emailpw")) {
			PrintWriter out = res.getWriter();
			out.print(m.emailpw(req,res));
		}
		if(cmd.equals("pwchange")) {
			m.pwchange(req,res);
			View(req,res,"/mem/gologin");
		}
	}
	void View(HttpServletRequest request, HttpServletResponse response,String uri) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

}
