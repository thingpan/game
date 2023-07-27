package com.game.service.impl;

import java.util.List;
import java.util.Map;

import com.game.dao.BoardInfdoDao;
import com.game.dao.lmpl.BoardInfoImpl;
import com.game.service.BoardInfoService;

public class BoardInfoServiceImpl implements BoardInfoService {
	private BoardInfdoDao biDao = new BoardInfoImpl();
	@Override
	public List<Map<String, String>> selectboardInfoList(Map<String, String> boardInfo) {
		
		return biDao.selectboardInfoList(boardInfo);
		// TODO Auto-generated method stub
	   
	}

	@Override
	public Map<String, String> selectboardInfo(String biNum) {
		// TODO Auto-generated method stub
		return biDao.selectboardInfo(biNum);
	}

	@Override
	public int insertboardInfo(Map<String, String> boardInfo) {
		// TODO Auto-generated method stub
		return biDao.insertboardInfo(boardInfo);
	}

	@Override
	public int updateboardInfo(Map<String, String> boardInfo) {
		// TODO Auto-generated method stub
		return biDao.updateboardInfo(boardInfo);
	}

	@Override
	public int deleteboardInfo(String biNum) {
		// TODO Auto-generated method stub
		return biDao.deleteboardInfo(biNum);
	}

}
