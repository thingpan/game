package com.game.mapper;

import java.util.List;

import com.game.vo.BoardInfovo;

public interface BoardInfoMapper {
	List<BoardInfovo>selectBoardInfoList (BoardInfovo bi);		
	BoardInfovo selectBoardInfo(BoardInfovo bi);
	int insertBoardInfo(BoardInfovo bi);
	int updateBoardInfo(BoardInfovo bi);
	int deleteBoardInfo(BoardInfovo bi);


}
