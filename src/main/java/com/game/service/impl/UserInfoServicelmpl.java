package com.game.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.dao.UserInfoDAO;
import com.game.dao.lmpl.UserInfoDAOImpl;
import com.game.service.UserInfoService;

public class UserInfoServicelmpl implements UserInfoService {
	private UserInfoDAO uiDAO = new UserInfoDAOImpl();

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		// TODO Auto-generated method stub
		return uiDAO.selectUserInfoList(userInfo);
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {
		// TODO Auto-generated method stub
		return uiDAO.selectUserInfo(uiNum);
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		// TODO Auto-generated method stub
		return uiDAO.insertUserInfo(userInfo);
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		// TODO Auto-generated method stub
		return uiDAO.updateUserInfo(userInfo);
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		// TODO Auto-generated method stub
		return uiDAO.deleteUserInfo(uiNum);
	}

	@Override
	public Map<String, String> login(String uiId) {
		return uiDAO.selectUserInfoById(uiId);
	}
}