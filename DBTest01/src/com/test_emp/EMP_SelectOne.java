package com.test_emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EMP_SelectOne {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. Driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		Connection con = DriverManager.getConnection(url, user, password);

		// 3. Query 준비
		Scanner sc = new Scanner(System.in);
		System.out.println("EMPNO 입력 : ");
		int empno = sc.nextInt();

		PreparedStatement pstmt = null;
		String sql = " SELECT * " 
					+ " FROM EMP " 
					+ " WHERE EMPNO = ? ";

		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, empno);

		// 4. 실행 및 리턴
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " "
					+ rs.getDate(5) + " " + rs.getInt(6) + " " + rs.getInt(7) + " " + rs.getInt(8));
		}

		// 5. DB 종료
		rs.close();
		pstmt.close();
		con.close();

		sc.close();
	}
}
