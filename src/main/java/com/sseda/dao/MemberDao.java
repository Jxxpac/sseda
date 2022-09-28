package com.sseda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sseda.common.OracleConn;

public class MemberDao {
	private static final Connection conn = OracleConn.in().getConn();
	public String[] loginproc(String id, String pw) {
		String[] loginStat = new String[2];
		
		String sql = "select * from member where id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
					if(rs.getString("pw").equals(pw)) {
						loginStat[0] = "ok";
						loginStat[1] = rs.getString("name");	
					} else {
						loginStat[0] = "pwfail";
					}
			} else {
				loginStat[0] = "loginfail";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return loginStat;
	}
	public String phoneid(String name, String num) {
		String id = "존재하지 않는 회원정보입니다.";
		String sql ="SELECT * FROM member where phonenumber =?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, num);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("name").equals(name)) {
					id = rs.getString("id");
				}else {
					id = "존재하지 않는 이름입니다.";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	public String emailid(String email, String name) {
		String id = "존재하지 않는 회원정보입니다.";
		String sql ="SELECT * FROM member where email =?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("name").equals(name)) {
					id = rs.getString("id");
				}else {
					id = "존재하지 않는 이름입니다.";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	public String phonepw(String name, String phone) {
		String pw = "1";
		String sql ="SELECT * FROM member where phonenumber =?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, phone);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("name").equals(name)) {
					pw = "3/"+rs.getString("id");
				}else {
					pw = "2";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pw;
		
	}
	public String emailpw(String id, String em) {
		String pw = "1";
		String sql ="SELECT * FROM member where email =?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, em);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("name").equals(id)) {
					pw = "3/"+rs.getString("id");
				}else {
					pw = "2";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pw;
	}
	public void pwchange(HttpServletRequest req, HttpServletResponse res) {
		String pw = req.getParameter("pw");
		String id = req.getParameter("id").substring(req.getParameter("id").lastIndexOf("/")+1);
		String sql = "UPDATE member SET pw = ? WHERE id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, pw);
			stmt.setString(2, id);
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
