package com.sseda.common;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;


public class OracleConn {
	private  Connection c = null;
	private static OracleConn my = new OracleConn();
	private OracleConn() {
		conn();
	}
	public static OracleConn in() {
		return my;
	}
	private void conn(){
		try {
			Properties p =new Properties();
			String path = OracleConn.class.getResource("database.properties").getPath();
			path = URLDecoder.decode(path, "utf-8");
			p.load(new FileReader(path));
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String id = p.getProperty("id");
			String pw = p.getProperty("pw");
			Class.forName(driver);
			this.c = DriverManager.getConnection(url,id,pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public Connection getConn() {
		return c;
	}
}
