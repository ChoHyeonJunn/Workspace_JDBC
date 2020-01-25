package com.test_jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import common.JDBCTemplate;

public class JDBCTEST_Update extends JDBCTemplate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("수정할 번호 : ");
		int no = sc.nextInt();

		System.out.println("수정할 이름 : ");
		String name = sc.next();

		System.out.println("수정할 별명 : ");
		String nickName = sc.next();
		///////////////////////////////////////////////////////

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = " UPDATE JDBCTEST SET NAME = ?, NICKNAME = ? " + " WHERE NO = ? ";

		try {
			// sql 을 미리 가지고 있는다!! -> free complied
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, nickName);
			pstmt.setInt(3, no);

			res = pstmt.executeUpdate();

			if (res > 0) {
				System.out.println("Update 성공!!");
				commit(con);
			} else {
				System.out.println("0 rows updated;;;");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}

	}
}
