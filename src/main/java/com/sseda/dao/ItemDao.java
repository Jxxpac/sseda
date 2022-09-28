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
import com.sseda.dto.CheckOption;
import com.sseda.dto.Cre;
import com.sseda.dto.Item;
import com.sseda.dto.ItemFile;
import com.sseda.dto.ItemList;

import oracle.jdbc.OracleTypes;

public class ItemDao {
	private final Connection conn = OracleConn.in().getConn();
	public ItemList list(HttpServletRequest request, Cre c2) {
		ItemList item = new ItemList();
		CheckOption c = new CheckOption();
		List<Item> i = new ArrayList<>();
		String ca = request.getParameter("cate");
		String mt = request.getParameter("mt");
		String sea = request.getParameter("ser");
		String key = request.getParameter("keyword");
		String sql ="CALL p_itemlist(?,?,?,?,?,?,?)";
		try {
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setInt(1, c2.getCpage());
			stmt.setInt(2, c2.getRow());
			stmt.setString(3, ca);
			stmt.setString(4, mt);
			stmt.setString(5, sea);
			stmt.setString(6, key);
			stmt.registerOutParameter(7, OracleTypes.CURSOR);
			stmt.executeQuery();
			ResultSet rs = (ResultSet)stmt.getObject(7);
			c.setCategory(ca);
			c.setMeto_meti(mt);
			c.setDivision(sea);
			c.setKey(key);
			item.setCheck(c);
			while(rs.next()) {
				Item it = new Item();
				it.setTitle(rs.getString("title"));
				it.setName(rs.getString("name"));
				it.setSeqno(rs.getString("item_seqno"));
				it.setCount(rs.getString("cnt"));
				it.setWdate(rs.getString("wdate"));
				it.setPrice(rs.getString("price"));
				i.add(it);
			}
			item.setItem(i);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
	public Item detail(String seqno) {
		Item i = new Item();
		try {
			String sql="CALL p_itemdetail(?,?)";
			int no = Integer.parseInt(seqno);
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setInt(1, no);
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			stmt.executeQuery();
			ResultSet rs = (ResultSet)stmt.getObject(2);
			rs.next();
			i.setTitle(rs.getString("title"));
			i.setContent(rs.getString("content"));
			i.setCount(rs.getString("cnt"));
			i.setPrice(rs.getString("price"));
			i.setName(rs.getString("name"));
			i.setWdate(rs.getString("wdate"));
			i.setId(rs.getString("id"));
			i.setSeqno(rs.getString("item_seqno"));
			i.setCfcheck(rs.getString("cfcheck"));
			ItemFile f = new ItemFile();
			f.setSeqno(rs.getString("f_seqno"));
			f.setFilename(rs.getString("upfile"));
			f.setSavefile(rs.getString("savefile"));
			f.setFilepath(rs.getString("filepath"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public void delete(String no) {
		String sql="UPDATE item SET item_de='Y' WHERE item_seqno =?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void reg(HttpServletRequest request) {
		String sql="UPDATE item SET title=?,content=?,isopen=? WHERE item_seqno=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, request.getParameter("title"));
			stmt.setString(2, request.getParameter("content"));
			stmt.setString(3, request.getParameter("open"));
			stmt.setString(4, request.getParameter("no"));
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Item insert(HttpServletRequest request) {
		String sql = "INSERT INTO item(item_seqno,title,content,id,cate_seqno,cfcheck,isopen,price)VALUES(item_seqno.nextval,?,?,?,?,?,?,?)";
		Item i = new Item();
		HttpSession sess = request.getSession();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, request.getParameter("title"));
			stmt.setString(2, request.getParameter("content"));
			stmt.setString(3, (String)sess.getAttribute("sess_id"));
			stmt.setString(4, request.getParameter("cate"));
			stmt.setString(5, request.getParameter("cfcheck"));
			stmt.setString(6, request.getParameter("open"));
			stmt.setString(7, request.getParameter("price"));
			stmt.executeUpdate();
			sql="SELECT max(item_seqno) seqno FROM item";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			String j = rs.getString("seqno");
			sql="SELECT i.*,name FROM item i, member m WHERE i.id = m.id AND item_seqno = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, j);
			rs = stmt.executeQuery();
			rs.next();
			i.setTitle(rs.getString("title"));
			i.setContent(rs.getString("content"));
			i.setCount(rs.getString("cnt"));
			i.setPrice(rs.getString("price"));
			i.setName(rs.getString("name"));
			i.setWdate(rs.getString("wdate"));
			i.setId(rs.getString("id"));
			i.setSeqno(rs.getString("item_seqno"));
			i.setOpen(rs.getString("isopen"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public void report(String no) {
		String sql="UPDATE item SET report = report + 1 WHERE item_seqno = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public int getT() {
		String sql="SELECT max(rownum)ro FROM item WHERE item_de='N' AND isopen='Y' AND matching='N'";
		int s = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			s = rs.getInt("ro");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
}
