package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;



public class BookDAO {
	final String driver = "org.postgresql.Driver";
	final String URL= "jdbc:postgresql://localhost:5432/myapp";
    final String USER = "tiscuser";
	final String PASS = "userpass";

	Connection conn = null;
    PreparedStatement ps = null;
     ResultSet rs = null;

	public List<Book> ball(){
		String sql = "select * from BOOK where auther_id=? and visible=true order by title";
		List<Book> books = new ArrayList<>();
		Book book=null;
		 try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				book = new Book(rs.getInt("id"),rs.getString("title"),rs.getString("text"),rs.getDate("modified"),rs.getInt("auther_id"),rs.getBoolean("visible"));
				books.add(book);
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
		return books;
	}

	public Book bone(int id){
		String sql = "select * from BOOK where BOOK.id=? ;";
		Book book=null;
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			if (rs.next()) {
				book = new Book(rs.getInt("id"),rs.getString("title"),rs.getString("text"),rs.getDate("modified"),rs.getInt("auther_id"),rs.getBoolean("visible"));

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
		return book;
	}



	public int bins(Book book){
		String sql1 =  "insert into BOOK (title, text, modified,auther_id,visible) VALUES(?,?,?,?,?);";
		String sql2 ="SELECT last_value FROM book_id_seq;";
		int id=0;
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql1);
            ps.setString(1,book.getTitle());
            ps.setString(2,book.getText());
            ps.setDate(3,book.getModified());
            ps.setInt(4,book.getAuther_id());
            ps.setBoolean(5,book.getVisible());
            ps.executeUpdate();
            ps = conn.prepareStatement(sql2);
            rs=ps.executeQuery();
            if (rs.next()) {
            	id=rs.getInt("last_value");
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

	public Book bup(Book book){
		//String sql1 = "select * from BOOK where id<>? and title=? and auther_id=? and visible=true;";
		String sql =  "UPDATE BOOK SET title=?, text=?, modified=? WHERE id=?;";
		Book nbook =null;
		int id=book.getId();
		String title=book.getTitle();
		//int auther_id = book.getAuther_id();
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
//			if(book!=null) {
//				conn.setAutoCommit(false);
//				ps = conn.prepareStatement(sql1);
//				ps.setInt(1,id);
//				ps.setString(2,title);
//				ps.setInt(3,auther_id);
//	            rs = ps.executeQuery();
//	         if(!rs.next()) {
					conn.setAutoCommit(false);
		            ps = conn.prepareStatement(sql);
		            ps.setString(1,title);
		            ps.setString(2,book.getText());
		            ps.setDate(3,book.getModified());
		            ps.setInt(4,id);
		            ps.executeUpdate();

		          // }
				conn.commit();
				System.out.println(id+"pppp"+title);
				 nbook = new Book(book);
	           // }
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

					if(ps != null)ps.close();
					if(conn != null)conn.close();
					}
			catch (SQLException e){

				e.printStackTrace();
				}
			}
		return nbook;
	}

	public boolean bdis(int book_id){
		boolean bool=false;

		String sql =  "UPDATE BOOK SET visible=false  WHERE id=?;";

		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
	        ps.setInt(1,book_id);
	        ps.executeUpdate();
	        bool=true;
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