package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.Kind;


public class KindDAO {
	final String driver = "org.postgresql.Driver";
	final String URL= "jdbc:postgresql://localhost:5432/myapp";
    final String USER = "tiscuser";
	final String PASS = "userpass";

	Connection conn = null;
    PreparedStatement ps = null;
     ResultSet rs = null;

	public List<Kind> kall(int id){
		String sql = "select * from kind where account_id= ? order by kind_num;";
		List<Kind> myKinds = new ArrayList<>();
		Kind myKind=null;
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while (rs.next()) {
				myKind = new Kind(rs.getInt("kind_num"),rs.getInt("account_id"),rs.getString("kind_name"));
				myKinds.add(myKind);
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
		return myKinds;
	}

	public String kone(int account_id,int kind_num){
		String sql = "select kind_name from kind where account_id= ? and kind_num=?;";
		String str="";
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			ps = conn.prepareStatement(sql);
			ps.setInt(1,account_id);
			ps.setInt(2,kind_num);
			rs = ps.executeQuery();
			if (rs.next()) {
				str = rs.getString("kind_name");

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
		return str;
	}



	public List<Kind> kins(Account account){
		String sql = "insert into Kind (kind_num,account_id,kind_name) VALUES(?,?,?);";
		List<Kind> myKinds = new ArrayList<>();
		Kind myKind=null;
		int account_id=account.getId();
		String[] str= {"全てのテキスト","まとめ1","まとめ２","まとめ３","まとめ４","まとめ５"};

		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			conn.setAutoCommit(false);
			for(int i=0; i<str.length; i++) {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,i);
			ps.setInt(2,account_id);
			ps.setString(3,str[i]);
            ps.executeUpdate();
            myKind = new Kind(i,account_id,str[i]);
			myKinds.add(myKind);
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
		return myKinds;
	}

	public Kind kup(Kind kind){

		String sql = "UPDATE kind SET kind_name=? WHERE account_id =? and kind_num=?;";
		Kind nKind =null;
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(URL, USER, PASS);
			if(kind!=null) {
				conn.setAutoCommit(false);
		            ps = conn.prepareStatement(sql);
		            ps.setString(1,kind.getKind_name());
		            ps.setInt(2,kind.getAccount_id());
					ps.setInt(3,kind.getKind_num());

		            ps.executeUpdate();
		            nKind = new Kind(kind);
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
		return nKind;
	}


}