package PhysicalDBLayer;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class ScrumCertificateDatabase
{
	private databaseConsts _databaseConsts=null;
	public void SetDBConstantst(databaseConsts dbConsts)
	{
		 _databaseConsts=dbConsts;
	}
	public ArrayList<ScrumCertificateRecord> GetList()
	{
		 ArrayList<ScrumCertificateRecord> aryLst = new ArrayList<ScrumCertificateRecord>();
		 
	
		// TODO Auto-generated method stub

		 Connection con = null;
			CallableStatement cstmt = null;
			ResultSet rs = null;
			
			try 
			{
				// Establish the connection. 
				SQLServerDataSource ds = new SQLServerDataSource();
				ds.setIntegratedSecurity(true);
				//ds.setServerName("localhost");
				//ds.setPortNumber(1433); 
				//ds.setDatabaseName("Scrum");
				ds.setServerName(_databaseConsts.ServerName);
				ds.setPortNumber(_databaseConsts.PortNumber); 
				ds.setDatabaseName(_databaseConsts.DatabaseName);
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
		        		ScrumCertificateRecord rec=new ScrumCertificateRecord();
		        		rec.Question=rs.getString("question");
		        		rec._Answers.add(rs.getString("Answer1"));
		        		rec._Answers.add(rs.getString("Answer2"));
		        		rec._Answers.add( rs.getString("Answer3"));
		        		rec._Answers.add(rs.getString("Answer4"));
		        		rec.RightAnswer= rs.getInt("Right");
		        		rec.Answer=rec._Answers.get(rec.RightAnswer-1);
		        		aryLst.add(rec);
		  
		        	}
		        }
		        
			// Handle any errors that may have occurred.
		    	catch (Exception e) 
			{
		    		e.printStackTrace();
		    		JOptionPane.showMessageDialog(null,e.getMessage());
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
	public int AddRecord(ScrumCertificateRecord record)
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
	            		cstmt.setString("p2", record._Answers.get(0));
	            		cstmt.setString("p3", record._Answers.get(1));
	            		cstmt.setString("p4", record._Answers.get(2));
	            		cstmt.setString("p5", record._Answers.get(3));
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
