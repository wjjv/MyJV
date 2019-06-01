package com.tedu.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


import com.tedu.util.JdbcUtils_工具;

/**
 * 模拟用户登录案例
 * @author UID
 */
public class LoginnUser {
	/*思路:提示用户在控制台输入用户名和密码,并接收用户输入的用户名和密码
	 * 根据用户名和密码查询user表,如果查询到了记录,则用户名密码正确,允许
	 * 用户登录,否则就提示用户或密码错误
	 */
	public static void main(String[] args) {
		//声明一个Scanner对象
		Scanner in=new Scanner(System.in);
		//1,提示用户登录
		System.out.println("请登录!!!");
		//2,提示用户输入用户名,密码,并接收
		System.out.println("请输入用户名:");
		String user=in.nextLine();
		System.out.println("请输入密码:");
		String pwd=in.nextLine();
		//3,调用login方法,传入用户名密码进行登录
		LoginBYPS(user,pwd);
		//4,返回结果
	}
	private static void LoginBYPS(String user, String pwd) {
		/*
		 * 根据用户名和密码查询用户表
		 *  "select * from user where username='"+user+"' and password='"+pwd+"'"
		 *  ResultSet
		 *  if(rs.next()){
		 *  System.out.println("恭喜登录成功");
		 *  }else{
		 *  System.out.println("登录失败,用户名和密码错误");
		 */
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			//注册驱动并获取连接
			//获取传输器
			//执行sql语句
			//处理结果
			conn=JdbcUtils_工具.getConn();
			String sql="select * from user where username=? and password=?";
			ps=conn.prepareStatement(sql);
			//设置参数
			ps.setString(1, user);
			ps.setString(2, pwd);
			//执行sql语句(千万不要再次传两次sql语句)
			rs=ps.executeQuery();
			if(rs.next()){
				System.out.println("恭喜您登录成功!");
			
			}else{
				System.out.println("用户名或密码错误!");
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils_工具.close(conn, ps, rs);
		}
	}
	/*private static void Login(String user, String pwd) {
		
		  根据用户名和密码查询用户表
		 *  "select * from user where username='"+user+"' and password='"+pwd+"'"
		 *  ResultSet
		 *  if(rs.next()){
		 *  System.out.println("恭喜登录成功");
		 *  }else{
		 System.out.println("登录失败,用户名和密码错误");
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try{
			//注册驱动并获取连接
			//获取传输器
			//执行sql语句
			//处理结果
			conn=JdbcUtils_工具.getConn();
			stat=conn.createStatement();
			String sql="select * from user "
					+ "where username='"+user+"' and password='"+pwd+"'";
			System.out.println(sql);
			rs=stat.executeQuery(sql);
			if(rs.next()){
				System.out.println("恭喜您登录成功!");
			}else{
				System.out.println("用户名或密码错误!");
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils_工具.close(conn, stat, rs);
		}
}
*/
	}








