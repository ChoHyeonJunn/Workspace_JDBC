package com.test_emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EMP_SelectList {

	// J DB C
	// 1. Driver ����
	// 2. ���� ����
	// 3. Query �غ�
	// 4. ���� �� ����
	// 5. DB ����

	// ojdbc6.jar �� �ڹٿ� ����Ŭ�� ������ �����ִ� ���̺귯��

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. Driver ����
		// ojdbc6.jar ���̺귯�� �߰� - oracle.jdbc.driver ��Ű�� - OracleDriver Ŭ����
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. ���� ����
		// Data Source Explorer - Database Connections - My Oracle - properties - Driver
		// Properties - Connection URL
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = DriverManager.getConnection(url, user, password);

		// 3. Query �غ�
		Statement stmt = con.createStatement();
		String sql = " SELECT * FROM EMP "; // ������ ������ ���� �� �ڸ� �������~!

		// 4. ���� �� ����
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " "
					+ rs.getDate(5) + " " + rs.getInt(6) + " " + rs.getInt(7) + " " + rs.getInt(8));
		}

		// 5. DB ����
		rs.close();
		stmt.close();
		con.close();
	}
}
