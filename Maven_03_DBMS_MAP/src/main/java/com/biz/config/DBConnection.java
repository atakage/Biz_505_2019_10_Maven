package com.biz.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBConnection {

	public static SqlSessionFactory sqlSessionFactory = null;

	static {

		String configFile = "com/biz/config/mybatis-config.xml";

		InputStream is = null;
		
		String encType = "PBEWithMD5AndDES";
		String encUser = "OE/+CQlg1WQIjCubQppDtw==";
		String encPassword = "k/5XxgqVR2FFvGfsprTQGQ==";
		
		
		
		Map<String, String> systemEnv = System.getenv();
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		pbEnc.setAlgorithm(encType);
		pbEnc.setPassword(systemEnv.get("USERNAME"));		//암호화된 encUser, password를 복호화 하기 위한 준비
		
		
		Properties pros = new Properties(); // 복호화된 문자열을 mybatis-config.xml에 전달하기 위한 절차
		pros.put("username", pbEnc.decrypt(encUser));
		pros.put("password", pbEnc.decrypt(encPassword));
		
		

		try {
			is = Resources.getResourceAsStream(configFile);

			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

			if (sqlSessionFactory == null) {
				sqlSessionFactory = sqlSessionFactoryBuilder.build(is, pros);
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
