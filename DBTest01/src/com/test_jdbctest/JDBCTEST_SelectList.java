package com.test_jdbctest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.JDBCTemplate;

public class JDBCTEST_SelectList extends JDBCTemplate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. driver 연결
		// 2. 계정 연결
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		// 3. Query 준비
		String sql = " SELECT * FROM JDBCTEST "; // 복잡한 쿼리를 위해 앞 뒤를 띄어주자~!
		stmt = con.createStatement();
		
		// 4. 실행 및 리턴
		rs = stmt.executeQuery(sql);
		
		// 리턴받은 결겨괎을 console에 출력!
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}

		// 5. DB 종료
		close(rs);
		close(stmt);
		close(con);
	}
}
