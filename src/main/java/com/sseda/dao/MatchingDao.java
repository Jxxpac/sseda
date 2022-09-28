package com.sseda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sseda.common.OracleConn;
import com.sseda.dto.Match;
import com.sseda.dto.Match_App;
import com.sseda.dto.Rating;

public class MatchingDao {
	Connection conn = OracleConn.in().getConn();
	public List<Rating> givelist(String id,String no) {
		List<Rating> rating = new ArrayList<>();
		String sql="SELECT a.*,rownum FROM (SELECT r.seqno,r.point,";
			   if(no != null) {
				   sql+=" r.id";
			   }else {
				   sql+=" r.giveid";
			   }
			   sql+=" ,to_char(r.wdate,'yyyy/mm/dd') wdate,i.title, ";
			   sql+=" to_char(r.wdate + (interval '7' day ), 'yyyy-mm-dd') rdate,sysdate ";
			   sql+=" FROM rating r,";
			   sql+=" item i,ratingstat t WHERE r.item_seqno = i.item_seqno AND r.seqno = t.rating_seqno";
			   if(no != null) {
				   sql+=" AND r.giveid = ? AND givedel ='N'";
			   }else {
				   sql+=" AND r.id = ? AND receivedel='N' ";
			   }
			   sql+=" ORDER BY r.wdate DESC)a";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()) {
				Rating r = new Rating();
				r.setNo(rs.getString("rownum"));
				r.setSeqno(rs.getString("seqno"));
				 if(no != null) {
					   r.setTakeid(rs.getString("id"));
					   r.setRegdate(rs.getString("rdate"));
					   r.setSysdate(rs.getString("sysdate"));
				   }else {
					   r.setGiveid(rs.getString("giveid"));
				   }
				r.setPoint(rs.getString("point"));
				r.setWdate(rs.getString("wdate"));
				
				r.setTitle(rs.getString("title"));
				rating.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rating;
	}
	public void del(String id, String no,String[] seqno) {
		int i = 1;
		int j = 0;
		while(i <= seqno.length) {
			String sql="UPDATE ratingstat SET ";
			if(no != null) {
				sql+=" givedel='Y',g_wdate=sysdate ";
			}else {
				sql+=" receivedel='Y',r_wdate=sysdate ";
			}
			sql+=" WHERE rating_seqno =?";
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, seqno[j++]);
				stmt.executeUpdate();
				i++;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	public Map<String,List<Match>> match(String id) {
		Map<String,List<Match>> map = new HashMap<>();
		List<Match> m = new ArrayList<>();
		List<Match> o = new ArrayList<>();
		String sql="SELECT m.id,m.matching_seqno,mentoring,mentoringwdate,to_char(m.matchingwdate,'yyyy/mm/dd')m_wdate,title,i.id i_id,cfcheck,m.item_seqno ";
			   sql+=" FROM matching m ,item i";
			   sql+=" WHERE m.item_seqno = i.item_seqno AND i.id=? AND i.cfcheck='O'";
			   sql+=" UNION";
			   sql+=" SELECT i.id,m.matching_seqno,mentoring,mentoringwdate,to_char(m.matchingwdate,'yyyy/mm/dd')m_wdate,title,m.id i_id,cfcheck,m.item_seqno ";
			   sql+=" FROM matching m ,item i";
			   sql+=" WHERE m.item_seqno = i.item_seqno AND m.id=? AND i.cfcheck='I'";
			   try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, id);
				stmt.setString(2, id);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					Match ma = new Match();
					ma.setI_id(rs.getString("id"));
					ma.setMat_wdate(rs.getString("m_wdate"));
					if(rs.getString("mentoring").equals("N")) {
						ma.setMentoring("진행중");
						ma.setMen_date("");
					}else {
						ma.setMen_date(rs.getString("mentoringwdate"));
						ma.setMentoring("완료");
					}
					ma.setSeqno(rs.getString("matching_seqno"));
					ma.setTitle(rs.getString("title"));
					ma.setI_seqno(rs.getString("item_seqno"));
					m.add(ma);
				}
				//멘티값 넣기
				map.put("menti", m);
				
