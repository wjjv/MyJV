package da03;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;
import com.tedu.util.JdbcUtils_工具;


public class Test1 {
	
	@Test
	public void findAll(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=JdbcUtils_工具.getConn();
			String sql="select * from user";
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils_工具.close(conn, ps,rs );
		}
	}





}









