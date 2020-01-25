package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.DTO;

import common.JDBCTemplate;

// DAO = Data Access Object

public class DAO extends JDBCTemplate {

	// ��ü ���
	public List<DTO> selectList() {
		List<DTO> list = new ArrayList<DTO>();

		// 1. driver ����
		// 2. ���� ����
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT NO, NAME, NICKNAME FROM MYTEST ";

		try {
			// 3. query �غ�
			stmt = con.createStatement();
			// 4. ���� �� ����
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				DTO dto = new DTO();

				dto.setNO(rs.getInt("NO"));
				dto.setNAME(rs.getString("NAME"));
				dto.setNICKNAME(rs.getString("NICKNAME"));

				list.add(dto);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// 5. db ����
			close(rs);
			close(stmt);
			close(con);
		}

		return list;
	}

	// ���� ���
	public DTO selectOne(int no) {
		DTO dto = new DTO();

		// 1. driver ����
		// 2. ���� ����
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT NO, NAME, NICKNAME FROM MYTEST " + " WHERE NO = " + no;

		try {
			// 3. query �غ�
			stmt = con.createStatement();
			// 4. ���� �� ����
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				dto.setNO(rs.getInt("NO"));
				dto.setNAME(rs.getString("NAME"));
				dto.setNICKNAME(rs.getString("NICKNAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. db ����
			close(rs);
			close(stmt);
			close(con);
		}

		return dto;
	}

	// �߰�
	public int insert(DTO dto) {
		// 1. driver ����
		// 2. ���� ����
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		String sql = " INSERT INTO MYTEST VALUES(SEQ_MYTEST_NO.NEXTVAL,?,?)";

		try {
			// 3. query �غ�
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getNAME());
			pstmt.setString(2, dto.getNICKNAME());

			// 4. ���� �� ����
			res = pstmt.executeUpdate();
			if (res > 0)
				commit(con);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. db ����
			close(pstmt);
			close(con);
		}

		return res;
	}

	// ����
	public int update(DTO dto) {
		// 1. driver ����
		// 2. ���� ����
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		String sql = " UPDATE MYTEST " + " SET NAME = ?, NICKNAME = ? " + " WHERE NO = ?";

		try {
			// 3. query �غ�
			pstmt = con.prepareStatement(sql);
			// 4. ���� �� ����
			pstmt.setString(1, dto.getNAME());
			pstmt.setString(2, dto.getNICKNAME());
			pstmt.setInt(3, dto.getNO());

			res = pstmt.executeUpdate();

			if (res > 0)
				commit(con);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. db ����
			close(pstmt);
			close(con);
		}

		return res;
	}

	// ����
	public int delete(int no) {
		// 1. driver ����
		// 2. ���� ����
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		String sql = " DELETE FROM MYTEST WHERE NO = ?";

		try {
			// 3. query �غ�
			pstmt = con.prepareStatement(sql);
			// 4. ���� �� ����
			pstmt.setInt(1, no);

			res = pstmt.executeUpdate();

			if (res > 0)
				commit(con);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. db ����
			close(pstmt);
			close(con);
		}

		return res;
	}
}
