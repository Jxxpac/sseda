package com.sseda.dao;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sseda.common.OracleConn;
import com.sseda.dto.Answer;
import com.sseda.dto.Qna;
import com.sseda.dto.Question;
import com.sseda.dto.QuestionFile;
public class QnaDao {
	private static final Connection conn = OracleConn.in().getConn();
	public void inset(Question q) {
		String sql = "CALL p_questioninsert(?,?,?,?)";
		try {
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, q.getTitle());
			stmt.setString(2, q.getContent());
			stmt.setString(3, q.getId());
			stmt.setString(4, q.getCategory());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	   
	}
	public Map<String,List<Qna>> qna() {
		Map<String,List<Qna>> m = new HashMap<String,List<Qna>>();
		//전체
		m.put("A", qnaview("A"));
		//회원관련 자주찾는질문
		m.put("M", qnaview("M"));
		//아이템게시판 자주찾는질문
		m.put("I", qnaview("I"));
		//이벤트게시판 자주찾는질문
		m.put("E", qnaview("E"));
		//환불관련
		m.put("P", qnaview("P"));
		//멘토/멘티
		m.put("T", qnaview("T"));
		return m;
	}
	List<Qna> qnaview(String m) {
		String sql = "CALL p_qnaview(?,?)";
		   List<Qna> qna = new ArrayList<Qna>();
			try {
				CallableStatement stmt = conn.prepareCall(sql);
				stmt.setString(1, m);
				stmt.registerOutParameter(2, OracleTypes.CURSOR);
				stmt.executeQuery();
				ResultSet rs = (ResultSet)stmt.getObject(2);
				while(rs.next()) {
					Qna qna1 = new Qna();
					Question q = new Question();
					q.setSeqno(rs.getString("seqno"));
					q.setTitle(rs.getString("title"));
					
					qna1.setQuestion(q);
					
					qna.add(qna1);
				}
				
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return qna;
	}
	public String[] detail(String no) {
		String sql = "SELECT q.title,a.content FROM question q,answer a WHERE q.seqno = a.seqno AND q.seqno = ?";
		String[] tc = new String[2];
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			tc[0] = rs.getString("title");
			tc[1] =rs.getString("content");
			
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return tc;
	}
	public List<Question> mylist(HttpServletRequest req) {
		HttpSession sess = req.getSession();
		List<Question> qna = new ArrayList<>();
		String sql="call p_myqnalist(?,?)";
		try {
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, (String)sess.getAttribute("sess_id"));
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			stmt.executeQuery();
			ResultSet rs = (ResultSet)stmt.getObject(2);
			while(rs.next()) {
				Question q = new Question();
				q.setAnswerProc(rs.getString("answer_proc"));
				if(rs.getString("category").equals("T")) {
					q.setCategory("멘토/멘티");
				}else if(rs.getString("category").equals("P")) {
					q.setCategory("결제문의");
				}else if(rs.getString("category").equals("M")) {
					q.setCategory("회원문의");
				}else if(rs.getString("category").equals("I")) {
					q.setCategory("아이템관련");
				}else if(rs.getString("category").equals("E")) {
					q.setCategory("이벤트보드관련");
				}
				q.setContent(rs.getString("content"));
				q.setWdate(rs.getString("qdate"));
				q.setNo(rs.getString("rownum"));
				q.setTitle(rs.getString("title"));
				q.setSeqno(rs.getString("seq"));
				if(rs.getString("seqno") != null) {
					QuestionFile qf = new QuestionFile();
					qf.setFilename(rs.getString("savefile"));
					qf.setFilepath(rs.getString("filepath"));
					qf.setFilename(rs.getString("filename"));
					qf.setSeqno(rs.getString("seqno"));
					q.setFile(qf);
				}
				qna.add(q);
			}
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qna;
	}
	public Qna question(HttpServletRequest req) {
		String sql="call p_question(?,?,?)";
		Qna qna = new Qna();
		try {
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, req.getParameter("no"));
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			stmt.registerOutParameter(3, OracleTypes.CURSOR);
			stmt.executeQuery();
			ResultSet rs = (ResultSet)stmt.getObject(2);
			rs.next();
			Question q = new Question();
			q.setSeqno(rs.getString("no"));
			q.setAnswerProc(rs.getString("answer_proc"));
			if(rs.getString("category").equals("T")) {
				q.setCategory("멘토/멘티");
			}else if(rs.getString("category").equals("P")) {
				q.setCategory("결제문의");
			}else if(rs.getString("category").equals("M")) {
				q.setCategory("회원문의");
			}else if(rs.getString("category").equals("I")) {
				q.setCategory("아이템관련");
			}else if(rs.getString("category").equals("E")) {
				q.setCategory("이벤트보드관련");
			}
			q.setContent(rs.getString("content"));
			q.setWdate(rs.getString("qdate"));
			q.setTitle(rs.getString("title"));
			if(rs.getString("seqno") != null) {
				QuestionFile qf = new QuestionFile();
				qf.setFilename(rs.getString("savefile"));
				qf.setFilepath(rs.getString("filepath"));
				qf.setFilename(rs.getString("filename"));
				qf.setSeqno(rs.getString("seqno"));
				q.setFile(qf);
			}
			qna.setQuestion(q);
			if(!rs.getString("answer_proc").equals("N")) {
				rs = (ResultSet)stmt.getObject(3);
				rs.next();
				Answer a = new Answer();
				a.setContent(rs.getString("content"));
				qna.setAnswer(a);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qna;
	}
}
