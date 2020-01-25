package com.test_jdbctest;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import common.JDBCTemplate;

public class JDBCTEST_Insert extends JDBCTemplate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("번호 입력 : ");
		int no = sc.nextInt();

		System.out.println("이름 입력 : ");
		String name = sc.next();

		System.out.println("별명 입력 : ");
		String nickname = sc.next();
		///////////////////////////////////////////////////////

		// 1. driver 연결
		// 2. 계정 연결
		Connection con = getConnection();
		Statement stmt = null;
		int res = 0;

		// 3. 쿼리 준비
		String sql = " INSERT INTO JDBCTEST " + " VALUES(" + no + ",'" + name + "','" + nickname + "') ";
		stmt = con.createStatement();

		// 4. 실행 및 리턴
		res = stmt.executeUpdate(sql);
		if (res > 0) {
			System.out.println("insert 성공!!");
			commit(con);
		} else {
			System.out.println("insert 실패!!");
		}

		// 5. db 종료
		close(stmt);
		close(con);

		sc.close();
	}
}
