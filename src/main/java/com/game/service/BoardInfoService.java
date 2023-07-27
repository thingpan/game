package com.game.service;

import java.util.List;
import java.util.Map;

public interface BoardInfoService {
	List<Map<String,String>> selectboardInfoList(Map<String,String>boardInfo);
	Map<String ,String >selectboardInfo(String biNum);

	int insertboardInfo(Map<String,String>boardInfo);
	int updateboardInfo(Map<String,String>boardInfo);
	int deleteboardInfo(String biNum);
}
