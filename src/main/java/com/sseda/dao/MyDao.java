package com.sseda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sseda.common.OracleConn;
import com.sseda.dto.Board;
import com.sseda.dto.Item;
import com.sseda.dto.Member;
import com.sseda.dto.Reply;

public class MyDao {
private final Connection conn = OracleConn.in().getConn();
	
	
	public String[] loginproc(String id, String pw) {
		
		String[] loginStat = new String[3];
		
		String DBK = "select * from member where id = ? ";
		
		try {
			PreparedStatement stmt = null;
			stmt = conn.prepareStatement(DBK);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("isdel").equals("N")) {					
						if(rs.getString("pw").equals(pw)) {
							loginStat[0] = "ok";
							loginStat[1] = rs.getString("pw");
							loginStat[2] = rs.getString("name");	
						} else {
							loginStat[0] = "pwfail";
						}
				} else {
					loginStat[0] = "deluser";
				}
			} else {
				loginStat[0] = "loginfail";
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return loginStat;
	}
	
	public void signUp(HttpServletRequest req) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name1");
		System.out.println(name);
		String nickname = req.getParameter("nickname");
		String gender = req.getParameter("gender");
		String phonenumber = req.getParameter("phone");
		String email = req.getParameter("email") + "@" + req.getParameter("eDomain");
		
		Statement stmt;
		
		try {
			
			String sql = String.format("INSERT INTO member" + 
									   "(id, pw, name, nickname, gender, phonenumber, email) " + 
								   	   "values('%s', '%s', '%s', '%s', '%s', '%s', '%s')" ,
								   	   id, pw, name, nickname, gender, phonenumber, email);
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {	
			e.printStackTrace();
		}  
	}

	public int checkid(HttpServletRequest req) {
		String inputid = req.getParameter("id");
		//System.out.println("�엯�젰�븳 �븘�씠�뵒 媛� = " + inputid);
		int posi = 0;
		
		String sql = "select id from member where id = ?";
		try {			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, inputid);
			ResultSet rs = stmt.executeQuery();
			if(!rs.next()) {
				posi = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return posi;	
	}
	
	public Member mypage(String myid) {
		Member member = new Member();
		try {
			String sql = " select m.*, grade";
			sql += " from (select id, name, gender, nickname, phonenumber, email from member where id = ?) m,";
			sql += " grade g";
			sql += " where g.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, myid);
			stmt.setString(2, myid);
			ResultSet rs = stmt.executeQuery();
			List<String> grade = new ArrayList<String>();
			if(rs.next()) {
				member.setId(rs.getString("id"));
				//m.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setGender(rs.getString("gender"));
				member.setNickname(rs.getString("nickname"));
				member.setPhonenumber(rs.getString("phonenumber"));
				member.setEmail(rs.getString("email"));
				grade.add(rs.getString("grade"));
				if(rs.next()) {
					grade.add(rs.getString("grade"));
				}
			}
			member.setGrade(grade);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;			
	}

	public Member firstmy(String myid) {
		Member member = new Member();
		try {
			String sql = " select id, name, email from member where id = ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, myid);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;			
	}

	public int changemy(String myid, HttpServletRequest req) {
		int ch = 0;
		try {
			String sql = " select nickname from member where nickname = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, req.getParameter("nickname"));
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				ch = 1;
			} else {				
				sql = " update member set pw = ?, nickname = ?, phonenumber = ?, email = ? where id = ? "; 
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, req.getParameter("pw"));
				stmt.setString(2, req.getParameter("nickname"));
				stmt.setString(3, req.getParameter("phonenumber"));
				stmt.setString(4, req.getParameter("email"));
				stmt.setString(5, myid);
				stmt.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return ch;	
	}

	public int dupcheck(HttpServletRequest req) {
		int dup = 0;
		try {
			if(req.getParameter("nickname") != null) {
				String sql = " select nickname from member where nickname = ? ";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, req.getParameter("nickname"));
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					dup = 1;
				} else {
					dup = 2;
				}
			}
			if(req.getParameter("nickname").equals("")) {
				dup = 3;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return dup;
	}

	public void delreq(HttpServletRequest req) {
		
		try {
			String sql = " update member set isdel = 'Y' where id = ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, req.getParameter("id"));
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	public List<Item> myitem(HttpServletRequest req) {
		List<Item> item = new ArrayList<Item>();
		try {
			String sql = " select item_seqno, title, price, isopen, matching, wdate from item where id = ? order by item_seqno desc" ;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, req.getParameter("id"));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Item myitem = new Item();
				myitem.setSeqno(rs.getString("item_seqno"));
				myitem.setTitle(rs.getString("title"));
				myitem.setPrice(rs.getString("price"));
				myitem.setOpen(rs.getString("isopen"));
				myitem.setMatching(rs.getString("matching"));
				myitem.setWdate(rs.getString("wdate"));
				item.add(myitem);
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	public List<Board> myboard(HttpServletRequest req) {
		List<Board> eventboard = new ArrayList<Board>();
		try {
			String sql = " select board_seqno, title, id, wdate, views from eventboard where id = ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, req.getParameter("id"));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setNo(rs.getString("board_seqno"));
				board.setTitle(rs.getString("title"));
				board.setWdate(rs.getString("wdate"));
				board.setCount(rs.getString("views"));
				eventboard.add(board);
				sql = " select count(*) count from recom where board_seqno = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, rs.getString("board_seqno"));
				ResultSet rs2 = stmt.executeQuery();
				if(rs2.next()) {
					board.setLike(rs2.getString("count"));
				}
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventboard;
	}

	public List<Reply> myreply(HttpServletRequest req) {
		List<Reply> reply = new ArrayList<Reply>();
		try {
			String sql = " select reply_seqno, ";
				   sql += " (select title from eventboard e where e.board_seqno = r.board_seqno and r.id = ?) title, r.board_seqno bseqno,";
				   sql += " r.content content, r.wdate wdate";
				   sql += " from reply r ";
				   sql += " where r.id = ? ";
				   sql += " order by reply_seqno ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, req.getParameter("id"));
			stmt.setString(2, req.getParameter("id"));
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Reply re = new Reply();
				re.setNo(rs.getString("reply_seqno"));
				re.setBoard_title(rs.getString("title"));
				re.setBoard_no(rs.getString("bseqno"));
				re.setContent(rs.getString("content"));
				re.setWdate(rs.getString("wdate"));
				reply.add(re);
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reply;
	}
	
	
}
