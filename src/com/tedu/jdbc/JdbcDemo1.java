package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * JDBK的快速入门程序
 * 查询account表中的所有记录,并输出到控制台
 */
public class JdbcDemo1 {
	public static void main(String[] args) throws Exception  {
		//1,注册数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2,获取数据库连接
		Connection conn=DriverManager.getConnection
	("jdbc:mysql://localhost:3306/jt_db","root","tarena");
		//3,获取传输器
		Statement stat = conn.createStatement();
		
		//4,发送sql到数据库执行,并返回执行结果
		String sql="select * from account";
		ResultSet rs = stat.executeQuery(sql);
		//stat.executeUpdate("");
		
		//5,处理结果(输出到控制台)
		while(rs.next()){
			int id=rs.getInt("id");
			String name=rs.getString("name");
			double money=rs.getDouble("money");
			System.out.println(id+":"+name+":"+money);
		}
		//6,释放资源
		rs.close();
		stat.close();
		conn.close();
		
	
		 
		
		System.out.println("完成!");
	}
}
