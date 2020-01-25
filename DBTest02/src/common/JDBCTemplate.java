package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	// driver 연결, 계정 연결
	public static Connection getConnection() {

		// 1
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : JDBCTemplate.getCon.Driver");
			e.printStackTrace();
		}
		// 2
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("[Error] : JDBCTemplate.getCon.con");
			e.printStackTrace();
		}
		
		return con;
	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[Error] : JDBCTemplate.close(rs)");
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		// pstmt 는 stmt 를 상속받고 있어서 close(pstmt) 시 이 메서드가 실행됨!!
		try {
			stmt.close();
		} catch (SQLException e) {
			System.out.println("[Error] : JDBCTemplate.close(stmt)");
			e.printStackTrace();
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[Error] : JDBCTemplate.close(con)");
			e.printStackTrace();
		}
	}

	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[Error] : JDBCTemplate.commit(con)");
			e.printStackTrace();
		}
	}

	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[Error] : JDBCTemplate.rollback(con)");
			e.printStackTrace();
		}
	}
}
