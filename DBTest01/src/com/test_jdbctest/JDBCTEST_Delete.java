package com.test_jdbctest;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTEST_Delete {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 번호 : ");
		int no = sc.nextInt();

		Connection con = getConnection();
		Statement stmt = null;
		int res = 0;
		String sql = " DELETE FROM JDBCTEST WHERE NO = " + no;

		try {
			stmt = con.createStatement();
			res = stmt.executeUpdate(sql);

			if (res > 0) {
				System.out.println("삭제 성공!!");
				commit(con);
			} else {
				System.out.println("0개의 row가 삭제됨;;");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(con);
			sc.close();
		}

	}
}
