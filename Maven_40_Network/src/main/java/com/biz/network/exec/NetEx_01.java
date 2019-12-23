package com.biz.network.exec;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetEx_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
		
		
		InetAddress naver = InetAddress.getByName("www.naver.com");	// www.naver.com 이라는 Domain name을 DNS에게
																// 조회하여 IP address를 가져옴
		
		System.out.println(naver);
		
		
		InetAddress callor = InetAddress.getByName("callor.com");
		
		System.out.println(callor);
		
		
		System.out.println(naver.getHostAddress());			// ip address만을 추출
		
		
		
		System.out.println(naver.getHostName());		// domain만을 추출
		
		
		InetAddress local = InetAddress.getLocalHost();				// 내 컴퓨터 NIC(Network Interface Card, 랜카드)에
		
													// 설정된 IP
		InetAddress loopBack = InetAddress.getLoopbackAddress();	// 내 컴퓨터 내부의 App들이 서로 통신을 하거나
														// 통신 test용으로 만들어진 특별한 IP
		
		
		System.out.println("local" + local);
		System.out.println("loopBack" + loopBack);
		
		
		/*
		 * 
		 * port: TCP/IP 프로토콜에서 1개의 IP 주소에 다수의 어플리케이션이 통신할 수 있도록 하는 구조
		 * 0~ 65535까지 사용할 수 있고 그 중 0 ~ 1023까지는 임의로 사용할 수 없도록 정해져 있음
		 * 사용자 port를 임의로 설정하여 사용하면 1개의 컴퓨터에서 여러 개의 통신 어플리케이션을 작동시킬 수 있음
		 * 
		 * 
		 */
	}

}
