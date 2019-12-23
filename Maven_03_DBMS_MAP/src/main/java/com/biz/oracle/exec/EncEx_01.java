package com.biz.oracle.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String user = "USERID";
		String password = "PASSWORD";
		String salt = "com.biz.oracle";
		
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();	//문자열을 암호화 시킴
		
		String encType = "PBEWithMD5AndDES";	//암호화 타입(MD5, DE5형식), 가장 쉽게 접근할 수 있는 암호화 타입
																// jasypt만으로 암호화 시키는 방법
		
		
		pbEnc.setAlgorithm(encType); //MD5, ED5 방식으로 암호화르 하고 key값으로 salt 문자열ㅇ르 사용
		pbEnc.setPassword(salt);
		
		String encUser = pbEnc.encrypt(user);
		String encPassword = pbEnc.encrypt(password);
		
		System.out.printf("%s -> %s \n", user, encUser);
		
		System.out.printf("%s -> %s", password, encPassword);
		
		
		/*
		 * iolist2 -> DZrzS9qqyexFEmyrkMFOrA== 
			iolist2 -> YWq06EwBJBSQO6Kn4mRFlg==
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
	}

}
