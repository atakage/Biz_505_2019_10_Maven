package com.biz.hello;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.biz.hello.config.DBConnection;
import com.biz.hello.dao.ScoreDao;
import com.biz.hello.persistence.ScoreDTO;

public class ScoreEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SqlSession sqlSession = DBConnection.getSqlSessionFactory().openSession(true);
		ScoreDao dao = sqlSession.getMapper(ScoreDao.class);
				List<ScoreDTO> scoreList = dao.selectAll();
				
				
				for(ScoreDTO dto : scoreList) {
					
					System.out.println(dto.toString());
				}

	}

}
