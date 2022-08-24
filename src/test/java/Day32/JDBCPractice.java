package Day32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCPractice {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");  
		
		System.out.println(con.isValid(3)); //true
		  
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
		  
		//step4 execute query  
		ResultSet rs=stmt.executeQuery("select * from emp"); 
		int count=0;
		while(rs.next())  
		{
			//count++;
		//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"   "+rs.getString(4)+"   "+rs.getInt(5));  
			 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
		//System.out.println(count);
		
		//step5 close the connection object  
		rs.close();
		con.close();  
		
  // System.out.println("test");
		
		
	}

}
