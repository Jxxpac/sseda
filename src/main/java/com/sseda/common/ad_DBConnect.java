package com.sseda.common;
import java.sql.*;

public class ad_DBConnect {
	private static ad_DBConnect db = new ad_DBConnect();
	private ad_DBConnect(){    }
	public static ad_DBConnect getInstance() {
		return db;
	}

	public Connection getConnect() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.10.75:1521/sseda","khs","qqqq");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return con;
	}
}	