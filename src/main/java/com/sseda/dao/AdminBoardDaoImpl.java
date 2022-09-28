package com.sseda.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sseda.dto.Board;
import com.sseda.dto.Cre;

import oracle.jdbc.OracleTypes;

@Repository
public class AdminBoardDaoImpl implements AdminBoardDao {

	@Autowired
	private DataSource ds;
	
	public List<Board> boardList(Cre cri) {
		Connection conn = null;
		CallableStatement stmt = null;
		List<Board> board = new ArrayList<Board>();
		
		
	
		String sql = "call p_admin_boardlist(?)";
			
			try {
				conn = ds.getConnection();
				stmt = conn.prepareCall(sql);
				stmt.registerOutParameter(1, OracleTypes.CURSOR);
				stmt.executeQuery();
				
				ResultSet rs = (ResultSet)stmt.getObject(1);
				
				while(rs.next()) {
					Board b = new Board();
					b.setNo(rs.getString("board_seqno"));
					b.setTitle(rs.getString("title"));
					b.setWdate(rs.getString("wdate"));
					b.setId(rs.getString("id"));
					b.setContent(rs.getString("content"));
					board.add(b);
				}
					conn.close();
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return board;
	}
}
