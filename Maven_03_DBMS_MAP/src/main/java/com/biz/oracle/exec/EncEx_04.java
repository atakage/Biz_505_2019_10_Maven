package com.biz.oracle.exec;

import java.util.Map;
import java.util.Set;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		Map<String, String> systemEnv = System.getenv();	// OS의 환경 변수값을 가져와 Map에 저장
		Set<String> keys = systemEnv.keySet();
		
		for(String s : keys) {
			
			System.out.printf("%s = %s\n", s, systemEnv.get(s));
		}
		
		
		
		
		
		String user = "";
		String password = "";
		
		String encUser = "OE/+CQlg1WQIjCubQppDtw==";
		String encPassword = "k/5XxgqVR2FFvGfsprTQGQ==";
		String salt = systemEnv.get("USERNAME");		// salt 값을 외부에 노출하지 않기 위해서 system(os)의 환경변수 중 일부값을 가져와 사용하기
														// 암호화키를 소스코드에서는 최소한 감추
		
		//String encUser = "DZrzS9qqyexFEmyrkMFOrA== ";
		//String encPassword = "YWq06EwBJBSQO6Kn4mRFlg==";
		
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();	//문자열을 암호화 시킴
		
		String encType = "PBEWithMD5AndDES";	//암호화 타입(MD5, DE5형식), 가장 쉽게 접근할 수 있는 암호화 타입
																// jasypt만으로 암호화 시키는 방법
		pbEnc.setPassword(salt);
		
		
		user = pbEnc.decrypt(encUser); //MD5, ED5 방식으로 암호화르 하고 key값으로 salt 문자열ㅇ르 사용
		password = pbEnc.decrypt(encPassword);
		
		System.out.printf("%s -> %s \n", encUser, user);
		
		System.out.printf("%s -> %s", encPassword, password);
		
		
		/*
		 * iolist2 -> DZrzS9qqyexFEmyrkMFOrA== 
			iolist2 -> YWq06EwBJBSQO6Kn4mRFlg==
		 * 
		 * 
		 */
		
		
	}

}
