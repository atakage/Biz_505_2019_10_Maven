package com.biz.sec.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConnection {

	private static SqlSessionFactory sqlSessionFactory = null;

	static {

		String configFile = "com/biz/config/mybatis-config.xml";
		InputStream is = null;
		Properties pros = new Properties();	// 어떤 setting값들을 모아 어떤 설정을 하는 용도로 사용
											// setting ㄱ밧들을 쉽게 관리할 수 있도록 도와줌
		
		
		
		pros.put("username", "USERNAME");	//DBMS에 접근할 username과 password를 실제 값으로 적용하고
		pros.put("password", "PASSWORD");	// 프로젝트를 실행

		try {
			is = Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

			if (sqlSessionFactory == null) {
				sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}
