package com.sseda.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sseda.common.OracleConn;
import com.sseda.dto.Board;
import com.sseda.dto.BoardList;
import com.sseda.dto.Cre;
import com.sseda.dto.Keyword;
import com.sseda.dto.Reply;

import oracle.jdbc.OracleTypes;

public class BoardDao {
	private final Connection conn = OracleConn.in().getConn();
	public String insert(HttpServletRequest request) {
		HttpSession sess = request.getSession();
		String b = null;
		String sql="CALL p_boardinsert(?,?,?,?,?,?)";
		try {
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, request.getParameter("title"));
			stmt.setString(2, request.getParameter("content"));
			stmt.setString(3, request.getParameter("open"));
			stmt.setString(4, (String)sess.getAttribute("sess_id"));
			stmt.setInt(5, Integer.parseInt(request.getParameter("no")));
			stmt.registerOutParameter(6, OracleTypes.INTEGER);
			stmt.executeQuery();
			b = Integer.toString(stmt.getInt(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	public Board detail(String no, String id) {
		String sql="CALL p_boarddetail(?,?,?)";
		Board b = new Board();
		try {
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, id);
			stmt.setString(2, no);
			stmt.registerOutParameter(3, OracleTypes.CURSOR);
			stmt.executeUpdate();
			ResultSet rs = (ResultSet)stmt.getObject(3);
			rs.next();
			b.setTitle(rs.getString("title"));
			b.setNo(rs.getString("board_seqno"));
			b.setContent(rs.getString("content"));
			b.setName(rs.getString("name"));
			b.setWdate(rs.getString("wdate"));
			b.setNo(rs.getString("board_seqno"));
			b.setId(rs.getString("id"));
			b.setOpen(rs.getString("isopen"));
			b.setLike(rs.getString("cnt"));
			if(rs.getString("t") != null) {
				b.setLike_seqno(rs.getString("t"));
			}else {
				b.setLike_seqno("no");
			}
			List<Reply> re = new ArrayList<>();
			while(rs.next()) {
				Reply r = new Reply();
				r.setNo(rs.getString("board_seqno"));;
				r.setContent(rs.getString("content"));
				r.setWdate(rs.getString("wdate"));
				r.setName(rs.getString("name"));
				r.setId(rs.getString("id"));
				re.add(r);
			}
			b.setR(re);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	public BoardList board(Cre c, HttpServletRequest request) {
		String sql="CALL p_boardlist(?,?,?,?,?,?)";
		BoardList bl = new BoardList();
		try {
			List<Board> board = new ArrayList<>();
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setInt(1, c.getCpage());
			stmt.setInt(2, c.getRow());
			stmt.setString(3, request.getParameter("cate"));
			stmt.setString(4, request.getParameter("keyword"));
			stmt.registerOutParameter(5, OracleTypes.CURSOR);
			stmt.registerOutParameter(6, OracleTypes.CURSOR);
			stmt.executeQuery();
			ResultSet rs = (ResultSet)stmt.getObject(5);
			while(rs.next()) {
				Board b = new Board();
				b.setTitle(rs.getString("title"));
				b.setCount(rs.getString("views"));
				b.setWdate(rs.getString("wdate"));
				b.setName(rs.getString("name"));
				b.setNo(rs.getString("board_seqno"));
				b.setNum(rs.getString("rownum"));
				board.add(b);
			}
			bl.setB(board);
			rs = (ResultSet)stmt.getObject(6);
			Keyword k = new Keyword();
			rs.next();
			k.setSeqno(rs.getString("keyword_seqno"));
			k.setKeyword(rs.getString("keyword"));
			bl.setK(k);
			bl.setCate(request.getParameter("cate"));
			System.out.println(bl.getCate());
			bl.setKeyword(request.getParameter("keyword"));
			System.out.println(bl.getKeyword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bl;
	}
	public String reply_re(HttpServletRequest request) {
		String sql="SELECT content FROM reply WHERE reply_seqno=?";
		String c = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, request.getParameter("no"));
			ResultSet rs = stmt.executeQuery();
			rs.next();
			c = rs.getString("content");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	public void re(HttpServletRequest request) {
		String sql="UPDATE reply SET content=? WHERE board_seqno=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, request.getParameter("content"));
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void reply(HttpServletRequest request) {
		HttpSession sess = request.getSession();
		String sql = "INSERT INTO reply(reply_seqno,content,board_seqno,id)VALUES";
			   sql+=" (reply_seqno.nextval,?,?,?)";
			   try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, request.getParameter("content"));
				stmt.setString(2, request.getParameter("no"));
				stmt.setString(3, (String)sess.getAttribute("sess_id"));
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void redel(HttpServletRequest request) {
		String sql="DELETE FROM reply WHERE reply_seqno = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, request.getParameter("no"));
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void reg(HttpServletRequest request) {
		String sql="UPDATE eventboard SET title=? , content=?, isopen=? WHERE board_seqno=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, request.getParameter("title"));
			stmt.setString(2, request.getParameter("content"));
			stmt.setString(3, request.getParameter("open"));
			stmt.setString(4, request.getParameter("no"));
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void del(HttpServletRequest request) {
		String no = request.getParameter("no");
		String sql="DELETE FROM reply WHERE board_seqno=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			stmt.executeUpdate();
			sql="DELETE FROM recom WHERE board_seqno=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			stmt.executeUpdate();
			sql="UPDATE eventboard SET board_de = 'Y' WHERE board_seqno=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void report(HttpServletRequest request) {
		String sql="UPDATE eventboard SET report = report + 1 WHERE board_seqno = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, request.getParameter("no"));
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void replyreport(HttpServletRequest request) {
		String sql="UPDATE reply SET report = report + 1 WHERE reply_seqno = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, request.getParameter("no"));
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int getT() {
		String sql="CALL p_boardtotal(?)";
		int s = 0;
		try {
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.registerOutParameter(1, OracleTypes.INTEGER);
			stmt.executeQuery();
			s = stmt.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	public int like(HttpServletRequest request) {
		int s = 0;
		String sql="CALL p_like(?,?,?,?)";
		HttpSession sess = request.getSession();
		try {
			String stat = null;
			if(request.getParameter("stat") == null){
				stat = "";
			}else {
				stat = request.getParameter("stat");
			}
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, stat);
			stmt.setInt(2, Integer.parseInt(request.getParameter("no")));
			stmt.registerOutParameter(3, OracleTypes.INTEGER);
			stmt.setString(4, (String)sess.getAttribute("sess_id"));
			stmt.executeQuery();
			s = stmt.getInt(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}

}
