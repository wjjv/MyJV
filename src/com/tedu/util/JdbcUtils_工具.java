package com.tedu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils_工具 {
	// 私有化构造方法(目的是不让别人创建该类的对象,因为都是静态方法,直接调用即可)
	private JdbcUtils_工具() {}
	public static  Connection getConn()throws Exception{
		//注册驱动,并获取连接
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jt_db?characterEncoding=utf-8","root","tarena");
		return conn;
	}
	
    /** 释放资源的工具方法*/
	public static void close(Connection conn, Statement stat, ResultSet rs) {
		//释放资源
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stat = null;
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

}
