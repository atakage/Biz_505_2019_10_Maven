package com.biz.sec.work;

import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBMS_SecEx_01 {			// 도구를 사용하여 문자열을 암호화 하는 Test 수행
	
	// 평문문자열(planText): 읽을 수 있는 문자열
	// 암호화된 문자열(cryptText): 읽을 수는 있지만 무슨 내용인지는 알 수 없는 형태

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		
		Map<String, String> envList = System.getenv(); // 환경변수 가져오기
		
		;
		
		
		
		

		/*
		 * 
		 * 1. 암호화의 종류: 단방향, 양방향 암ㅎ화
		 * 	가. 단방향 암호화 - 평문 >> 암호문으로 변경 가능하나 반대는 불가, 보안성은 유리하지만 사용에 제약이 따름
		 * 
		 * 
		 *  나. 양방향 암호화 - 평문 >> 암호문, 암호문 >> 평문 변경이 가능, 보안성이 떨어지나 사용에 편리함, 만약 salt Key가 노출되면 의미 없는 암호화가 됨
		 *  
		 *  
		 *  
		 *  jasypt는 양방향 암호화를 수행하고 쉽게 사용할 수 있는 형태
		 *  java에서 DBMS에 접근하기 위해 userID와 password를 사용해야 하는데 jdbc Connection 코드에 userId와 password가 노출되어 보안에 매우 취약
		 *  
		 * 	최소한 소스코드차원에서만이라도 userid와 password를 암호화하여 보안을 유지하기 위한 방법을 사용
		 * 	그런데 이 방법으로 단방향 암호화 기법은 사용이 불가, jdbc에서 DBMS로 userid와 password를 전송하는 과정에서
		 * 	평문으로 해당 데이터를 보내야 하기 때문에 암호화된 문자열을 다시 평문으로 복호화해야 함
		 * 	이런 용도로 사용하는 도구가 jasypt이고  그중에서 StandardPBEStringEncryptor를 많이 사용 
		 * 
		 */
		
		
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();		//Java에서 사용할 수 있는 암호화, 복호화를 수행하는 클래스
										
		
		
		
		
		
		
		
		pbEnc.setAlgorithm("PBEWithMD5AndDes");
		pbEnc.setPassword(envList.get("BIZ"));
		
		System.out.print("username>> ");
		String planUserName = scan.nextLine();
		
		System.out.print("password>> ");
		String planPassword = scan.nextLine();
		
		String encUserName = pbEnc.encrypt(planUserName);
		String encPassword = pbEnc.encrypt(planPassword);
		
		
		
		System.out.printf("username: %s,  %s\n", planUserName, encUserName);
		System.out.printf("password: %s,  %s\n", planPassword, encPassword);
		
		
		/*
		 * username:   Zfgy0hrL4tSEGLXN72gSxQ==
			password:   0wGZF4wtxrVjfn7qpmvgqQ==
		 * 
		 * 
		 */
	

	}

}
