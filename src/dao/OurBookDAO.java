package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.OurBook;



public class OurBookDAO {
	final String driver = "org.postgresql.Driver";
	final String URL= "jdbc:postgresql://localhost:5432/myapp";
    final String USER = "tiscuser";
	final String PASS = "userpass";

	Connection conn = null;
    PreparedStatement ps = null;
     ResultSet rs = null;

	public List<OurBook> oball(int account_id,int order){

		String sql1 = "select * from ourBOOK where ownner_id=? and visible=true order by ?;";
		List<OurBook> ourBooks = new ArrayList<>();
		OurBook ourBook=null;
		String ind=order==0?"id":"name";
		 try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			ps = conn.prepareStatement(sql1);
			ps.setInt(1,account_id);
			ps.setString(2,ind);
			rs = ps.executeQuery();
			while (rs.next()) {
				List<Book> books = new ArrayList<>();
				Book book=null;
				int ourBookId=rs.getInt("id");
				String ourBookName=rs.getString("name");
				String ourBookPass=rs.getString("pass");
				int ourBookOwner_id=rs.getInt("owner_id");
				//boolean visible =rs.getBoolean("visible");
				String sql2 ="select * from ourBOOK left join book_relation on ourBOOK.id = ourBook_id left join book on BOOK.id=book_id where ourbook.id=?;";
				ps = conn.prepareStatement(sql2);
		        ps.setInt(1,ourBookId);
		        rs = ps.executeQuery();
		        while (rs.next()) {
		        	if(rs.getBoolean("visible")) {
					book = new Book(rs.getInt("book_id"),rs.getString("title"),rs.getString("text"),rs.getDate("modified"),rs.getInt("auther_id"),true);
					books.add(book);
		        	}
				}
		        if(books.size()>0) {
				ourBook = new OurBook(ourBookId,ourBookName,ourBookPass,ourBookOwner_id,books,true);
				ourBooks.add(ourBook);}
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
		return ourBooks;
	}

	public OurBook obone(int id){
		String sql1 = "select * from ourBOOK where visible=true and id=?;";
		OurBook ourBook=null;
		 try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			ps = conn.prepareStatement(sql1);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			if (rs.next()) {
				List<Book> books = new ArrayList<>();
				Book book=null;
				//int ourBookId=rs.getInt("id");
				String ourBookName=rs.getString("name");
				String ourBookPass=rs.getString("pass");
				int ourBookOwner_id=rs.getInt("owner_id");
				//boolean visible =rs.getBoolean("visible");
				String sql2 ="select * from ourBOOK left join book_relation on ourBOOK.id = ourBook_id left join book on BOOK.id=book_id where ourBOOK.visible=true and ourbook.id=?;";
				ps = conn.prepareStatement(sql2);
		        ps.setInt(1,id);
		        rs = ps.executeQuery();
		        while (rs.next()) {
					book = new Book(rs.getInt("book_id"),rs.getString("title"),rs.getString("text"),rs.getDate("modified"),rs.getInt("auther_id"),rs.getBoolean("book.visible"));
					books.add(book);
				}
		        if(books.size()>0) {
				ourBook = new OurBook(id,ourBookName,ourBookPass,ourBookOwner_id,books,true);
		        }
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
		return ourBook;
	}

	public int obche(String name,String pass){

		String sql1 = "select * from ourBOOK where name=? and pass=?;";
		int id=0;
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			ps = conn.prepareStatement(sql1);
			ps.setString(1,name);
			ps.setString(2,pass);
			rs = ps.executeQuery();

			if (rs.next()) {
				id=rs.getInt("id");
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
		return id;
	}


	public int obins(String name,String pass,int owner_id){
		String sql1 = "select * from OURBOOK where name=? and pass=?;";
		String sql2 =  "insert into ourBOOK (name, pass,owner_id,visible) VALUES(?,?,?,true);";
		int id=0;
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
				conn.setAutoCommit(false);
				ps = conn.prepareStatement(sql1);
				ps.setString(1,name);
				ps.setString(2,pass);
	            rs = ps.executeQuery();
	          if(!rs.next()) {
					conn.setAutoCommit(false);
		            ps = conn.prepareStatement(sql2);
		            ps.setString(1,name);
		            ps.setString(2,pass);
		            ps.setInt(3,owner_id);
		            ps.executeUpdate();
		            ps = conn.prepareStatement(sql1);
					ps.setString(1,name);
					ps.setString(2,pass);
		            rs = ps.executeQuery();
		            id= rs.getInt("id");
		            }
				conn.commit();

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
		return id;
	}



	public boolean obdis(int ob_id){
		boolean bool=false;
		String sql =  "UPDATE ourbook SET visible=false  WHERE id=?;";
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
	        ps.setInt(1,ob_id);
	        int num=ps.executeUpdate();
	        if(num>0) {
	        	bool=true;
	        }
	        conn.commit();
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