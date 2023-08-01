package com.game.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.game.mapper.BoardInfoMapper;
import com.game.vo.BoardInfovo;

public class MybatisSqlSessionFactory {

	private static SqlSessionFactory SSF;
	private final static String CONFIG_PATH = "config/mybatis-config.xml";
	static {
		try {
			InputStream is = Resources.getResourceAsStream(CONFIG_PATH);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SSF = ssfb.build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return SSF;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SqlSessionFactory ssf = getSqlSessionFactory();
		try {
			SqlSession session = ssf.openSession(true);
			BoardInfoMapper biMapper = session.getMapper(BoardInfoMapper.class);
			BoardInfovo bi = new BoardInfovo();
			System.out.println(biMapper.selectBoardInfoList(bi));

			bi.setBiNum(3);
			System.out.println(biMapper.selectBoardInfo(bi));

			bi.setBiTitle("asdsada");
			bi.setBiContent("asss");
			bi.setUiNum(1);
			System.out.println(biMapper.insertBoardInfo(bi));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
