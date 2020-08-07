package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;




public class AccountDAO {
	final String driver = "org.postgresql.Driver";
	final String URL= "jdbc:postgresql://localhost:5432/myapp";
    final String USER = "tiscuser";
	final String PASS = "userpass";

	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

	public Account aone(Account account){
		String sql = "select * from ACCOUNT where name=? and pass =?;";

		Account naccount=null;
		 try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			ps = conn.prepareStatement(sql);
			ps.setString(1,account.getName());
	        ps.setString(2,account.getPass());
			rs = ps.executeQuery();
			if (rs.next()) {
				naccount = new Account(account);
				naccount.setId(rs.getInt("id"));
			}
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
			finally {
				try {
					if(rs != null)rs.close();
					if(ps != null)ps.close();
					if(conn != null)conn.close();
					}
			catch (SQLException e){
				e.printStackTrace();
				}
			}
		return naccount;
	}



	public boolean ains(Account account){

		boolean bool=false;
		String sql1 = "select * from ACCOUNT where name=?";
		String sql2 =  "insert into ACCOUNT (pass,name) VALUES(?,?);";
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			if(account!=null) {
				conn.setAutoCommit(false);

				ps = conn.prepareStatement(sql1);
				ps.setString(1,account.getName());
	            rs = ps.executeQuery();
	          //  System.out.println(rs.getInt("count"));
	            if(!rs.next()) {
	            	ps = conn.prepareStatement(sql2);
	            	ps.setString(1,account.getPass());
	            	ps.setString(2,account.getName());
	            	ps.executeUpdate();
	            	bool=true;
	            }
				conn.commit();
	            }
		    } catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		        e.printStackTrace();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }finally {
				try {
					if(rs != null)rs.close();
					if(ps != null)ps.close();
					if(conn != null)conn.close();
					}
			catch (SQLException e){

				e.printStackTrace();
				}
			}
		return bool;
	}


}