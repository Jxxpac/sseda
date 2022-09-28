package com.sseda.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sseda.common.OracleConn;
import com.sseda.dto.AdminList;
import com.sseda.dto.Member;
import com.sseda.dto.SeachName;

import oracle.jdbc.OracleType;

@Repository
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	DataSource ds;

	/*
	 * public AdminList memberlist(HttpServletRequest req) { AdminList l = new
	 * AdminList(); List<Member> member = new ArrayList<Member>(); String[] grade =
	 * req.getParameterValues("grade"); String start = req.getParameter("start");
	 * String end = req.getParameter("end"); String sh =
	 * req.getParameter("searchcase"); String key = req.getParameter("keyword");
	 * SeachName s = new SeachName(); s.setGrade(grade); s.setStart(start);
	 * s.setEnd(end); s.setSh(sh); s.setKey(key); l.setS(s); String sql =
	 * " SELECT m.id, name, email, nickname, reg_date, grade"; sql +=
	 * " FROM member m, grade g"; sql += " WHERE m.id = g.id"; if(grade == null &&
	 * start == null && end == null && sh == null) { sql += " AND 1 = 1"; } else
	 * if(grade.length == 1 && start.equals("") && end.equals("") &&
	 * sh.equals("memall")) { sql += " AND grade = ? "; }else if (grade.length == 2
	 * && start.equals("") && end.equals("") && sh.equals("memall")) { sql +=
	 * " AND grade in(?,?)"; } else if (grade == null && start != null && end !=
	 * null && sh.equals("memall")) { sql += " AND reg_date BETWEEN ? AND ?"; } else
	 * if (grade == null && start != null && end.equals("") && sh.equals("memall"))
	 * { sql += " AND reg_date BETWEEN ? AND sysdate "; } else if (grade == null &&
	 * start == null && end != null && sh.equals("memall")) { sql +=
	 * " AND reg_date BETWEEN '22-01-01' AND ? "; } else if (grade == null &&
	 * start.equals("") && end.equals("") && sh.equals("memid")) { sql +=
	 * " AND id = ? "; } else if (grade == null && start.equals("") &&
	 * end.equals("") && sh.equals("memname")) { sql += " AND name = ? "; } else if
	 * (grade == null && start.equals("") && end.equals("") && sh.equals("memnick"))
	 * { sql += " AND nickname = ? "; } else if (grade.length == 1 && start != null
	 * && end != null && sh.equals("memall")) { sql +=
	 * " AND grade = ? AND reg_date BETWEEN ? AND ?"; } else if (grade.length == 1
	 * && start.equals("") && end != null && sh.equals("memall")) { sql +=
	 * " AND grade = ? AND reg_date BETWEEN '22-01-01' AND ?"; } else if
	 * (grade.length == 1 && start != null && end.equals("") && sh.equals("memall"))
	 * { sql += " AND grade = ? AND reg_date BETWEEN ? AND sysdate"; } else if
	 * (grade.length == 2 && start != null && end.equals("") && sh.equals("memall"))
	 * { sql += " AND grade in(?,?) AND reg_date BETWEEN ? AND sysdate"; }else if
	 * (grade.length == 2 && start.equals("") && end != null && sh.equals("memall"))
	 * { sql += " AND grade in(?,?) AND reg_date BETWEEN '22-01-01' AND sysdate";
	 * }else if (grade.length == 2 && start != null && end != null &&
	 * sh.equals("memall")) { sql +=
	 * " AND grade in(?,?) AND reg_date BETWEEN ? AND ?"; } else if (grade.length
	 * ==1 && start.equals("") && end.equals("")&& sh.equals("memid")) { sql +=
	 * " AND grade = ? AND id = ? "; } else if (grade.length == 1 &&
	 * start.equals("") && end.equals("")&& sh.equals("memname")) { sql +=
	 * " AND grade = ? AND name = ? "; } else if (grade.length == 1 &&
	 * start.equals("") && end.equals("") && sh.equals("memnick")) { sql +=
	 * " AND grade = ? AND nickname = ? "; } else if (grade.length ==2 &&
	 * start.equals("") && end.equals("") && sh.equals("memid")) { sql +=
	 * " AND grade in(?,?) AND id = ? "; } else if (grade.length == 2 &&
	 * start.equals("") && end.equals("") && sh.equals("memname")) { sql +=
	 * " AND grade in(?,?) AND name = ? "; } else if (grade.length == 2 &&
	 * start.equals("") && end.equals("") && sh.equals("memnick")) { sql +=
	 * " AND grade in(?,?) AND nickname = ? "; } else if (grade == null && start !=
	 * null && end != null && sh.equals("memnick")) { sql +=
	 * " AND reg_date BETWEEN ? AND ? AND nickname = ? "; } else if (grade == null
	 * && start != null && end != null && sh.equals("memname")) { sql +=
	 * " AND reg_date BETWEEN ? AND ? AND name = ? "; } else if (grade == null &&
	 * start != null && end != null && sh.equals("memid")) { sql +=
	 * " AND reg_date BETWEEN ? AND ? AND id = ? "; } else if (grade == null &&
	 * start.equals("") && end != null && sh.equals("memnick")) { sql +=
	 * " AND reg_date BETWEEN '22-01-01' AND ? AND nickname = ? "; } else if (grade
	 * == null && start.equals("") && end != null && sh.equals("memname")) { sql +=
	 * " AND reg_date BETWEEN '22-01-01' AND ? AND name = ? "; } else if (grade ==
	 * null && start.equals("") && end != null && sh.equals("memid")) { sql +=
	 * " AND reg_date BETWEEN '22-01-01' AND ? AND id = ? "; } else if (grade ==
	 * null && start != null && end == null && sh.equals("memid")) { sql +=
	 * " AND reg_date BETWEEN ? AND sysdate AND id = ? "; } else if (grade == null
	 * && start != null && end == null && sh.equals("memnick")) { sql +=
	 * " AND reg_date BETWEEN ? AND sysdate AND nickname = ? "; } else if (grade ==
	 * null && start != null && end == null && sh.equals("memname")) { sql +=
	 * " AND reg_date BETWEEN ? AND sysdate AND name = ? "; } else if (grade.length
	 * == 1 && start != null && end != null && sh.equals("memname")) { sql +=
	 * " AND grade = ? AND reg_date BETWEEN ? AND ? AND name = ? "; } else if
	 * (grade.length == 1 && start != null && end != null && sh.equals("memnick")) {
	 * sql += " AND grade = ? AND reg_date BETWEEN ? AND ? AND nickname = ? "; }
	 * else if (grade.length == 1 && start != null && end != null &&
	 * sh.equals("memid")) { sql +=
	 * " AND grade = ? AND reg_date BETWEEN ? AND ? AND id = ? "; } else if
	 * (grade.length == 2 && start != null && end != null && sh.equals("memname")) {
	 * sql += " AND grade in(?,?) AND reg_date BETWEEN ? AND ? AND name = ? "; }
	 * else if (grade.length == 2 && start != null && end != null &&
	 * sh.equals("memnick")) { sql +=
	 * " AND grade in(?,?) AND reg_date BETWEEN ? AND ? AND nickname = ? "; } else
	 * if (grade.length == 2 && start != null && end != null && sh.equals("memid"))
	 * { sql += " AND grade in(?,?) AND reg_date BETWEEN ? AND ? AND id = ? "; }
	 * else if (grade.length == 1 && start == null && end != null &&
	 * sh.equals("memname")) { sql +=
	 * " AND grade = ? AND reg_date BETWEEN '22-01-01' AND ? AND name = ? "; } else
	 * if (grade.length == 1 && start == null && end != null &&
	 * sh.equals("memnick")) { sql +=
	 * " AND grade = ? AND reg_date BETWEEN '22-01-01' AND ? AND nickname = ? "; }
	 * else if (grade.length == 1 && start == null && end != null &&
	 * sh.equals("memid")) { sql +=
	 * " AND grade = ? AND reg_date BETWEEN '22-01-01' AND ? AND id = ? "; } else if
	 * (grade.length == 2 && start == null && end != null && sh.equals("memname")) {
	 * sql +=
	 * " AND grade in(?,?) AND reg_date BETWEEN '22-01-01' AND ? AND name = ? "; }
	 * else if (grade.length == 2 && start == null && end != null &&
	 * sh.equals("memnick")) { sql +=
	 * " AND grade in(?,?)AND reg_date BETWEEN '22-01-01' AND ? AND nickname = ? ";
	 * } else if (grade.length == 2 && start == null && end != null &&
	 * sh.equals("memid")) { sql +=
	 * " AND grade in(?,?) AND reg_date BETWEEN '22-01-01' AND ? AND id = ? "; }
	 * else if (grade.length == 1 && start != null && end == null &&
	 * sh.equals("memname")) { sql +=
	 * " AND grade = ? AND reg_date BETWEEN ? AND sysdate AND name = ? "; } else if
	 * (grade.length == 1 && start != null && end == null && sh.equals("memnick")) {
	 * sql += " AND grade = ? AND reg_date BETWEEN ? AND sysdate AND nickname = ? ";
	 * } else if (grade.length == 1 && start != null && end == null &&
	 * sh.equals("memid")) { sql +=
	 * " AND grade = ? AND reg_date BETWEEN ? AND sysdate AND id = ? "; } else if
	 * (grade.length == 2 && start != null && end == null && sh.equals("memname")) {
	 * sql += " AND grade in(?,?) AND reg_date BETWEEN ? AND sysdate AND name = ? ";
	 * } else if (grade.length == 2 && start != null && end == null &&
	 * sh.equals("memnick")) { sql +=
	 * " AND grade in(?,?) AND reg_date BETWEEN ? AND sysdate AND nickname = ? "; }
	 * else if (grade.length == 2 && start != null && end == null &&
	 * sh.equals("memid")) { sql +=
	 * " AND grade in(?,?) AND reg_date BETWEEN ? AND sysdate AND id = ? "; }
	 * 
	 * 
	 * PreparedStatement stmt;
	 * 
	 * try { stmt = conn.prepareStatement(sql); System.out.println(sql); if(grade ==
	 * null && start == null && end == null && sh == null) {
	 * 
	 * } else if(grade.length == 1 && start.equals("") && end.equals("") &&
	 * sh.equals("memall")) { stmt.setString(1, grade[0]); }else if (grade.length ==
	 * 2 && start.equals("") && end.equals("") && sh.equals("memall")) {
	 * stmt.setString(1, grade[0]); stmt.setString(2, grade[1]); } else if (grade ==
	 * null && start != null && end != null && sh.equals("memall")) {
	 * stmt.setString(1, start); stmt.setString(2, end); } else if (grade == null &&
	 * start != null && end == null && sh.equals("memall")) { stmt.setString(1,
	 * start); } else if (grade == null && start == null && end != null &&
	 * sh.equals("memall")) { stmt.setString(1, end); } else if (grade == null &&
	 * start == null && end == null && sh.equals("memid")) { stmt.setString(1,
	 * "%"+key+"%"); } else if (grade == null && start == null && end == null &&
	 * sh.equals("memname")) { stmt.setString(1, "%"+key+"%"); } else if (grade ==
	 * null && start == null && end == null && sh.equals("memnick")) {
	 * stmt.setString(1, "%"+key+"%"); } else if (grade.length == 1 && start != null
	 * && end != null && sh.equals("memall")) { stmt.setString(1, grade[0]);
	 * stmt.setString(2, start); stmt.setString(3, end); } else if (grade.length ==
	 * 1 && start == null && end != null && sh.equals("memall")) { stmt.setString(1,
	 * grade[0]); stmt.setString(2, end); } else if (grade.length == 1 && start !=
	 * null && end == null && sh.equals("memall")) { stmt.setString(1, grade[0]);
	 * stmt.setString(2, start); } else if (grade.length == 2 && start != null &&
	 * end == null && sh.equals("memall")) { stmt.setString(1, grade[0]);
	 * stmt.setString(2, grade[1]); stmt.setString(3, start); }else if (grade.length
	 * == 2 && start == null && end != null && sh.equals("memall")) {
	 * stmt.setString(1, grade[0]); stmt.setString(2, grade[1]); stmt.setString(3,
	 * end); }else if (grade.length == 2 && start != null && end != null &&
	 * sh.equals("memall")) { stmt.setString(1, grade[0]); stmt.setString(2,
	 * grade[1]); stmt.setString(3, start); stmt.setString(4, end); } else if
	 * (grade.length ==1 && start == null && end == null && sh.equals("memid")) {
	 * stmt.setString(1, grade[0]); stmt.setString(2, "%"+key+"%"); } else if
	 * (grade.length == 1 && start == null && end == null && sh.equals("memname")) {
	 * stmt.setString(1, grade[0]); stmt.setString(2, "%"+key+"%"); } else if
	 * (grade.length == 1 && start == null && end == null && sh.equals("memnick")) {
	 * stmt.setString(1, grade[0]); stmt.setString(2, "%"+key+"%"); } else if
	 * (grade.length ==2 && start == null && end == null && sh.equals("memid")) {
	 * stmt.setString(1, grade[0]); stmt.setString(2, grade[1]); stmt.setString(3,
	 * "%"+key+"%"); } else if (grade.length == 2 && start == null && end == null &&
	 * sh.equals("memname")) { stmt.setString(1, grade[0]); stmt.setString(2,
	 * grade[1]); stmt.setString(3, "%"+key+"%"); } else if (grade.length == 2 &&
	 * start == null && end == null && sh.equals("memnick")) { stmt.setString(1,
	 * grade[0]); stmt.setString(2, grade[1]); stmt.setString(3, "%"+key+"%"); }
	 * else if (grade == null && start != null && end != null &&
	 * sh.equals("memnick")) { stmt.setString(1, start); stmt.setString(2, end);
	 * stmt.setString(3, "%"+key+"%"); } else if (grade == null && start != null &&
	 * end != null && sh.equals("memname")) { stmt.setString(1, start);
	 * stmt.setString(2, end); stmt.setString(3, "%"+key+"%"); } else if (grade ==
	 * null && start != null && end != null && sh.equals("memid")) {
	 * stmt.setString(1, start); stmt.setString(2, end); stmt.setString(3,
	 * "%"+key+"%"); } else if (grade == null && start == null && end != null &&
	 * sh.equals("memnick")) { stmt.setString(1, end); stmt.setString(2,
	 * "%"+key+"%"); } else if (grade == null && start == null && end != null &&
	 * sh.equals("memname")) { stmt.setString(1, end); stmt.setString(2,
	 * "%"+key+"%"); } else if (grade == null && start == null && end != null &&
	 * sh.equals("memid")) { stmt.setString(1, end); stmt.setString(2, "%"+key+"%");
	 * } else if (grade == null && start != null && end == null &&
	 * sh.equals("memid")) { stmt.setString(1, start); stmt.setString(2,
	 * "%"+key+"%"); } else if (grade == null && start != null && end == null &&
	 * sh.equals("memnick")) { stmt.setString(1, start); stmt.setString(2,
	 * "%"+key+"%"); } else if (grade == null && start != null && end == null &&
	 * sh.equals("memname")) { stmt.setString(1, start); stmt.setString(2,
	 * "%"+key+"%"); } else if (grade.length == 1 && start != null && end != null &&
	 * sh.equals("memname")) { stmt.setString(1, grade[0]); stmt.setString(2,
	 * start); stmt.setString(3, end); stmt.setString(4, "%"+key+"%"); } else if
	 * (grade.length == 1 && start != null && end != null && sh.equals("memnick")) {
	 * stmt.setString(1, grade[0]); stmt.setString(2, start); stmt.setString(3,
	 * end); stmt.setString(4, "%"+key+"%"); } else if (grade.length == 1 && start
	 * != null && end != null && sh.equals("memid")) { stmt.setString(1, grade[0]);
	 * stmt.setString(2, start); stmt.setString(3, end); stmt.setString(4,
	 * "%"+key+"%"); } else if (grade.length == 2 && start != null && end != null &&
	 * sh.equals("memname")) { stmt.setString(1, grade[0]); stmt.setString(2,
	 * grade[1]); stmt.setString(3, start); stmt.setString(4, end);
	 * stmt.setString(5, "%"+key+"%"); } else if (grade.length == 2 && start != null
	 * && end != null && sh.equals("memnick")) { stmt.setString(1, grade[0]);
	 * stmt.setString(2, grade[1]); stmt.setString(3, start); stmt.setString(4,
	 * end); stmt.setString(5, "%"+key+"%"); } else if (grade.length == 2 && start
	 * != null && end != null && sh.equals("memid")) { stmt.setString(1, grade[0]);
	 * stmt.setString(2, grade[1]); stmt.setString(3, start); stmt.setString(4,
	 * end); stmt.setString(5, "%"+key+"%"); } else if (grade.length == 1 && start
	 * == null && end != null && sh.equals("memname")) { stmt.setString(1,
	 * grade[0]); stmt.setString(2, end); stmt.setString(3, "%"+key+"%"); } else if
	 * (grade.length == 1 && start == null && end != null && sh.equals("memnick")) {
	 * stmt.setString(1, grade[0]); stmt.setString(2, end); stmt.setString(3,
	 * "%"+key+"%"); } else if (grade.length == 1 && start == null && end != null &&
	 * sh.equals("memid")) { stmt.setString(1, grade[0]); stmt.setString(2, end);
	 * stmt.setString(3, "%"+key+"%"); } else if (grade.length == 2 && start == null
	 * && end != null && sh.equals("memname")) { stmt.setString(1, grade[0]);
	 * stmt.setString(2, grade[1]); stmt.setString(3, end); stmt.setString(4,
	 * "%"+key+"%"); } else if (grade.length == 2 && start == null && end != null &&
	 * sh.equals("memnick")) { stmt.setString(1, grade[0]); stmt.setString(2,
	 * grade[1]); stmt.setString(3, end); stmt.setString(4, "%"+key+"%"); } else if
	 * (grade.length == 2 && start == null && end != null && sh.equals("memid")) {
	 * stmt.setString(1, grade[0]); stmt.setString(2, grade[1]); stmt.setString(3,
	 * end); stmt.setString(4, "%"+key+"%"); } else if (grade.length == 1 && start
	 * != null && end == null && sh.equals("memname")) { stmt.setString(1,
	 * grade[0]); stmt.setString(2, start); stmt.setString(3, "%"+key+"%"); } else
	 * if (grade.length == 1 && start != null && end == null &&
	 * sh.equals("memnick")) { stmt.setString(1, grade[0]); stmt.setString(2,
	 * start); stmt.setString(3, "%"+key+"%"); } else if (grade.length == 1 && start
	 * != null && end == null && sh.equals("memid")) { stmt.setString(1, grade[0]);
	 * stmt.setString(2, start); stmt.setString(3, "%"+key+"%"); } else if
	 * (grade.length == 2 && start != null && end == null && sh.equals("memname")) {
	 * stmt.setString(1, grade[0]); stmt.setString(2, grade[1]); stmt.setString(3,
	 * start); stmt.setString(4, "%"+key+"%"); } else if (grade.length == 2 && start
	 * != null && end == null && sh.equals("memnick")) { stmt.setString(1,
	 * grade[0]); stmt.setString(2, grade[1]); stmt.setString(3, start);
	 * stmt.setString(4, "%"+key+"%"); } else if (grade.length == 2 && start != null
	 * && end == null && sh.equals("memid")) { stmt.setString(1, grade[0]);
	 * stmt.setString(2, grade[1]); stmt.setString(3, start); stmt.setString(4,
	 * "%"+key+"%"); }
	 * 
	 * ResultSet rs = stmt.executeQuery();
	 * 
	 * 
	 * while(rs.next()) { Member m = new Member(); m.setId(rs.getString("id"));
	 * m.setName(rs.getString("name")); m.setNickname(rs.getString("nickname"));
	 * m.setEmail(rs.getString("email")); m.setG(rs.getString("grade"));
	 * m.setWdate(rs.getString("reg_date"));
	 * 
	 * member.add(m); } l.setM(member); } catch (SQLException e) {
	 * e.printStackTrace(); } return l; }
	 * 
	 * 
	 * public Member detailList(String id) { Member m = new Member();
	 * 
	 * String sql =
	 * " SELECT m.* , grade, nvl(0, (SELECT amount FROM payment p where p.id = ? )) price"
	 * ; sql += " FROM member m, grade g"; sql += " WHERE m.id = g.id and m.id = ?";
	 * 
	 * PreparedStatement stmt;
	 * 
	 * try { stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
	 * ResultSet.CONCUR_UPDATABLE); System.out.println(sql);
	 * 
	 * stmt.setString(1, id); stmt.setString(2, id);
	 * 
	 * ResultSet rs = stmt.executeQuery();
	 * 
	 * if(rs.next()) {
	 * 
	 * m.setId(rs.getString("id")); m.setPw(rs.getString("pw"));
	 * m.setGender(rs.getString("gender"));
	 * m.setPhonenumber(rs.getString("phonenumber"));
	 * m.setName(rs.getString("name")); m.setEmail(rs.getString("email"));
	 * m.setNickname(rs.getString("nickname")); m.setIsdel(rs.getString("isdel"));
	 * m.setWdate(rs.getString("reg_date")); m.setG(rs.getString("grade"));
	 * m.setAmount(rs.getString("price")); }
	 * 
	 * } catch (SQLException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * 
	 * return m; }
	 * 
	 * 
	 * public List<Member> deleteList() {
	 * 
	 * List<Member> member = new ArrayList<Member>();
	 * 
	 * String sql = "SELECT m.id, name, nickname, email, grade, isdeldate"; sql +=
	 * " FROM member m, grade g"; sql += " WHERE m.id = g.id AND isdel='Y'";
	 * 
	 * PreparedStatement stmt;
	 * 
	 * try { stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
	 * ResultSet.CONCUR_UPDATABLE); ResultSet rs = stmt.executeQuery();
	 * 
	 * 
	 * while(rs.next()) { Member m = new Member(); m.setId(rs.getString("id"));
	 * m.setName(rs.getString("name")); m.setNickname(rs.getString("nickname"));
	 * m.setEmail(rs.getString("email")); m.setG(rs.getString("grade"));
	 * m.setIsdeldate("isdeldate");
	 * 
	 * member.add(m); }
	 * 
	 * } catch (SQLException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * return member; }
	 * 
	 * 
	 * public Member delete(String id) { return null; }
	 */


	public String login(String id, String pw) {
		String s = null;
		String sql = "Call p_admin_login(?,?)";
		CallableStatement stmt = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareCall(sql);
			stmt.setString(1, id);
			stmt.registerOutParameter(2, OracleType.VARCHAR2);
			stmt.executeQuery();
			String rs = null;
			rs = stmt.getString(2);
			if(rs != null) {
				
					if(rs.equals(pw)) {
						s = "0";
					}else {
						s = "1";
					
				}
			}else {
				s = "2";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		return s;
	}


	private void resourceClose(Connection conn, CallableStatement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
