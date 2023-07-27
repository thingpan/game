package com.game.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public interface UserInfoDAO {
List<Map<String,String>> selectUserInfoList(Map<String,String>userInfo);
Map<String ,String >selectUserInfo(String uiNum);
Map<String ,String >selectUserInfoById(String uiId);
int insertUserInfo(Map<String,String>userInfo);
int updateUserInfo(Map<String,String>userInfo);
int deleteUserInfo(String uiNum);


}
