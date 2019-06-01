package com.tedu.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import org.junit.Test;
import com.tedu.util.JdbcUtils_工具;

/**
 * PreparedStatement对象的使用
 * 
 */
public class PSCRUUD {
    @Test
	public void findAll(){/**1,查询user表中的所有用户信息*/
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=JdbcUtils_工具.getConn();
			//声明sql,并获取传输器
			String sql="select * from user";
			ps=conn.prepareStatement(sql);
			//执行SQL语句
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String user = rs.getString("username");
				String pwd = rs.getString("password");
				System.out.println(id+":"+user+":"+pwd);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils_工具.close(conn, ps, rs);
		}
	}
    @Test
    public void updateUser(){//2,修改user表中id为2的记录,e密码改为123456;
    	Connection conn=null;
    	PreparedStatement ps=null;
    	ResultSet rs=null;
    	try{
    		conn=JdbcUtils_工具.getConn();
    		String sql="update user set password=? where id=?";
    		 ps=conn.prepareStatement(sql);
    		 System.out.println("输入用户id");
      		 int a=new Scanner(System.in).nextInt();
    		 System.out.println("输入用户密码");
      		 String b=new Scanner(System.in).nextLine();
    		 ps.setString(1,b);
    		 ps.setInt(2,a);
    		 int rows=ps.executeUpdate();
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		JdbcUtils_工具.close(conn, ps,rs);
    	}
    }
}














