package com.game.dao.lmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.dao.BoardInfdoDao;
import com.game.common.DBCon;

public class BoardInfoImpl implements BoardInfdoDao {

	@Override
	public List<Map<String, String>> selectboardInfoList(Map<String, String> boardInfo) {
		// TODO Auto-generated method stub
		List<Map<String, String>> boardInfoList = new ArrayList<Map<String, String>>();
		String sql = "SELECT BI.*,UI.UI_NAME FROM board_info BI\r\n" + "INNER JOIN user_info UI\r\n"
				+ "ON BI.UI_NUM =UI.UI_NUM WHERE 1=1 ";
		if (boardInfo != null) {
			String key = boardInfo.get("key");

			if ("1".equals(key)) {
				sql += "AND BI_TITLE LIKE CONCAT('%',?,'%')";
			} else if ("2".equals(key)) {
				sql += "AND UI_NAME LIKE CONCAT('%',?,'%')";
			} else if ("3".equals(key)) {
				sql += "AND BI_CONTENT LIKE CONCAT('%',?,'%')";
			} else if ("4".equals(key)) {
				sql += " AND (BI_TITLE LIKE CONCAT('%',?,'%')";
				sql += " OR BI_CONTENT LIKE CONCAT('%',?,'%'))";
			} else if ("5".equals(key)) {
				sql += "AND (UI_NAME LIKE CONCAT('%',?,'%')";
				sql += " OR BI_CONTENT LIKE CONCAT('%',?,'%'))";
			} else if ("6".equals(key)) {
				sql += "AND (UI_NAME LIKE CONCAT('%',?,'%')";
				sql += " OR BI_TITLE LIKE CONCAT('%',?,'%'))";
			} else if ("7".equals(key)) {
				sql += "AND (BI_TITLE LIKE CONCAT('%',?,'%')";
				sql += " OR UI_NAME LIKE CONCAT('%',?,'%')";
				sql += " OR BI_CONTENT LIKE CONCAT('%',?,'%'))";
			}

		}
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				if (boardInfo != null) {
					String key = boardInfo.get("key");
					if ("1".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
					} else if ("1".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
					} else if ("2".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
					} else if ("3".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
					} else if ("4".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
						ps.setString(2, boardInfo.get("value"));
					} else if ("4".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
						ps.setString(2, boardInfo.get("value"));
					} else if ("5".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
						ps.setString(2, boardInfo.get("value"));
					} else if ("6".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
						ps.setString(2, boardInfo.get("value"));
					} else if ("7".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
						ps.setString(2, boardInfo.get("value"));
						ps.setString(3, boardInfo.get("value"));
					}
				}
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> ui = new HashMap<>();
						ui.put("biNum", rs.getString("BI_NUM"));
						ui.put("biTitle", rs.getString("BI_TITLE"));
						ui.put("biContent", rs.getString("BI_CONTENT"));
						ui.put("uiNum", rs.getString("UI_NUM"));
						ui.put("uiName", rs.getString("UI_NAME"));
						ui.put("credat", rs.getString("CREDAT"));
						ui.put("cretim", rs.getString("CRETIM"));
						ui.put("lmodat", rs.getString("LMODAT"));
						ui.put("lmotim", rs.getString("LMOTIM"));
						ui.put("active", rs.getString("ACTIVE"));
						boardInfoList.add(ui);

					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return boardInfoList;
	}

	@Override
	public Map<String, String> selectboardInfo(String biNum) {

		String sql = "SELECT * FROM board_info WHERE BI_NUM=?";
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, biNum);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> ui = new HashMap<>();
						ui.put("biNum", rs.getString("BI_NUM"));
						ui.put("biTitle", rs.getString("BI_TITLE"));
						ui.put("biContent", rs.getString("BI_CONTENT"));
						ui.put("uiNum", rs.getString("UI_NUM"));
						ui.put("credat", rs.getString("CREDAT"));
						ui.put("cretim", rs.getString("CRETIM"));
						ui.put("lmodat", rs.getString("LMODAT"));
						ui.put("lmotim", rs.getString("LMOTIM"));
						ui.put("active", rs.getString("ACTIVE"));
						return ui;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int insertboardInfo(Map<String, String> boardInfo) {

		String sql = "INSERT INTO board_info(BI_TITLE,BI_CONTENT,UI_NUM,CREDAT,CRETIM,LMODAT,LMOTIM)\r\n"
				+ "VALUES(?,?,?, DATE_FORMAT(NOW(),'%Y%m%d'),\r\n" + "DATE_FORMAT(NOW(),'%H%i%s'),\r\n"
				+ "DATE_FORMAT(NOW(),'%Y%m%d'),\r\n" + "DATE_FORMAT(NOW(),'%H%i%s'))";
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, boardInfo.get("biTitle"));
				ps.setString(2, boardInfo.get("biContent"));
				ps.setString(3, boardInfo.get("uiNum"));
				return ps.executeUpdate();
			}

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateboardInfo(Map<String, String> boardInfo) {

		String sql = "UPDATE board_info\r\n" + "SET BI_TITLE =?,\r\n" + "BI_CONTENT =?,\r\n" + "UI_NUM=?,\r\n"
				+ "LMODAT=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n" + "LMOTIM=DATE_FORMAT(NOW(),'%H%i%s')\r\n"
				+ "WHERE BI_NUM=?";
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, boardInfo.get("biTitle"));
				ps.setString(2, boardInfo.get("biContent"));
				ps.setString(3, boardInfo.get("uiNum"));
				ps.setString(4, boardInfo.get("biNum"));
				return ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteboardInfo(String biNum) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM board_info WHERE BI_NUM=?";
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, biNum);
				return ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
		BoardInfdoDao biDao = new BoardInfoImpl();
		Map<String, String> map = new HashMap<>();
		map.put("biTitle", "test");
		map.put("biContent", "test");
		map.put("uiNum", "1");
		int result = biDao.insertboardInfo(map);
		System.out.println("결과:" + result);
		System.out.print(biDao.selectboardInfoList(null));
		System.out.print(biDao.selectboardInfo("3"));

	}

}
