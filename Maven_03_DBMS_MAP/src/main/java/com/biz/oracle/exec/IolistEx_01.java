package com.biz.oracle.exec;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.biz.config.DBConnection;
import com.biz.oracle.mapper.IolistDao;

public class IolistEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SqlSession sqlSession = DBConnection.getSqlSessionFactory().openSession(true);
		
		
		IolistDao iolistDao = sqlSession.getMapper(IolistDao.class);

	}

}
