package com.ugoodigood.weixin.common;

import java.sql.SQLException;

public class MysqlTest {
	public static void main(String[] args) {
		try {
			Class.forName(com.mysql.jdbc.Driver.class.getName());
			java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql//:127.0.0.1", "root", "1q2w3e");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
