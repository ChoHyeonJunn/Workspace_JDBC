package com.test_jdbctest;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import common.JDBCTemplate;

public class JDBCTEST_Insert extends JDBCTemplate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("��ȣ �Է� : ");
		int no = sc.nextInt();

		System.out.println("�̸� �Է� : ");
		String name = sc.next();

		System.out.println("���� �Է� : ");
		String nickname = sc.next();
		///////////////////////////////////////////////////////

		// 1. driver ����
		// 2. ���� ����
		Connection con = getConnection();
		Statement stmt = null;
		int res = 0;

		// 3. ���� �غ�
		String sql = " INSERT INTO JDBCTEST " + " VALUES(" + no + ",'" + name + "','" + nickname + "') ";
		stmt = con.createStatement();

		// 4. ���� �� ����
		res = stmt.executeUpdate(sql);
		if (res > 0) {
			System.out.println("insert ����!!");
			commit(con);
		} else {
			System.out.println("insert ����!!");
		}

		// 5. db ����
		close(stmt);
		close(con);

		sc.close();
	}
}
