package com.biz.sec.exec;

import com.biz.sec.config.DBConnection;
import com.biz.sec.config.DBConnectionSEC;
import com.biz.sec.mapper.IolistDao;

public class IolistEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBConnectionSEC.getSqlSessionFactory().openSession(true);	//mybatis-config.xml, DBConn 클래스, iolist-mapper.xml 테스트 코드
		
		
		System.out.println("Test OK");
		

	}

}
