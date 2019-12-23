package com.biz.sec.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBConnectionSEC {

	private static SqlSessionFactory sqlSessionFactory = null;

	static {
		
		Map<String, String> envList = System.getenv();	// 전체 환경변수 읽어오기
		
		String saltPass = System.getenv().get("BIZ");	// 전체 환경변수 중 BIZ 키 변숫값 추출
		saltPass = System.getenv("BIZ");	// 환경변수 중 BIZ 키 값만 가져오기
		
		

		String configFile = "com/biz/sec/config/mybatis-config.xml";
		InputStream is = null;
		
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		
		String userName = "DiTIVOkC4Qjc8nqu7ZLrEQ==";
		String password = "/auX6YvOIRTqBxipbca8wA==";
		
		
		Properties pros = new Properties();	// 어떤 setting값들을 모아 어떤 설정을 하는 용도로 사용
											// setting ㄱ밧들을 쉽게 관리할 수 있도록 도와줌
		
		pros.put("username", pbEnc.decrypt(userName));
		pros.put("password", pbEnc.decrypt(password));

		
		
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