				sql="SELECT m.id,m.matching_seqno,mentoring,mentoringwdate,to_char(m.matchingwdate,'yyyy/mm/dd')m_wdate,title,i.id i_id,m.item_seqno ";
			    sql+=" FROM matching m ,item i";
			    sql+=" WHERE m.item_seqno = i.item_seqno AND i.id=? AND i.cfcheck='I'";
			    sql+=" UNION";
			    sql+=" SELECT i.id,m.matching_seqno,mentoring,mentoringwdate,to_char(m.matchingwdate,'yyyy/mm/dd')m_wdate,title,m.id i_id,m.item_seqno ";
			    sql+=" FROM matching m ,item i";
			    sql+=" WHERE m.item_seqno = i.item_seqno AND m.id=? AND i.cfcheck='O'";
			    stmt = conn.prepareStatement(sql);
				stmt.setString(1, id);
				stmt.setString(2, id);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Match ma = new Match();
					ma.setO_id(rs.getString("id"));
					ma.setMat_wdate(rs.getString("m_wdate"));
					if(rs.getString("mentoring").equals("N")) {
						ma.setMentoring("진행중");
						ma.setMen_date("");
					}else {
						ma.setMen_date(rs.getString("mentoringwdate"));
						ma.setMentoring("완료");
					}
					ma.setSeqno(rs.getString("matching_seqno"));
					ma.setI_seqno(rs.getString("item_seqno"));
					ma.setTitle(rs.getString("title"));
					o.add(ma);
				}
				//멘토값 넣기
				map.put("mento", o);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return map;
	}
	public void insert(HttpServletRequest request) {
			   try {
				HttpSession sess = request.getSession();
				String content = request.getParameter("content");
				String sql="INSERT INTO rating(seqno,point,id,giveid,item_seqno";
				if(content != null) {
					sql+=" ,content";
				}
				sql+=" )VALUES (rating_seqno.nextval,?,?,?,?";
				if(content != null) {
					sql+=",? ";
				}
				sql+= ")";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, request.getParameter("rating"));
				stmt.setString(2, request.getParameter("id"));
				stmt.setString(3, (String)sess.getAttribute("sess_id"));
				stmt.setString(4, request.getParameter("no"));
				if(content != null) {
					stmt.setString(5, content);
				}
				stmt.executeUpdate();
				sql="SELECT max(seqno) seqno FROM rating";
				stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				String no = rs.getString("seqno");
				sql="INSERT INTO ratingstat(seqno,rating_seqno)VALUES(ratingstat_seqno.nextval,?)";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, no);
				stmt.executeUpdate();
				sql="UPDATE item SET matching='Y' WHERE item_seqno = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, request.getParameter("no"));
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void stat(String parameter) {
		String sql="UPDATE matching SET mentoring ='Y',mentoringwdate=sysdate WHERE matching_seqno =?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, parameter);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public int serch(String no, String id) {
		String sql="SELECT rownum FROM rating r,item i WHERE r.id = ? AND i.item_seqno = r.item_seqno AND i.item_seqno=?";
		int i = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, no);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				i = rs.getInt("rownum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public void update(Rating r) {
		String sql="UPDATE rating SET point=? WHERE seqno =?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, r.getPoint());
			stmt.setString(2, r.getNo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Match_App> put(String parameter, String id) {
		List<Match_App> m = new ArrayList<>();
		String sql="SELECT m.id,to_char(m.wdate,'yyyy/mm/dd') wdate,m.item_seqno,m.mapp_seqno,i.id item_id,title  FROM matching_app m ,item i  WHERE i.item_seqno = m.item_seqno AND";
			   if(parameter != null) {
				   sql+=" m.id=?";
			   }else {
				   sql+=" i.id=?";
			   }
			   try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, id);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					Match_App ma = new Match_App();
					if(parameter != null) {
						ma.setId(rs.getString("item_id"));
					}else {
						ma.setId(rs.getString("id"));
					}
					ma.setItem_seqno(rs.getString("item_seqno"));
					ma.setSeqno(rs.getString("mapp_seqno"));
					ma.setTitle(rs.getString("title"));
					ma.setWdate(rs.getString("wdate"));
					m.add(ma);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return m;
	}
	public void accept(String no,String id) {
		String sql="INSERT INTO matching (matching_seqno,id,item_seqno) values(matching_seqno.nextval,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, no);
			stmt.executeQuery();
			sql="DELETE FROM matching_app WHERE item_seqno =?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			stmt.executeUpdate();
			sql="UPDATE item SET matching ='Y' WHERE item_seqno =?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void cancel(String[] no) {
		int i = no.length;
		int j = 0;
		try {
			while(j<i) {
				String sql="DELETE FROM matching_app WHERE mapp_seqno =?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, no[j++]);
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void apply(String no, String id) {
		String sql="INSERT INTO matching_app (mapp_seqno,item_seqno,id)values(matching_app_seqno.nextval,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			stmt.setString(2, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
