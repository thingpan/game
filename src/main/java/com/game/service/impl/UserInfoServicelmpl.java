package com.game.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.dao.impl.UserInfoDAO;
import com.game.dao.impl.UserInfoDAOImpl;
import com.game.service.UserInfoService;

public class UserInfoServicelmpl implements UserInfoService {
    private UserInfoDAO uiDAO =new UserInfoDAOImpl();
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
	public boolean login(Map<String, String> userInfo, HttpSession session) {
		// TODO Auto-generated method stub
		String uiId=userInfo.get("uiId");
		Map<String,String>tmp =uiDAO.selectUserInfo(uiId);
		if(tmp!=null) {
			String uiPwd =tmp.get("uiPwd");
			if(uiPwd.equals(userInfo.get("uiPwd"))) {
				session.setAttribute("user", tmp);
				return true;
			}
		}
		return false;
	}

}
