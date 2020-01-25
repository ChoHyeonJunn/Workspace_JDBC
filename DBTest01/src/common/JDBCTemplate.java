package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// driver 연결
// 계정 연결

// db 종료
// commit / rollback

// Singleton 패턴 && static 으로 메모리 낭비 방지!!
public class JDBCTemplate {

	// 1. driver 연결
	// 2. 계정 연결
	public static Connection getConnection() {
		// 1.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] : JDBCTemplate.Driver");
			e.printStackTrace();
		}

		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = null;
		try {

			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);

		} catch (SQLException e) {
			System.out.println("[Error] : JDBCTemplate.getConnection");
			e.printStackTrace();
		}

		return con;
	}
	
	// 5. DB 종료
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("[Error] : JDBCTemplate.close(rs)");
			e.printStackTrace();
		}
	}

	// 5. DB 종료
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			System.out.println("[Error] : JDBCTemplate.close(stmt)");
			e.printStackTrace();
		}
	}

	// 5. DB 종료
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("[Error] : JDBCTemplate.close(con)");
			e.printStackTrace();
		}
	}

	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			System.out.println("[Error] : JDBCTemplate.commit(con)");
			e.printStackTrace();
		}
	}

	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			System.out.println("[Error] : JDBCTemplate.rollback(con)");
			e.printStackTrace();
		}
	}
}
