package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;

public class UserInfoDAOImpl implements UserInfoDAO {

	
	
	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		// TODO Auto-generated method stub
		String sql ="SELECT UI_NUM,UI_NAME,UI_ID,UI_PWD,UI_IMG_PATH,UI_DESC,\r\n"
				+ "UI_BIRTH,CREDAT,CRETIM,LMODAT,LMOTIM \r\n"
				+ ",ACTIVE FROM USER_INFO";
		List<Map<String,String>> userInfolist =new ArrayList<>();
		try(Connection con =DBCon.getCon()){
			try(PreparedStatement ps =con.prepareStatement(sql)){
				try(ResultSet rs=ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> ui =new HashMap<>();
						ui.put("uiNum",rs.getString("UI_NUM"));
						ui.put("uiName", rs.getString("UI_NAME"));
						ui.put("uiId", rs.getString("UI_ID"));
						ui.put("uiPwd", rs.getString("UI_PWD"));
						ui.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						ui.put("uiDesc", rs.getString("UI_DESC"));
						ui.put("uiBirth", rs.getString("UI_BIRTH"));
						ui.put("credat", rs.getString("CREDAT"));
						ui.put("cretim", rs.getString("CRETIM"));
						ui.put("lmodat", rs.getString("LMODAT"));
						ui.put("lmotim", rs.getString("LMOTIM"));
						ui.put("active", rs.getString("ACTIVE"));
						userInfolist.add(ui);
					}
				}
					
				}
				
			}catch(Exception e) {
		}
		
		
		return userInfolist;
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {
			// TODO Auto-generated method stub
			String sql ="SELECT UI_NUM,UI_NAME,UI_ID,UI_PWD,UI_IMG_PATH,UI_DESC,\r\n"
					+ "UI_BIRTH,CREDAT,CRETIM,LMODAT,LMOTIM \r\n"
					+ ",ACTIVE FROM USER_INFO\r\n"
			         +"WHERE UI_NUM=?";
			try(Connection con =DBCon.getCon()){
				try(PreparedStatement ps =con.prepareStatement(sql)){
					ps.setString(1, uiNum);
					try(ResultSet rs=ps.executeQuery()){
						while(rs.next()) {
							Map<String,String> ui =new HashMap<>();
							ui.put("uiNum",rs.getString("UI_NUM"));
							ui.put("uiName", rs.getString("UI_NAME"));
							ui.put("uiId", rs.getString("UI_ID"));
							ui.put("uiPwd", rs.getString("UI_PWD"));
							ui.put("uiImgPath", rs.getString("UI_IMG_PATH"));
							ui.put("uiDesc", rs.getString("UI_DESC"));
							ui.put("uiBirth", rs.getString("UI_BIRTH"));
							ui.put("credat", rs.getString("CREDAT"));
							ui.put("cretim", rs.getString("CRETIM"));
							ui.put("lmodat", rs.getString("LMODAT"));
							ui.put("lmotim", rs.getString("LMOTIM"));
							ui.put("active", rs.getString("ACTIVE"));
							return ui;
						}
					}
						
					}
					
				}catch(Exception e) {
			}
			
			
			return null;
		}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		// TODO Auto-generated method stub
		String sql ="\r\n"
				+ "INSERT INTO user_info(UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, \r\n"
				+ "UI_DESC, UI_BIRTH, CREDAT ,CRETIM, LMODAT, LMOTIM)\r\n"
				+ "VALUES(?,?,?,?,?,\r\n"
				+ " ?, DATE_FORMAT(NOW(),'%Y%m%d'), \r\n"
				+ "DATE_FORMAT(NOW(),'%H%i%s'),\r\n"
				+ "DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "DATE_FORMAT(NOW(),'%H%i%s'));";
		try(Connection con =DBCon.getCon()){
			try(PreparedStatement ps =con.prepareStatement(sql)){
				ps.setString(1,userInfo.get("uiName"));
				ps.setString(2,userInfo.get("uiId"));
				ps.setString(3,userInfo.get("uiPwd"));
				ps.setString(4,userInfo.get("uilmgPath"));
				ps.setString(5,userInfo.get("uiDesc"));
				ps.setString(6,userInfo.get("uiBirth"));
				return ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		// TODO Auto-generated method stub
		String sql = "UPDATE USER_INFO\r\n"
				+ "SET UI_NAME=?,\r\n"
				+ "UI_PWD=?,\r\n"
				+ "UI_IMG_PATH=?,\r\n"
				+ "UI_DESC=?,\r\n"
				+ "UI_BIRTH=?,\r\n"
				+ "LMODAT=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "LMOTIM=DATE_FORMAT(NOW(),'%H%i%s')\r\n"
				+ "WHERE UI_NUM=?";
		try(Connection con =DBCon.getCon()){
			try(PreparedStatement ps =con.prepareStatement(sql)){
				ps.setString(1,userInfo.get("uiName"));
				ps.setString(2,userInfo.get("uiPwd"));
				ps.setString(3,userInfo.get("uilmgPath"));
				ps.setString(4,userInfo.get("uiDesc"));
				ps.setString(5,userInfo.get("uiBirth"));
				ps.setString(6,userInfo.get("uiNum"));
				return ps.executeUpdate();
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
		return 0;
	}

	@Override
	public int deleteUserInfo(Map<String, String> userInfo) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM user_info WHERE UI_NUM=?";
		try(Connection con =DBCon.getCon()){
			try(PreparedStatement ps =con.prepareStatement(sql)){
				ps.setString(1,userInfo.get("uiNum"));
					return ps.executeUpdate();
			}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
		return 0;
	}
public static void main(String[] args) {
	UserInfoDAOImpl uRepo=new UserInfoDAOImpl();
	System.out.println(uRepo.selectUserInfoList(null));
	System.out.println(uRepo. selectUserInfo("1"));
	Map<String,String> user =new HashMap();
	user.put("uiName","이");
	user.put("uiId","hhh");
	user.put("uiPwd","qws");
	user.put("uiImgPath","rq");
	user.put("uiDesc","rr");
	user.put("uiBirth","NULL");
	user.put("uiNum","1");
	System.out.println(uRepo.deleteUserInfo(user));
	
}


}