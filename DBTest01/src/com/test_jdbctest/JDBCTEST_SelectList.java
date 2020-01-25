package com.test_jdbctest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.JDBCTemplate;

public class JDBCTEST_SelectList extends JDBCTemplate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. driver ����
		// 2. ���� ����
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		// 3. Query �غ�
		String sql = " SELECT * FROM JDBCTEST "; // ������ ������ ���� �� �ڸ� �������~!
		stmt = con.createStatement();
		
		// 4. ���� �� ����
		rs = stmt.executeQuery(sql);
		
		// ���Ϲ��� ��܁��� console�� ���!
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}

		// 5. DB ����
		close(rs);
		close(stmt);
		close(con);
	}
}
