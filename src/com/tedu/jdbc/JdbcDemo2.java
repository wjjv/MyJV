package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;
/**
 * JDBK的快速入门程序
 * 查询account表中的所有记录,并输出到控制台
 */
public class JdbcDemo2 {
	public static void main(String[] args)   {
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		//1,注册数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			new Driver();
			//2,获取数据库连接
			 conn=DriverManager.getConnection
("jdbc:mysql://localhost:3306/jt_db","root","tarena");//connection 是访问数据库过程中一个至关重要的一个对象;
 // 协议名称    主机名称和端口  连接的库
			//3,获取传输器
			 stat = conn.createStatement();
			//4,发送sql到数据库执行,并返回执行结果
			String sql="select * from account";
			 rs = stat.executeQuery(sql);
			//stat.executeUpdate("");
			//5,处理结果(输出到控制台)
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				double money=rs.getDouble("money");
				System.out.println(id+":"+name+":"+money);
			}
			//6,释放资源时是按照越晚获取的越先关闭的顺序!!!
			System.out.println("执行完成");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("失败");
		}finally{//这里的代码一定会被执行
			//释放资源
			if(rs !=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				rs=null;
			}
			}
			
			
			if(stat !=null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				stat=null;
			}
			}
			
			
			if(conn !=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn=null;
			}
			}
			
		}
	}
	
}














