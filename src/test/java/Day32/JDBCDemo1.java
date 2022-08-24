package Day32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo1 {

	public static void main(String[] args) throws SQLException 
	{
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");  
		
		System.out.println(con.isValid(3)); //true
		  
		//step3 create the statement object  
		Statement stmt=con.createStatement(); 
		
		String query="insert into emp values(107,'Roja','flower')";
		stmt.execute(query);
		
		String update_query="update emp set firstname='rosy' where eid=103";
		stmt.execute(update_query);
		
		String delete_query="delete from emp where eid=102";
		stmt.execute(delete_query);
		
		con.close();
		System.out.println("Program done !");

	}

}
