package theredSQL;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.util.ArrayList;
public class database 
{
	public ArrayList<Record> GetList()
	{
		 ArrayList<Record> aryLst = new ArrayList<Record>();
	
		// TODO Auto-generated method stub

		 Connection con = null;
			CallableStatement cstmt = null;
			ResultSet rs = null;
			
			try 
			{
				// Establish the connection. 
				SQLServerDataSource ds = new SQLServerDataSource();
				ds.setIntegratedSecurity(true);
				ds.setServerName("localhost");
				ds.setPortNumber(1433); 
				ds.setDatabaseName("Scrum");
				con = ds.getConnection();
				 
		        	// Execute a stored procedure that returns some data.
	            		//cstmt = con.prepareCall("{call dbo.Select_All(?)}");
	            		cstmt = con.prepareCall("{call dbo.Select_All()}");
	            		//cstmt.setInt(1, 50);
	            		rs = cstmt.executeQuery();

		        	// Iterate through the data in the result set and display it.
		        	while (rs.next()) 
		        	{
		            		//System.out.println("EMPLOYEE: " + rs.getString("question") + 
		            		//	", " + rs.getString("Answer1"));
		            		//System.out.println("MANAGER: " + rs.getString("Answer2") + 
		            		//	", " + rs.getString("ManagerFirstName"));
		            		//System.out.println();
		        		Record rec=new Record();
		        		rec.Question=rs.getString("question");
		        		rec.Answer1=rs.getString("Answer1");
		        		rec.Answer2=rs.getString("Answer2");
		        		rec.Answer3=rs.getString("Answer3");
		        		rec.Answer4=rs.getString("Answer4");
		        		rec.RightAnswer= rs.getInt("Right");
		        		aryLst.add(rec);
		  
		        	}
		        }
		        
			// Handle any errors that may have occurred.
		    	catch (Exception e) {
		    		e.printStackTrace();
		    	}

		   	finally 
		   	{
		    		if (rs != null) 
		    		try 
		    		{ 
		    			rs.close(); 
		    		} 
		    		catch(Exception e) 
		    		{
		    			
		    		}
		    		if (cstmt != null) 
		    			try 
		    		{ 
		    				cstmt.close(); 
		    		} 
		    		catch(Exception e) 
		    		{
		    			
		    		}
		    		if (con != null) 
		    		try 
		    		{ 
		    			con.close(); 
		    		} 
		    		catch(Exception e) 
		    		{
		    			
		    		}
		    	}
			return aryLst;
	}
	public int AddRecord(Record record)
	{
		 
	
		// TODO Auto-generated method stub

		 Connection con = null;
			CallableStatement cstmt = null;
			ResultSet rs = null;
			int x=-1;
			try 
			{
				// Establish the connection. 
				SQLServerDataSource ds = new SQLServerDataSource();
				ds.setIntegratedSecurity(true);
				ds.setServerName("localhost");
				ds.setPortNumber(1433); 
				ds.setDatabaseName("Scrum");
				con = ds.getConnection();
				 
		        	// Execute a stored procedure that returns some data.
	            		//cstmt = con.prepareCall("{call dbo.Select_All(?)}");
	            		cstmt = con.prepareCall("{call dbo.Add_Question(?,?,?,?,?,?,?)}");
	            		//cstmt.setInt(1, 50);
	            		cstmt.setString("p1", record.Question);
	            		cstmt.setString("p2", record.Answer1);
	            		cstmt.setString("p3", record.Answer2);
	            		cstmt.setString("p4", record.Answer3);
	            		cstmt.setString("p5", record.Answer4);
	            		cstmt.setInt("p6", record.RightAnswer);
	            		cstmt.registerOutParameter("questionID", java.sql.Types.INTEGER);
	            		rs = cstmt.executeQuery();
	            		x=cstmt.getInt("questionID");

			}
		        
			// Handle any errors that may have occurred.
		    	catch (Exception e) {
		    		e.printStackTrace();
		    	}

		   	finally 
		   	{
		    		if (rs != null) 
		    		try 
		    		{ 
		    			rs.close(); 
		    		} 
		    		catch(Exception e) 
		    		{
		    			
		    		}
		    		if (cstmt != null) 
		    			try 
		    		{ 
		    				cstmt.close(); 
		    		} 
		    		catch(Exception e) 
		    		{
		    			
		    		}
		    		if (con != null) 
		    		try 
		    		{ 
		    			con.close(); 
		    		} 
		    		catch(Exception e) 
		    		{
		    			
		    		}
		    	}
			return x;
	}
}
