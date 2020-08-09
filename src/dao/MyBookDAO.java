package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MyBook;


public class MyBookDAO {
	final String driver = "org.postgresql.Driver";
	final String URL= "jdbc:postgresql://localhost:5432/myapp";
    final String USER = "tiscuser";
	final String PASS = "userpass";

	Connection conn = null;
    PreparedStatement ps = null;
     ResultSet rs = null;

	public List<MyBook> mball(int account_id,int kind){
		String sql;
		if(kind>0) {
		sql= "select * from MYBOOK where account_id= ? and kind_num=?  ;";
		}else {
		sql= "select * from MYBOOK where  account_id= ? ;";
		}
		ArrayList<MyBook> myBooks = new ArrayList<>();
		MyBook myBook=null;
		 try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			ps = conn.prepareStatement(sql);
			ps.setInt(1,account_id);
			if(kind>0) {
			ps.setInt(2,kind);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				myBook = new MyBook(rs.getInt("id"),rs.getInt("account_id"),rs.getInt("book_id"),rs.getString("title"),rs.getString("text"),rs.getBoolean("favorite"),rs.getInt("kind_num"),rs.getDate("modified"));
				myBooks.add(myBook);
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
		return myBooks;
	}


	public MyBook mbone(int id){
		String sql = "select * from myBOOK where id=?;";
		MyBook myBook=null;
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			if (rs.next()) {
			   myBook = new MyBook(rs.getInt("id"),rs.getInt("account_id"),rs.getInt("book_id"),rs.getString("title"),rs.getString("text"),rs.getBoolean("favorite"),rs.getInt("kind_num"),rs.getDate("modified"));
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
		return myBook;
	}


	public MyBook mbins(MyBook myBook){

		//String sql1 = "select * from myBOOK where title=? and account_id=?;";
		String sql1 = "insert into myBOOK (account_id,book_id,title, text, modified,favorite,kind_num) VALUES(?,?,?,?,?,?,?);";
		String sql2 ="SELECT last_value FROM mybook_id_seq;";
		MyBook nMybook =null;
		//int id = myBook.getId();
		//String title=myBook.getTitle();
		//int account_id = myBook.getAccount_id();
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			if(myBook!=null) {
//				 int cnt=0;
//				String ntitle=title;
//				ps = conn.prepareStatement(sql1);
//	         do{
//	        	 ntitle=title+"("+cnt+")";
//					//ps.setInt(1,id);
//					ps.setString(1,ntitle);
//					ps.setInt(2,account_id);
//		            rs = ps.executeQuery();
//
//		            cnt++;
//
//		          //  System.out.println(ntitle);
//
//	         }while(rs.next());
//
//	        	 myBook.setTitle(ntitle);
//
//	         System.out.println(myBook.getTitle());
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql1);
			ps.setInt(1,myBook.getAccount_id());
			ps.setInt(2,myBook.getBook_id());
			ps.setString(3,myBook.getTitle());
			ps.setString(4,myBook.getText());
            ps.setDate(5,myBook.getModified());
            ps.setBoolean(6,myBook.getFavorite());
            ps.setInt(7,myBook.getKind_num());
            ps.executeUpdate();
			conn.commit();
			ps = conn.prepareStatement(sql2);
			rs=ps.executeQuery();
            if (rs.next()) {
            	myBook.setId(rs.getInt("last_value"));
            }

		     nMybook = new MyBook(myBook);
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
		return nMybook;
	}

	public MyBook mbup(MyBook myBook){

		String sql1 = "select * from mybook where id<>? and title=? and account_id=?;";
		String sql2 =  "UPDATE myBOOK SET title=?, text=?, modified=?,favorite=?,kind_num=? WHERE id=?;";
		MyBook nMybook =null;
		int id = myBook.getId();
		String title=myBook.getTitle();
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			if(myBook!=null) {
				 int cnt=-1;
				String ntitle=title;
	         do{
	        	 	ps = conn.prepareStatement(sql1);
					ps.setInt(1,id);
					ps.setString(2,title);
					ps.setInt(3,myBook.getAccount_id());
		            rs = ps.executeQuery();
		            ntitle=title+"("+cnt+")";
		            cnt++;
	         }while(rs.next());
	         if(cnt>0) {
	        	 myBook.setTitle(ntitle);
	         };
					conn.setAutoCommit(false);
		            ps = conn.prepareStatement(sql2);
		            ps.setString(1,myBook.getTitle());
					ps.setString(2,myBook.getText());
		            ps.setDate(3,myBook.getModified());
		            ps.setBoolean(4,myBook.getFavorite());
		            ps.setInt(5,myBook.getKind_num());
		            ps.setInt(6,id);
		            ps.executeUpdate();
		            nMybook = new MyBook(myBook);
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
		return nMybook;
	}

	public boolean mbcha(int id,int num){
		String sql =  "UPDATE myBOOK SET kind_num=? WHERE id=?;";
		boolean bool=false;
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setInt(1,num);
            ps.setInt(2,id);
            ps.executeUpdate();
            conn.commit();
            bool=true;
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

	public boolean mbcha(int id,boolean like){
		String sql =  "UPDATE myBOOK SET favorite=? WHERE id=?;";
		boolean bool=false;
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1,like);
            ps.setInt(2,id);
            ps.executeUpdate();
            conn.commit();
            bool=true;
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

	public boolean mbdel(int myBook_id){
		boolean bool=false;
		String sql =  "DELETE FROM myBOOK WHERE id = ?;";

		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
	        ps.setInt(1,myBook_id);
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