package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;
import org.omg.CORBA.portable.ValueInputStream;

import com.tedu.util.JdbcUtils_工具;

public class JdbcCRUD {
	/*
	 * JDBC里的增删改查>> Create 增加 , Retrieve查询,Update增加,Delete删除; 
	 */
	@Test
	public void addAcc(){//(自己完成)增加：往account表中插入一条新的记录，name为 "john"，money为30000	
	
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try{
		//注册驱动并获取连接
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jt_db","root","tarena");
		//获取传输器
		stat=conn.createStatement();
		//发送sql到服务器执行并返回执行结果
		String sql="insert into account values(null,'john',30000000)";
		int rows=stat.executeUpdate(sql);
		//处理结果
		System.out.println("影响的行数:"+rows);
		}catch(Exception e){
		e.printStackTrace();
		System.out.println("执行失败");
		}finally{
			//释放资源(模板)
			JdbcUtils_工具.close(conn,stat,rs);
			
		}
		
	}
	@Test
	public void updateAcc(){//2、(自己完成)修改：修改account表中name为 "john" 的记录，将金额改为2500	
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jt_db","root","tarena");
		stat=conn.createStatement();
		String sql="update account set money=2500 where name='john'";
		int rows=stat.executeUpdate(sql);
		System.out.println("影响的行数:"+rows);
		}catch(Exception e){
		e.printStackTrace();
		System.out.println("执行失败");
		}finally{
			JdbcUtils_工具.close(conn,stat,rs);
		
		}
	}
	@Test
	public void deleteAcc(){//3、(自己完成)删除：删除account表中name为 "john" 的记录
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jt_db","root","tarena");
		stat=conn.createStatement();
		String sql="delete from account where name='john'";
		int rows=stat.executeUpdate(sql);
		System.out.println("影响的行数:"+rows);
		}catch(Exception e){
		e.printStackTrace();
		System.out.println("执行失败");
		}finally{
			JdbcUtils_工具.close(conn,stat,rs);
	}
	}
	@Test
	public void findByid(){//4.查询：查询account表中id为1的记录	
		Connection conn = null;
		Statement stat = null;
		ResultSet rs =null;
		try{
		conn=JdbcUtils_工具.getConn();
		stat=conn.createStatement();
		String sql="select * from account where id=1";
		rs=stat.executeQuery(sql);
		//4.chu li jie guo
		if(rs.next()){
			int id=rs.getInt("id");
			String name=rs.getString("name");
			double money=rs.getDouble("money");
			System.out.println(id+":"+name+":"+money);
		}
		
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//释放资源
			JdbcUtils_工具.close(conn,stat,rs);
		}
	
		
	}
	
}
