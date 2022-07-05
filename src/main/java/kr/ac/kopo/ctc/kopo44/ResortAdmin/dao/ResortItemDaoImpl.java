package kr.ac.kopo.ctc.kopo44.ResortAdmin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.ac.kopo.ctc.kopo44.ResortAdmin.domain.ResortItem;

public class ResortItemDaoImpl implements ResortItemDao {

	public ResortItemDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("jdbc 드라이버 로드 실패");
		}
	}

	@Override
	public int createOne(ResortItem resortItem) {
		String sql = "INSERT INTO " + TABLE_NAME
				+ "(name, resv_date, room, addr, telnum, in_name, comment, write_date, processing) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result;

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, resortItem.getName());
			pstmt.setString(2, resortItem.getResv_date());
			pstmt.setInt(3, resortItem.getRoom());
			pstmt.setString(4, resortItem.getAddr());
			pstmt.setString(5, resortItem.getTelnum());
			pstmt.setString(6, resortItem.getIn_name());
			pstmt.setString(7, resortItem.getComment());
			pstmt.setString(8, resortItem.getWrite_date());
			pstmt.setInt(9, resortItem.getProcessing());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// e만 넣으면 hashcode가 나오므로 getMessage()를 붙여준다.
			throw new IllegalStateException("create  실패 " + e.getMessage());
		}
		return result;
	}

	@Override
	public ResortItem readOne(String inputResv_date, int room) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_RESV_DATE + "=? AND "+ COLUMN_ROOM +"=?";

		ResortItem resortItem = new ResortItem();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, inputResv_date);
			try (ResultSet rs = pstmt.executeQuery();) {

				rs.next();
				String name = rs.getString("name");
				String resv_date = rs.getString("resv_date");
				String addr = rs.getString("addr");
				String telnum = rs.getString("telnum");
				String in_name = rs.getString("in_name");
				String comment = rs.getString("comment");
				String write_date = rs.getString("write_date");
				int processing = rs.getInt("processing");

				resortItem.setName(name);
				resortItem.setResv_date(resv_date);
				resortItem.setRoom(room);
				resortItem.setAddr(addr);
				resortItem.setTelnum(telnum);
				resortItem.setIn_name(in_name);
				resortItem.setComment(comment);
				resortItem.setWrite_date(write_date);
				resortItem.setProcessing(processing);
			}

		} catch (SQLException e) {
			// e만 넣으면 hashcode가 나오므로 getMessage()를 붙여준다.
			throw new IllegalStateException("read 실패 " + e.getMessage());
		}
		return resortItem;
	}

	@Override
	public ResortItem updateOne(ResortItem resortItem) {
		String sql = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NAME + "=?, " + COLUMN_RESV_DATE + "=?, " + COLUMN_ROOM
				+ "=?, " + COLUMN_ADDR + "=?, " + COLUMN_TELNUM + "=?, " + COLUMN_IN_NAME + "=?, " + COLUMN_COMMENT
				+ "=?, " + COLUMN_DATE + "=?, " + COLUMN_PROCESSING + "=? WHERE id = ?";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, resortItem.getName());
			pstmt.setString(2, resortItem.getResv_date());
			pstmt.setInt(3, resortItem.getRoom());
			pstmt.setString(4, resortItem.getAddr());
			pstmt.setString(5, resortItem.getTelnum());
			pstmt.setString(6, resortItem.getIn_name());
			pstmt.setString(7, resortItem.getComment());
			pstmt.setString(8, resortItem.getWrite_date());
			pstmt.setInt(9, resortItem.getProcessing());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resortItem;
	}

	@Override
	public int deleteOne(String resv_date, int room) {
		String sql = "delete from " + TABLE_NAME + " WHERE "+ COLUMN_RESV_DATE+"=?, "+COLUMN_ROOM+"=?";
		int result = 0;

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, resv_date);
			pstmt.setInt(2, room);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}

		return result;
	}

}
